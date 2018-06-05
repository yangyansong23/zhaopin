package com.zhaopin.dao;

import java.sql.SQLException;

import com.zhaopin.po.Zhaopin;
import com.zhaopin.util.DAOSupport;

public class ZhaopinDAO extends DAOSupport {
    // 学校添加招聘信息
    public boolean add(Zhaopin zhaopin) {
        String sql = "insert into zhaopin (schoolid,z_jobname,z_salary,z_city,z_description,z_requirement,z_time,z_count) values(?,?,?,?,?,?,?,?)";
        Object[] params = new Object[] { zhaopin.getSchoolId(), zhaopin.getZ_jobname(), zhaopin.getZ_salary(),
                zhaopin.getZ_city(), zhaopin.getZ_desription(), zhaopin.getZ_requirements(), zhaopin.getZ_time(),
                zhaopin.getZ_count() };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            System.out.println("添加招聘信息失败");
            // e.printStackTrace();
        }

        if (i > 0) {
            return true;
        }
        return false;
    }

}
