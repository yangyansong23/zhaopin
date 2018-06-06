package com.zhaopin.po;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Yaoqing {
    private int yaoqingid;
    private int userid;
    private String username;
    private int schoolId;
    private String schoolname;
    private int qiuzhiid;
    private String qz_jobname;
    private String status;
    private Date yaoqingtime;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public int getYaoqingid() {
        return yaoqingid;
    }

    public void setYaoqingid(int yaoqingid) {
        this.yaoqingid = yaoqingid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public int getQiuzhiid() {
        return qiuzhiid;
    }

    public void setQiuzhiid(int qiuzhiid) {
        this.qiuzhiid = qiuzhiid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getYaoqingtime() {
        return yaoqingtime;
    }

    public String getYaoqingtimeStr() {
        return formatter.format(yaoqingtime);
    }

    public void setYaoqingtime(Date yaoqingtime) {
        this.yaoqingtime = yaoqingtime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getQz_jobname() {
        return qz_jobname;
    }

    public void setQz_jobname(String qz_jobname) {
        this.qz_jobname = qz_jobname;
    }

}