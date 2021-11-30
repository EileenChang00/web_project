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

            String sql = "select punch_id, punch_in, punch_out from punch";

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

                rs.getTimestamp("punch_out"));

    }

}