package com.zhaopin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhaopin.po.JobList;
import com.zhaopin.util.DAOSupport;

public class JobSearchDAO extends DAOSupport {

    // 输入条件为空
    public List<JobList> query() {
        List<JobList> list = new ArrayList<JobList>();
        String sql = "SELECT * from schools c,zhaopin zp where c.schoolid=zp.schoolid order by Z_time DESC";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到全部JobList数据啦！！");
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
                    joblist.setZ_time((Date) tmp[i++]);
                    joblist.setZ_count(Integer.parseInt(tmp[i++].toString()));

                    list.add(joblist);

                }

            } else {
                System.out.println("没查到全部JobList数据！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    // 输入关键字进行查询
    public List<JobList> query(String keyword) {
        List<JobList> list = new ArrayList<JobList>();
        String sql = "SELECT * from schools c,zhaopin zp where c.schoolid=zp.schoolid and z_jobname like \"%" + keyword
                + "%\" or schoolname like \"%" + keyword + "%\" order by Z_time DESC";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到按照关键字过滤的数据啦！！");
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
                    i++;
                    joblist.setZ_jobname(tmp[i++].toString());
                    joblist.setZ_salary(tmp[i++].toString());
                    joblist.setZ_city(tmp[i++].toString());
                    joblist.setZ_description(tmp[i++].toString());
                    joblist.setZ_requirements(tmp[i++].toString());
                    joblist.setZ_time((Date) tmp[i++]);
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

    public List<JobList> query(int schoolid) {
        List<JobList> list = new ArrayList<JobList>();
        String sql = "SELECT * from zhaopin zp where zp.schoolid=" + schoolid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到按照schoolid过滤的数据啦！！");
                JobList joblist = null;
                for (Object[] tmp : data) {
                    joblist = new JobList();
                    int i = 0;
                    joblist.setZhaopinid(Integer.parseInt(tmp[i++].toString()));
                    joblist.setShoolId(Integer.parseInt(tmp[i++].toString()));
                    joblist.setZ_jobname(tmp[i++].toString());
                    joblist.setZ_salary(tmp[i++].toString());
                    joblist.setZ_city(tmp[i++].toString());
                    joblist.setZ_description(tmp[i++].toString());
                    joblist.setZ_requirements(tmp[i++].toString());
                    joblist.setZ_time((Date) tmp[i++]);
                    joblist.setZ_count(Integer.parseInt(tmp[i++].toString()));
                    joblist.setZ_category(tmp[i++].toString());
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

}
