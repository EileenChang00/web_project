package com.example.demo.controller;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.dao.ConfirmDAO;
import com.example.demo.entity.Confirm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ConfirmController {
    @Autowired

    ConfirmDAO dao;

    @GetMapping(value = "/confirm")

    public List<Confirm> retrieveOneConfirms() throws SQLException {

        return dao.findAll();

    }

    @PutMapping(value = "/confirm")
    public void processFormUpdate(@RequestBody Confirm confirm) throws SQLException {
        dao.update(confirm);
    }
}
