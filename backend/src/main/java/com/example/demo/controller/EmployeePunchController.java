package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.dao.EmployeePunchDAO;
import com.example.demo.entity.EmployeePunch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeePunchController {
    @Autowired

    EmployeePunchDAO dao;

    @GetMapping(value = "/employee/overtime")

    public List<EmployeePunch> retrieveOneEmployees() throws SQLException {

        return dao.findAll();

    }

    @GetMapping(value = { "/search/id/{employee_id}" })

    public List<EmployeePunch> retrieveOneEmployee(@PathVariable("employee_id") Long employee_id) throws SQLException {

        return dao.findId(employee_id);

    }

    @GetMapping(value = { "/search/name/{employee_name}" })

    public List<EmployeePunch> retrieveOneEmployee(@PathVariable("employee_name") String employee_name)
            throws SQLException {

        return dao.findName(employee_name);

    }
}
