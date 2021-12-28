package com.example.demo.entity;

public class Confirm {

    private Long confirm_id;

    private Long employee_id;

    private int isConfirm;

    private Long confirm_month;

    public Confirm() {

    };

    public Confirm(Long confirm_id, Long employee_id, int isConfirm, Long confirm_month) {

        this.confirm_id = confirm_id;

        this.employee_id = employee_id;

        this.isConfirm = isConfirm;

        this.confirm_month = confirm_month;
    }

    public Long getConfirm_id() {

        return confirm_id;
    }

    public Long getEmployee_id() {

        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {

        this.employee_id = employee_id;
    }

    public int getIsConfirm() {

        return isConfirm;
    }

    public void setIsConfirm(int isConfirm) {

        this.isConfirm = isConfirm;
    }

    public Long getConfirm_month() {

        return confirm_month;
    }

    public void setConfirm_month(Long confirm_month) {

        this.confirm_month = confirm_month;
    }
}
