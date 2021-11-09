package com.example.demo.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.EmployeeDAO;

import com.example.demo.entity.Employee;

@RestController

public class EmployeeController {

    @Autowired

    EmployeeDAO dao;

    @GetMapping(value = "/employee")

    public List<Employee> retrieveEmployee() throws SQLException {

        return dao.findAll();

    }

}