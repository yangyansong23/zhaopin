package com.zhaopin.dao;

import java.sql.SQLException;
import java.util.List;

import com.zhaopin.po.Schools;
import com.zhaopin.util.DAOSupport;

public class SchoolsDAO extends DAOSupport {

    /*
     * 学校登录
     */
    public Schools login(Schools schools) {
        String sql = "select * from schools where schoolemail = ? and schoolpwd = ?";
        try {
            List<Object[]> list = this.executeDQL(sql,
                    new Object[] { schools.getSchoolEmail(), schools.getSchoolPwd() });
            if (list != null && !list.isEmpty()) {
                Object[] data = list.get(0);
                Schools school = new Schools();
                school.setSchoolId(Integer.parseInt(data[0].toString()));
                school.setSchoolName(null == data[1] ? "" : data[1].toString());
                school.setSchoolPwd(null == data[2] ? "" : data[2].toString());
                school.setSchoolEmail(null == data[3] ? "" : data[3].toString());
                school.setSchoolLogo(null == data[4] ? "" : data[4].toString());
                school.setSchoolBrief(null == data[5] ? "" : data[5].toString());
                school.setSchoolSize(Integer.parseInt(null == data[6] ? "0" : data[6].toString()));
                school.setSchoolLocate(null == data[7] ? "" : data[7].toString());
                return school;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 学校注册
     */
    public boolean add(Schools school) {
        String sql = "insert into schools (schoolname,schoolemail,schoolpwd,schoollogo) values(?,?,?,?)";
        Object[] params = new Object[] { school.getSchoolName(), school.getSchoolEmail(), school.getSchoolPwd(),
                "img/default.jpg" };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (i > 0)
            return true;
        return false;
    }

    // 修改学校信息
    public boolean update(Schools school) {
        String sql = "update schools set schoolname=?,schoolemail=?,schoolbrief=?,schoolsize=?,schoollocate=? where schoolid=?";
        Object[] params = new Object[] { school.getSchoolName(), school.getSchoolEmail(), school.getSchoolBrief(),
                school.getSchoolSize(), school.getSchoolLocate(), school.getSchoolId() };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            System.out.println("更新学校信息失败");
            e.printStackTrace();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    /*
     * 根据id获取学校信息
     */
    public Schools queryById(int schoolid) {
        String sql = "select * from schools where schoolid = ?";
        try {
            List<Object[]> list = this.executeDQL(sql, new Object[] { schoolid });
            if (list != null && !list.isEmpty()) {
                Object[] data = list.get(0);
                Schools school = new Schools();
                school.setSchoolId(Integer.parseInt(data[0].toString()));
                school.setSchoolName(data[1].toString());
                school.setSchoolPwd(data[2].toString());
                school.setSchoolEmail(data[3].toString());
                school.setSchoolLogo(data[4].toString());
                school.setSchoolBrief(data[5].toString());
                school.setSchoolSize(Integer.parseInt(data[6].toString()));
                school.setSchoolLocate(data[7].toString());
                return school;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

}
