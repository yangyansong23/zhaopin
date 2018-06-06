package com.zhaopin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zhaopin.po.Admins;
import com.zhaopin.po.Schools;
import com.zhaopin.po.Users;
import com.zhaopin.util.DAOSupport;

public class AdminDAO extends DAOSupport {

    /*
     * 管理员登录
     */
    public Admins login(Admins admins) {
        String sql = "select * from admins where adminemail = ? and adminpwd = ?";
        try {
            List<Object[]> list = this.executeDQL(sql, new Object[] { admins.getAdminemail(), admins.getAdminpwd() });
            if (list != null && !list.isEmpty()) {
                Object[] data = list.get(0);

                admins.setAdminname(data[1].toString());
                System.out.println(admins.getAdminname());
                return admins;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 用户查询
     */
    public List<Users> queryuser() {
        List<Users> userlist = new ArrayList<Users>();
        String sql = "SELECT * from users";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到用户数据啦！！");
                Users users = null;
                for (Object[] tmp : data) {
                    users = new Users();
                    int i = 0;
                    users.setUserid(Integer.parseInt(tmp[i++].toString()));
                    users.setUsername(tmp[i++].toString());
                    users.setUserpwd(tmp[i++].toString());
                    users.setUseremail(tmp[i++].toString());
                    users.setUsergender(tmp[i++].toString());
                    users.setUserphoto(tmp[i++].toString());
                    users.setUserschool(tmp[i++].toString());
                    users.setUserfield(tmp[i++].toString());
                    users.setUsergraduate(tmp[i++].toString());

                    userlist.add(users);
                }
            } else {
                System.out.println("没查到用户数据！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return userlist;
    }

    /*
     * 学校
     */
    public List<Schools> querySchool() {
        List<Schools> schoolList = new ArrayList<Schools>();
        String sql = "SELECT * from schools";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到学校数据啦！！");
                Schools schools = null;
                for (Object[] tmp : data) {
                    schools = new Schools();
                    int i = 0;
                    schools.setSchoolId(Integer.parseInt(tmp[i++].toString()));
                    schools.setSchoolName(tmp[i++].toString());
                    schools.setSchoolPwd(tmp[i++].toString());
                    schools.setSchoolEmail(tmp[i++].toString());
                    schools.setSchoolLogo(tmp[i++].toString());
                    schools.setSchoolBrief(tmp[i++].toString());
                    schools.setSchoolSize(Integer.parseInt(tmp[i++].toString()));
                    schools.setSchoolLocate(tmp[i++].toString());

                    schoolList.add(schools);
                }
            } else {
                System.out.println("没查到学校数据！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return schoolList;
    }

}
