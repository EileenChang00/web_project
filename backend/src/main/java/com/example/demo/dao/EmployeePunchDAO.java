package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.EmployeePunch;

public interface EmployeePunchDAO {
    public List<EmployeePunch> findAll();

    public List<EmployeePunch> findId(Long employee_id);

    public List<EmployeePunch> findName(String employee_name);
}
