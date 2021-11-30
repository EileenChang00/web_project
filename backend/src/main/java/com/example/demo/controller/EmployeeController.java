package com.example.demo.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.EmployeeDAO;

import com.example.demo.entity.Employee;

@RestController

public class EmployeeController {

    @Autowired

    EmployeeDAO dao;

    @GetMapping(value = "/employee")

    public List<Employee> retrieveOneEmployees() throws SQLException {

        return dao.findAll();

    }

    @PostMapping(value = "/employee")
    public void processFormCreate(@RequestBody Employee employee) throws SQLException {
        dao.insert(employee);

    }
    @PutMapping(value = "/employee")
    public void processFormUpdate(@RequestBody Employee employee) throws SQLException {
        dao.update(employee);
    }

}