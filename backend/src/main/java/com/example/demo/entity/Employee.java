package com.example.demo.entity;

public class Employee {

    private Long employee_id;

    private String employee_name;

    private String employee_dep;

    private Long id;

    private String employee_password;

    public Employee() {

    }

    public Employee(Long employee_id, String employee_name, String employee_dep, String employee_password, Long id) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_dep = employee_dep;
        this.employee_password = employee_password;
        this.id = id;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployee_dep() {
        return employee_dep;
    }

    public void setEmployee_dep(String employee_dep) {
        this.employee_dep = employee_dep;
    }

    public String getEmployee_password() {
        return employee_password;
    }

    public void setEmployee_password(String employee_password) {
        this.employee_password = employee_password;
    }

    public Long getId() {
        return id;
    }

}