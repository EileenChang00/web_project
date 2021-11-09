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

import com.example.demo.entity.Employee;

@Repository

public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired

    private DataSource dataSource;

    // jdbc

    public List<Employee> findAll() {

        List<Employee> employee = new ArrayList<Employee>();

        try {

            Connection conn = dataSource.getConnection();

            String sql = "select employee_id, employee_name, employee_dep from employee";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                employee.add(getEmployee(rs));

            }

        } catch (Exception e) {

            // something wrong

            System.out.println(e);

        }

        return employee;

    }

    public Employee getEmployee(ResultSet rs) throws SQLException {

        return new Employee(

                rs.getLong("employee_id"),

                rs.getString("employee_name"),

                rs.getString("employee_dep"));

    }

}