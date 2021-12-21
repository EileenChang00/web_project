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

import com.example.demo.entity.Punch;

@Repository

public class PunchDAOImpl implements PunchDAO {

    @Autowired

    private DataSource dataSource;

    // jdbc

    public List<Punch> findAll() {

        List<Punch> punch = new ArrayList<Punch>();

        try {

            Connection conn = dataSource.getConnection();

            String sql = "select punch_id, punch_in, punch_out, employee_id from punch";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                punch.add(getPunch(rs));

            }

        } catch (Exception e) {

            // something wrong

            System.out.println(e);

        }

        return punch;

    }

    public Punch getPunch(ResultSet rs) throws SQLException {

        return new Punch(

                rs.getLong("punch_id"),

                rs.getTimestamp("punch_in"),

                rs.getTimestamp("punch_out"),
                
                rs.getLong("employee_id"));

    }

    public int insert(Punch punch) {

        int result = 0;
        try {
          Connection conn = dataSource.getConnection();
          String sql = "insert into punch (punch_id, punch_in, punch_out, employee_id) values(?, ?, ?, ?)";
    
          PreparedStatement stmt = conn.prepareStatement(sql);
    
          stmt.setLong(1, punch.getPunch_id());
          stmt.setTimestamp(2, punch.getPunch_in());
          stmt.setTimestamp(3, punch.getPunch_out());
          stmt.setLong(4, punch.getEmployee_id());
    
          result = stmt.executeUpdate();
    
        } catch (Exception e) {
          // something wrong
          System.out.println(e);
        }
        return result;
      }
    
      public int update(Punch punch) {
    
        int result = 0;
        try {
          Connection conn = dataSource.getConnection();
          String sql = "update punch set punch_id=?, punch_in=?, punch_out=? where employee_id =?";
    
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setLong(1, punch.getPunch_id());
          stmt.setTimestamp(2, punch.getPunch_in());
          stmt.setTimestamp(3, punch.getPunch_out());
          stmt.setLong(4, punch.getEmployee_id());
    
          result = stmt.executeUpdate();
    
        } catch (Exception e) {
          // something wrong
          System.out.println(e);
        }
        return result;
      }
    
      public Punch findOne(Long employee_id) {
    
        Punch punch = new Punch();
        try {
    
          Connection conn = dataSource.getConnection();
          String sql = "select punch_id, punch_in, punch_out, employee_id from punch where employee_id = ?";
          PreparedStatement stmt = conn.prepareStatement(sql);
    
          stmt.setLong(1, employee_id);
          ResultSet rs = stmt.executeQuery();
    
          if (rs.next()) {
            punch = getPunch(rs);
          }
    
        } catch (Exception e) {
    
          // something wrong
          System.out.println(e);
    
        }
        return punch;
      }
    
      public int delete(Long id) {
    
        int result = 0;
        try {
    
          Connection conn = dataSource.getConnection();
          String sql = "delete from punch where employee_id =?";
          PreparedStatement stmt = conn.prepareStatement(sql);
          stmt.setLong(1, id);
          result = stmt.executeUpdate();
    
        } catch (Exception e) {
    
          // something wrong
          System.out.println(e);
    
        }
        return result;
      }

}