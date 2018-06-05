package com.zhaopin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhaopin.po.JobList;
import com.zhaopin.util.DAOSupport;

public class JobListDAO extends DAOSupport {
    //
    public List<JobList> queryOrderByCount() {
        List<JobList> list = new ArrayList<JobList>();
        String sql = "SELECT * from schools c,zhaopin zp where c.schoolid=zp.schoolid order by Z_count DESC";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到数据啦！！");
                JobList joblist = null;
                for (Object[] tmp : data) {
                    joblist = new JobList();
                    int i = 0;
                    joblist.setShoolId(Integer.parseInt(tmp[i++].toString()));
                    joblist.setSchoolName(tmp[i++].toString());
                    i++;
                    joblist.setSchoolEmail(tmp[i++].toString());
                    joblist.setSchoolLogo(tmp[i++].toString());
                    joblist.setSchoolBrief(tmp[i++].toString());
                    joblist.setSchoolSize(Integer.parseInt(tmp[i++].toString()));
                    joblist.setSchoolLocate(tmp[i++].toString());
                    joblist.setZhaopinid(Integer.parseInt(tmp[i++].toString()));
                    joblist.setShoolId(Integer.parseInt(tmp[i++].toString()));
                    joblist.setZ_jobname(tmp[i++].toString());
                    joblist.setZ_salary(tmp[i++].toString());
                    joblist.setZ_city(tmp[i++].toString());
                    joblist.setZ_description(tmp[i++].toString());
                    joblist.setZ_requirements(tmp[i++].toString());
                    joblist.setZ_timeStr(tmp[i++].toString());
                    joblist.setZ_count(Integer.parseInt(tmp[i++].toString()));

                    list.add(joblist);

                }

            } else {
                System.out.println("没查到数据！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public List<JobList> queryOrderByTime() {
        List<JobList> list = new ArrayList<JobList>();
        String sql = "SELECT * from schools c,zhaopin zp where c.schoolid=zp.schoolid order by Z_time DESC";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到数据啦！！");
                JobList joblist = null;
                for (Object[] tmp : data) {
                    joblist = new JobList();
                    int i = 0;
                    joblist.setShoolId(Integer.parseInt(tmp[i++].toString()));
                    joblist.setSchoolName(tmp[i++].toString());
                    i++;
                    joblist.setSchoolEmail(tmp[i++].toString());
                    joblist.setSchoolLogo(tmp[i++].toString());
                    joblist.setSchoolBrief(tmp[i++].toString());
                    joblist.setSchoolSize(Integer.parseInt(tmp[i++].toString()));
                    joblist.setSchoolLocate(tmp[i++].toString());
                    joblist.setZhaopinid(Integer.parseInt(tmp[i++].toString()));
                    joblist.setShoolId(Integer.parseInt(tmp[i++].toString()));
                    joblist.setZ_jobname(tmp[i++].toString());
                    joblist.setZ_salary(tmp[i++].toString());
                    joblist.setZ_city(tmp[i++].toString());
                    joblist.setZ_description(tmp[i++].toString());
                    joblist.setZ_requirements(tmp[i++].toString());
                    joblist.setZ_timeStr(tmp[i++].toString());
                    joblist.setZ_count(Integer.parseInt(tmp[i++].toString()));

                    list.add(joblist);

                }

            } else {
                System.out.println("没查到数据！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public JobList queryAll() {

        String sql = "SELECT * from schools c,zhaopin zp where c.schoolid=zp.schoolid and 1=?";
        try {
            List<Object[]> data = this.executeDQL(sql, new Object[] { 1 });
            if (null != data && !data.isEmpty()) {
                System.out.println("查到数据啦！！");
                Object[] tmp = data.get(0);
                JobList jobdetail = new JobList();

                int i = 0;
                jobdetail.setShoolId(Integer.parseInt(tmp[i++].toString()));
                jobdetail.setSchoolName(tmp[i++].toString());
                i++;
                jobdetail.setSchoolEmail(tmp[i++].toString());
                jobdetail.setSchoolLogo(tmp[i++].toString());
                jobdetail.setSchoolBrief(tmp[i++].toString());
                jobdetail.setSchoolSize(Integer.parseInt(tmp[i++].toString()));
                jobdetail.setSchoolLocate(tmp[i++].toString());
                jobdetail.setZhaopinid(Integer.parseInt(tmp[i++].toString()));
                jobdetail.setShoolId(Integer.parseInt(tmp[i++].toString()));
                jobdetail.setZ_jobname(tmp[i++].toString());
                jobdetail.setZ_salary(tmp[i++].toString());
                jobdetail.setZ_city(tmp[i++].toString());
                jobdetail.setZ_description(tmp[i++].toString());
                jobdetail.setZ_requirements(tmp[i++].toString());
                jobdetail.setZ_timeStr(tmp[i++].toString());
                jobdetail.setZ_count(Integer.parseInt(tmp[i++].toString()));

                return jobdetail;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public JobList queryDetailById(int zid2) {

        int zid = zid2;

        String sql = "SELECT * from schools c,zhaopin zp where c.schoolid=zp.schoolid and zhaopinid = ? ";
        try {
            List<Object[]> data = this.executeDQL(sql, new Object[] { zid });
            if (null != data && !data.isEmpty()) {
                System.out.println("查到数据啦！！");
                Object[] tmp = data.get(0);
                JobList jobdetail = new JobList();

                int i = 0;
                jobdetail.setShoolId(Integer.parseInt(tmp[i++].toString()));
                jobdetail.setSchoolName(tmp[i++].toString());
                i++;
                jobdetail.setSchoolEmail(tmp[i++].toString());
                jobdetail.setSchoolLogo(tmp[i++].toString());
                jobdetail.setSchoolBrief(tmp[i++].toString());
                jobdetail.setSchoolSize(Integer.parseInt(tmp[i++].toString()));
                jobdetail.setSchoolLocate(tmp[i++].toString());
                jobdetail.setZhaopinid(Integer.parseInt(tmp[i++].toString()));
                jobdetail.setShoolId(Integer.parseInt(tmp[i++].toString()));
                jobdetail.setZ_jobname(tmp[i++].toString());
                jobdetail.setZ_salary(tmp[i++].toString());
                jobdetail.setZ_city(tmp[i++].toString());
                jobdetail.setZ_description(tmp[i++].toString());
                jobdetail.setZ_requirements(tmp[i++].toString());
                jobdetail.setZ_timeStr(tmp[i++].toString());
                jobdetail.setZ_count(Integer.parseInt(tmp[i++].toString()));

                return jobdetail;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

}
