package com.example.demo.entity;

import java.sql.Timestamp;

public class Punch {

    private Long punch_id;

    private Timestamp punch_in;

    private Timestamp punch_out;

    private Long employee_id;

    private String punch_state;

    public Punch() {

    }

    public Punch(Long punch_id, Timestamp punch_in, Timestamp punch_out, Long employee_id, String punch_state) {
        this.punch_id = punch_id;

        this.punch_in = punch_in;

        this.punch_out = punch_out;

        this.employee_id = employee_id;

        this.punch_state = punch_state;

    }

    public Long getPunch_id() {

        return punch_id;

    }

    public Timestamp getPunch_in() {

        return punch_in;

    }

    public void setPunch_in(Timestamp punch_in) {

        this.punch_in = punch_in;

    }

    public Timestamp getPunch_out() {

        return punch_out;
    }

    public void setPunch_out(Timestamp punch_out) {

        this.punch_out = punch_out;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getPunch_state() {

        return punch_state;

    }

    public void setPunch_state(String punch_state) {

        this.punch_state = punch_state;

    }
}
