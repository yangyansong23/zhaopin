package com.zhaopin.po;

import java.io.Serializable;
import java.util.Date;

public class JobList implements Serializable {

    /**
     * 序列化号
     */
    private static final long serialVersionUID = 4846662832977932138L;
    private int shoolId;
    private String schoolName;
    private String schoolEmail;
    private String schoolLogo;
    private String schoolBrief;
    private int schoolSize;
    private String schoolLocate;
    private int zhaopinid;
    private String z_jobname;
    private String z_city;

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getSchoolBrief() {
        return schoolBrief;
    }

    public int getSchoolSize() {
        return schoolSize;
    }

    public void setSchoolSize(int schoolSize) {
        this.schoolSize = schoolSize;
    }

    public void setSchoolBrief(String schoolBrief) {
        this.schoolBrief = schoolBrief;
    }

    public String getSchoolLocate() {
        return schoolLocate;
    }

    public void setSchoolLocate(String schoolLocate) {
        this.schoolLocate = schoolLocate;
    }

    private String z_salary;
    private Date z_time;
    private String z_timeStr;
    private int z_count;
    private String z_description;
    private String z_requirements;

    public String getZ_description() {
        return z_description;
    }

    public void setZ_description(String z_description) {
        this.z_description = z_description;
    }

    public String getZ_requirements() {
        return z_requirements;
    }

    public void setZ_requirements(String z_requirements) {
        this.z_requirements = z_requirements;
    }

    public int getSchoolId() {
        return shoolId;
    }

    public void setShoolId(int shoolId) {
        this.shoolId = shoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolLogo() {
        return schoolLogo;
    }

    public void setSchoolLogo(String schoolLogo) {
        this.schoolLogo = schoolLogo;
    }

    public int getZhaopinid() {
        return zhaopinid;
    }

    public void setZhaopinid(int zhaopinid) {
        this.zhaopinid = zhaopinid;
    }

    public String getZ_jobname() {
        return z_jobname;
    }

    public void setZ_jobname(String z_jobname) {
        this.z_jobname = z_jobname;
    }

    public String getZ_city() {
        return z_city;
    }

    public void setZ_city(String z_city) {
        this.z_city = z_city;
    }

    public String getZ_salary() {
        return z_salary;
    }

    public void setZ_salary(String z_salary) {
        this.z_salary = z_salary;
    }

    public Date getZ_time() {
        return z_time;
    }

    public void setZ_time(Date z_time) {
        this.z_time = z_time;
    }

    public String getZ_timeStr() {
        return z_timeStr;
    }

    public void setZ_timeStr(String z_timeStr) {
        this.z_timeStr = z_timeStr;
    }

    public int getZ_count() {
        return z_count;
    }

    public void setZ_count(int z_count) {
        this.z_count = z_count;
    }

}
