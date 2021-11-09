package com.example.demo.entity;

public class Employee {

    private Long id;

    private String name;

    private String dep;

    public Employee() {

    }

    public Employee(Long id, String name, String dep) {

        this.id = id;

        this.name = name;

        this.dep = dep;

    }

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

    public String getDep() {

        return dep;

    }

    public void setDep(String dep) {

        this.dep = dep;

    }

}