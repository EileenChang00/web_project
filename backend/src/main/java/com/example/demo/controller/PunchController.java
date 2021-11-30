package com.example.demo.controller;

import java.sql.SQLException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.GetMapping;

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

}