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

            String sql = "select employee_id, employee_name, employee_dep, id from employee";

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

                rs.getString("employee_dep"),

                rs.getLong("id"));

    }

    public int insert(Employee employee) {

        int result = 0;
        try {
          Connection conn = dataSource.getConnection();
          String sql = "insert into employee (employee_id, employee_name, employee_dep) values(?, ?, ?)";
      
          PreparedStatement stmt = conn.prepareStatement(sql);
      
          
          stmt.setLong(1, employee.getEmployee_id());
          stmt.setString(2, employee.getEmployee_name());
          stmt.setString(3, employee.getEmployee_dep());
      
          result = stmt.executeUpdate();
      
        } catch(Exception e) {
          //something wrong
          System.out.println(e);
        }
        return result;
      }
      
      public int update(Employee employee) {
      
        int result = 0;
        try {
          Connection conn = dataSource.getConnection();
          String sql = "update employee set employee_id=?, employee_name=?, employee_dep=? where id =?";
      
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setLong(1, employee.getEmployee_id());
          stmt.setString(2, employee.getEmployee_name());
          stmt.setString(3, employee.getEmployee_dep());
          stmt.setLong(4, employee.getId());
      
          result = stmt.executeUpdate();
      
        } catch(Exception e) {
          //something wrong
          System.out.println(e);
        }
        return result;
      }
    public Employee findOne(Long id) {

        Employee employee = new Employee();
        try {

          Connection conn = dataSource.getConnection();
          String sql = "select employee_id, employee_name, employee_dep from employee where employee_id = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
    
          stmt.setLong(1, id);
          ResultSet rs = stmt.executeQuery();     
    
          if (rs.next()) {
            employee = getEmployee(rs);
          }
    
        } catch(Exception e) {

          //something wrong
          System.out.println(e);
    
        }
        return employee;
     }
     
    public int delete(Long id) {

        int result = 0;    
        try {
      
          Connection conn = dataSource.getConnection();
          String sql = "delete from employee where employee_id =?";
          PreparedStatement stmt = conn.prepareStatement(sql); 
          stmt.setLong(1, id);   
          result = stmt.executeUpdate();

        } catch(Exception e) {
    
          //something wrong
          System.out.println(e);
      
        }
        return result;
       }

}