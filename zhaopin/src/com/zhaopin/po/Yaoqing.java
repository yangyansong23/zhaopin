package com.zhaopin.po;

import java.util.Date;

public class Yaoqing {
    private int yaoqingid;
    private int userid;
    private int schoolId;
    private int qiuzhiid;
    private String status;
    private Date yaoqingtime;

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

    public void setYaoqingtime(Date yaoqingtime) {
        this.yaoqingtime = yaoqingtime;
    }

}