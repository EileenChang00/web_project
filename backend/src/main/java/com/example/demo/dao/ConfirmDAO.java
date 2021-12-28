package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Confirm;

public interface ConfirmDAO {

    public List<Confirm> findAll();

    public int update(Confirm confirm);

}
