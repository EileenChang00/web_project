package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.dao.EmployeePunchDAO;
import com.example.demo.entity.EmployeePunch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePunchController {
    @Autowired

    EmployeePunchDAO dao;

    @GetMapping(value = "/employee/overtime")

    public List<EmployeePunch> retrieveOneEmployees() throws SQLException {

        return dao.findAll();

    }
}
