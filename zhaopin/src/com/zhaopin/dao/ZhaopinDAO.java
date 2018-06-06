package com.zhaopin.dao;

import java.sql.SQLException;
import java.util.List;

import com.zhaopin.po.Zhaopin;
import com.zhaopin.util.DAOSupport;

public class ZhaopinDAO extends DAOSupport {

    // 添加学校招聘信息
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

    // 修改学校招聘信息
    public boolean update(Zhaopin zhaopin) {
        String sql = "update zhaopin set schoolid=?,z_jobname=?,z_salary=?,z_city=?,z_description=?,z_requirement=? where zhaopinid=?";
        Object[] params = new Object[] { zhaopin.getSchoolId(), zhaopin.getZ_jobname(), zhaopin.getZ_salary(),
                zhaopin.getZ_city(), zhaopin.getZ_desription(), zhaopin.getZ_requirements(), zhaopin.getZhaopinid() };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            System.out.println("更新招聘信息失败");
            e.printStackTrace();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    // 删除学校招聘信息
    public boolean delete(int zhaopinid) {
        String sql = "DELETE from zhaopin where zhaopinid=?";
        Object[] params = new Object[] { zhaopinid };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            System.out.println("删除学校招聘信息失败");
            e.printStackTrace();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    // 按id查询招聘信息
    public Zhaopin queryById(int zid2) {

        int zid = zid2;

        String sql = "SELECT * from zhaopin where zhaopinid = ? ";
        try {
            List<Object[]> data = this.executeDQL(sql, new Object[] { zid });
            if (null != data && !data.isEmpty()) {
                System.out.println("查到数据啦！！");
                Object[] tmp = data.get(0);
                Zhaopin zhaopin = new Zhaopin();

                int i = 0;
                zhaopin.setZhaopinid(Integer.parseInt(tmp[i++].toString()));
                zhaopin.setSchoolId(Integer.parseInt(tmp[i++].toString()));
                zhaopin.setZ_jobname(tmp[i++].toString());
                zhaopin.setZ_salary(tmp[i++].toString());
                zhaopin.setZ_city(tmp[i++].toString());
                zhaopin.setZ_desription(tmp[i++].toString());
                zhaopin.setZ_requirements(tmp[i++].toString());

                return zhaopin;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

}
