package com.example.demo.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

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
    @GetMapping(value = {"/employee/{id}"})

    public Employee retrieveOneEmployee(@PathVariable("id") Long id) throws SQLException{

       return dao.findOne(id);

    }
    @DeleteMapping(value = "/employee/{id}")
   
    public void deleteEmployee(@PathVariable("id") Long id) {
   
       dao.delete(id);
   
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