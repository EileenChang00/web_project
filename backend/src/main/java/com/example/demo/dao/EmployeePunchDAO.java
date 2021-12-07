package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.EmployeePunch;

public interface EmployeePunchDAO {
    public List<EmployeePunch> findAll();

    public EmployeePunch findOne(Long employee_id);
}
