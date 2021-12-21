package com.example.demo.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.PunchDAO;

import com.example.demo.entity.Punch;

@RestController

public class PunchController {

    @Autowired

    PunchDAO dao;

    @GetMapping(value = "/punch")

    public List<Punch> retrievePunch() throws SQLException {

        return dao.findAll();

    }

    @GetMapping(value = { "/punch/{employee_id}" })

    public Punch retrieveOnePunch(@PathVariable("employee_id") Long employee_id) throws SQLException {

        return dao.findOne(employee_id);

    }

    @DeleteMapping(value = "/punch/{id}")

    public void deleteEmployee(@PathVariable("id") Long id) {

        dao.delete(id);

    }

    @PostMapping(value = "/punch")
    public void processFormCreate(@RequestBody Punch punch) throws SQLException {
        dao.insert(punch);

    }

    @PutMapping(value = "/punch")
    public void processFormUpdate(@RequestBody Punch punch) throws SQLException {
        dao.update(punch);
    }

}