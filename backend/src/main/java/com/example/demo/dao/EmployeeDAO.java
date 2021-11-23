package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO {

    public List<Employee> findAll();
    public Employee findOne(Long id);
    public int delete(Long id);

}