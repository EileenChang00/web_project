package com.example.demo.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Punch {

    private Long id;

    private Timestamp in;

    private Timestamp out;

    public Punch() {

    }

    public Punch(Long id, Timestamp in, Timestamp out) {
        this.id = id;

        this.in = in;

        this.out = out;

    }

    public Long getId() {

        return id;

    }

    public void setId(Long id) {

        this.id = id;

    }

    public String getIn() {

        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String inTime = timeformat.format(in);

        return inTime;

    }

    public void setIn(Timestamp in) {

        this.in = in;

    }

    public String getOut() {

        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String outTime = timeformat.format(out);

        return outTime;
    }

    public void setOut(Timestamp out) {

        this.out = out;
    }
}
