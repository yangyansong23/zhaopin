package com.zhaopin.po;

import java.util.Date;

public class Zhaopin {
    private int zhaopinid;
    private int schoolId;
    private String z_jobname;
    private String z_salary;
    private String z_city;
    private String z_description;
    private String z_requirements;
    private Date z_time;
    private int z_count;

    public int getZhaopinid() {
        return zhaopinid;
    }

    public void setZhaopinid(int zhaopinid) {
        this.zhaopinid = zhaopinid;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getZ_jobname() {
        return z_jobname;
    }

    public void setZ_jobname(String z_jobname) {
        this.z_jobname = z_jobname;
    }

    public String getZ_salary() {
        return z_salary;
    }

    public void setZ_salary(String z_salary) {
        this.z_salary = z_salary;
    }

    public String getZ_city() {
        return z_city;
    }

    public void setZ_city(String z_city) {
        this.z_city = z_city;
    }

    public String getZ_desription() {
        return z_description;
    }

    public void setZ_desription(String z_description) {
        this.z_description = z_description;
    }

    public String getZ_requirements() {
        return z_requirements;
    }

    public void setZ_requirements(String z_requirements) {
        this.z_requirements = z_requirements;
    }

    public Date getZ_time() {
        return z_time;
    }

    public void setZ_time(Date z_time) {
        this.z_time = z_time;
    }

    public int getZ_count() {
        return z_count;
    }

    public void setZ_count(int z_count) {
        this.z_count = z_count;
    }

}