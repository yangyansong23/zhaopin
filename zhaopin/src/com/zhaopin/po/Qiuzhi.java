package com.zhaopin.po;

import java.util.Date;

public class Qiuzhi {
    private int qiuzhiid;
    private int userid;
    private String q_jobname;
    private String q_salary;
    private String q_city;
    private Date q_time;
    private String q_describe;

    public String getQ_jobname() {
        return q_jobname;
    }

    public void setQ_jobname(String q_jobname) {
        this.q_jobname = q_jobname;
    }

    public String getQ_describe() {
        return q_describe;
    }

    public void setQ_describe(String q_describe) {
        this.q_describe = q_describe;
    }

    public int getQiuzhiid() {
        return qiuzhiid;
    }

    public void setQiuzhiid(int qiuzhiid) {
        this.qiuzhiid = qiuzhiid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getQ_salary() {
        return q_salary;
    }

    public void setQ_salary(String q_salary) {
        this.q_salary = q_salary;
    }

    public String getQ_city() {
        return q_city;
    }

    public void setQ_city(String q_city) {
        this.q_city = q_city;
    }

    public Date getQ_time() {
        return q_time;
    }

    public void setQ_time(Date q_time) {
        this.q_time = q_time;
    }

}