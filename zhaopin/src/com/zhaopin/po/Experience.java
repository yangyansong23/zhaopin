package com.zhaopin.po;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Experience implements Serializable {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -6761145071736105695L;
    private int expid;
    private int userid;
    private String sname;
    private String position;
    private Date starttime;
    private Date endtime;
    private String program;
    private String duty;
    private String result;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public int getExpid() {
        return expid;
    }

    public void setExpid(int expid) {
        this.expid = expid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStarttime() {
        return starttime;
    }

    public String getStarttimeStr() {
        return formatter.format(starttime);
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public String getEndtimeStr() {
        return formatter.format(endtime);
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}