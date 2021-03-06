package com.example.demo.entity;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class EmployeePunch {

    private Long employee_id;

    private String employee_name;

    private String employee_dep;

    private Timestamp in;

    private Timestamp out;

    private String punch_state;

    public EmployeePunch() {

    }

    public EmployeePunch(Long employee_id, String employee_name, String employee_dep, Timestamp in, Timestamp out,
            String punch_state) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_dep = employee_dep;
        this.in = in;
        this.out = out;
        this.punch_state = punch_state;
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

    public String getIn() {

        SimpleDateFormat timeformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String inTime = timeformat.format(in);
        System.out.println(in);

        return inTime;

    }

    public void setIn(Timestamp in) {
        System.out.println(in);
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

    public Long getTime_diff() {
        // calculate overtime hours
        Timestamp startTime = this.in;
        Timestamp endTime = this.out;

        Long diff = endTime.getTime() - startTime.getTime();

        TimeUnit time = TimeUnit.HOURS;
        long time_diff = time.convert(diff, TimeUnit.MILLISECONDS);

        return time_diff;
    }

    public String getMonth_sep() {

        SimpleDateFormat timeformat = new SimpleDateFormat("MM");
        String month = timeformat.format(this.in);

        return month;
    }

    public String getPunch_state() {
        return punch_state;
    }

    public void setPunch_state(String punch_state) {
        this.punch_state = punch_state;
    }
}
