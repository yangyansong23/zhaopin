package com.zhaopin.po;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Qiuzhixin {
    private int qiuzhixinid;
    private int userid;
    private String username;
    private int schoolId;
    private String schoolname;
    private int zhaopinid;
    private String qzx_jobname;
    private String status;
    private Date qiuzhitime;
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

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

    public String getQiuzhitimeStr() {
        return formatter.format(qiuzhitime);
    }

    public void setQiuzhitime(Date qiuzhitime) {
        this.qiuzhitime = qiuzhitime;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getQzx_jobname() {
        return qzx_jobname;
    }

    public void setQzx_jobname(String qzx_jobname) {
        this.qzx_jobname = qzx_jobname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}