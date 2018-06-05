package com.zhaopin.po;

import java.util.Date;

public class Qiuzhixin {
    private int qiuzhixinid;
    private int userid;
    private int schoolId;
    private int zhaopinid;
    private String status;
    private Date qiuzhitime;

    public int getQiuzhixinid() {
        return qiuzhixinid;
    }

    public void setQiuzhixinid(int qiuzhixinid) {
        this.qiuzhixinid = qiuzhixinid;
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

    public int getZhaopinid() {
        return zhaopinid;
    }

    public void setZhaopinid(int zhaopinid) {
        this.zhaopinid = zhaopinid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getQiuzhitime() {
        return qiuzhitime;
    }

    public void setQiuzhitime(Date qiuzhitime) {
        this.qiuzhitime = qiuzhitime;
    }

}