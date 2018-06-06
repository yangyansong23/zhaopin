package com.zhaopin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhaopin.po.JobList;
import com.zhaopin.util.DAOSupport;

public class JobListDAO extends DAOSupport {
    // 获取按count排序的jobList列表
    public List<JobList> queryOrderByCount() {
        List<JobList> list = new ArrayList<JobList>();
        String sql = "SELECT * from schools c,zhaopin zp where c.schoolid=zp.schoolid order by Z_count DESC";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到按count排序的jobList数据啦！！！");
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
                System.out.println("没查到JobList数据！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    // 获取按时间time排序的jobList列表
    public List<JobList> queryOrderByTime() {
        List<JobList> list = new ArrayList<JobList>();
        String sql = "SELECT * from schools c,zhaopin zp where c.schoolid=zp.schoolid order by Z_time DESC";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到按时间排序的JobList数据啦！！");
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
                System.out.println("没查到按时间排序的JobList数据！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    // 获取jobList详细信息
    public JobList queryAll() {

        String sql = "SELECT * from schools c,zhaopin zp where c.schoolid=zp.schoolid and 1=?";
        try {
            List<Object[]> data = this.executeDQL(sql, new Object[] { 1 });
            if (null != data && !data.isEmpty()) {
                System.out.println("查到jobdetail数据啦！！");
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
                jobdetail.setZ_time((Date) tmp[i++]);
                jobdetail.setZ_count(Integer.parseInt(tmp[i++].toString()));

                return jobdetail;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public JobList queryDetailById(int zid) {

        String sql = "SELECT * from schools c,zhaopin zp where c.schoolid=zp.schoolid and zhaopinid = ? ";
        try {
            List<Object[]> data = this.executeDQL(sql, new Object[] { zid });
            if (null != data && !data.isEmpty()) {
                System.out.println("查到按照zhaopinid过滤的Joblist数据啦！！");
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
                jobdetail.setZ_time((Date) tmp[i++]);
                jobdetail.setZ_count(Integer.parseInt(tmp[i++].toString()));

                return jobdetail;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
