package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import javax.sql.DataSource;

import com.example.demo.entity.Confirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.sql.DataSource;

@Repository

public class ConfirmDAOImpl implements ConfirmDAO {

    @Autowired

    private DataSource dataSource;

    // jdbc
    public List<Confirm> findAll() {

        List<Confirm> confirm = new ArrayList<Confirm>();

        try {

            Connection conn = dataSource.getConnection();

            String sql = "select confirm_id, employee_id, isConfirm, confirm_month from confirm";

            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                confirm.add(getConfirm(rs));

            }

        } catch (Exception e) {

            // something wrong

            System.out.println(e);

        }

        return confirm;

    }

    public Confirm getConfirm(ResultSet rs) throws SQLException {

        return new Confirm(

                rs.getLong("confirm_id"),

                rs.getLong("employee_id"),

                rs.getInt("isConfirm"),

                rs.getLong("confirm_month"));
    }

    public int update(Confirm confirm) {

        int result = 0;
        try {
            Connection conn = dataSource.getConnection();
            String sql = "update confirm set isConfirm=? where employee_id =? and confirm_month=?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, confirm.getIsConfirm());
            stmt.setLong(2, confirm.getEmployee_id());
            stmt.setLong(3, confirm.getConfirm_month());

            result = stmt.executeUpdate();

        } catch (Exception e) {
            // something wrong
            System.out.println(e);
        }
        return result;
    }
}
