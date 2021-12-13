package com.example.demo.dao;

import java.util.ArrayList;

import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EmployeePunch;

@Repository

public class EmployeePunchDAOImpl implements EmployeePunchDAO {

    @Autowired

    private DataSource dataSource;

    // jdbc

    public List<EmployeePunch> findAll() {

        List<EmployeePunch> employeePunch = new ArrayList<EmployeePunch>();

        try {

            Connection conn = dataSource.getConnection();

            String sql = "select employee.employee_id, employee_name, employee_dep, punch_in, punch_out from employee, punch where employee.employee_id = punch.employee_id";

            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                employeePunch.add(getEmployeePunch(rs));
            }

        } catch (Exception e) {

            // something wrong
            System.out.println(e);
        }
        return employeePunch;
    }

    public EmployeePunch findId(Long employee_id) {

        EmployeePunch employeePunch = new EmployeePunch();
        try {

            Connection conn = dataSource.getConnection();
            String sql = "select employee.employee_id, employee_name, employee_dep, id, punch_in, punch_out from employee left join punch on punch.employee_id=employee.employee_id where punch.employee_id = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, employee_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employeePunch = getEmployeePunch(rs);
            }

        } catch (Exception e) {

            // something wrong
            System.out.println(e);

        }
        return employeePunch;
    }

    public EmployeePunch findName(String employee_name) {

        EmployeePunch employeePunch = new EmployeePunch();
        try {

            Connection conn = dataSource.getConnection();
            String sql = "select employee.employee_id, employee_name, employee_dep, id, punch_in, punch_out from employee left join punch on punch.employee_id=employee.employee_id where employee.employee_name = ?;";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, employee_name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                employeePunch = getEmployeePunch(rs);
            }

        } catch (Exception e) {

            // something wrong
            System.out.println(e);

        }
        return employeePunch;
    }

    public EmployeePunch getEmployeePunch(ResultSet rs) throws SQLException {

        return new EmployeePunch(

                rs.getLong("employee_id"),

                rs.getString("employee_name"),

                rs.getString("employee_dep"),

                rs.getTimestamp("punch_in"),

                rs.getTimestamp("punch_out"));

    }

}
