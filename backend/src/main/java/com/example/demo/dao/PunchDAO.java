package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Punch;

public interface PunchDAO {

    public List<Punch> findAll();

    public Punch findOne(Long employee_id);

    public int delete(Long id);

    public int insert(Punch employee);

    public int update(Punch employee);

}