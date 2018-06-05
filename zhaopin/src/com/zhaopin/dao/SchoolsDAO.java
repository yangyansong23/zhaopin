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
                school.setSchoolName(data[1].toString());
                school.setSchoolPwd(data[2].toString());
                school.setSchoolEmail(data[3].toString());
                school.setSchoolLogo(null != data[4] ? data[4].toString() : "");
                school.setSchoolBrief(null != data[5] ? data[5].toString() : "");
                school.setSchoolSize(Integer.parseInt(null != data[6] ? data[6].toString() : "7467"));
                school.setSchoolLocate(null != data[7] ? data[7].toString() : "");
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
        String sql = "insert into schools (schoolname,schoolemail,schoolpwd,schoolBrief,schoolLocate) values(?,?,?,?,?)";
        Object[] params = new Object[] { school.getSchoolName(), school.getSchoolEmail(), school.getSchoolPwd(), "北京石油化工学院是首批获准实施'服务国家特殊需求人才培养项目'的高校", "位于京南大兴新区" };
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

}
