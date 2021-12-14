package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findOne(Long employee_id);

    public int delete(Long id);

    public int insert(Employee employee);

    public int update(Employee employee);

}