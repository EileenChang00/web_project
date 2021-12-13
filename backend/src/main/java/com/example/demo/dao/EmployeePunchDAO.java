package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.EmployeePunch;

public interface EmployeePunchDAO {
    public List<EmployeePunch> findAll();

    public EmployeePunch findId(Long employee_id);

    public EmployeePunch findName(String employee_name);
}
