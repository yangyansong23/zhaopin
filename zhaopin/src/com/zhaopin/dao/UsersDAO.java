package com.zhaopin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhaopin.po.Experience;
import com.zhaopin.po.Qiuzhi;
import com.zhaopin.po.Users;
import com.zhaopin.util.DAOSupport;

public class UsersDAO extends DAOSupport {

    /*
     * 用户登录
     */
    public Users login(Users users) {
        String sql = "select * from users where useremail = ? and userpwd = ?";
        try {
            List<Object[]> list = this.executeDQL(sql, new Object[] { users.getUseremail(), users.getUserpwd() });
            if (list != null && !list.isEmpty()) {
                Object[] data = list.get(0);
                Users user = new Users();
                user.setUserid(Integer.parseInt(data[0].toString()));
                user.setUsername(data[1].toString());
                user.setUseremail(users.getUseremail());
                user.setUsergender(null != data[4] ? data[4].toString() : "");
                user.setUserschool(null != data[6] ? data[6].toString() : "");
                user.setUserfield(null != data[7] ? data[7].toString() : "");
                user.setUsergraduate(null != data[8] ? data[8].toString() : "");
                return user;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 用户注册
     */
    public boolean add(Users users) {
        String sql = "insert into users (username,useremail,userpwd) values(?,?,?)";
        Object[] params = new Object[] { users.getUsername(), users.getUseremail(), users.getUserpwd() };
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

    public List<Users> queryuserinfo(int userid1) {
        int userid = userid1;

        List<Users> list = new ArrayList<Users>();

        String sql = "SELECT * from users where userid = " + userid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到用户信息啦！！");

                Users user = null;

                for (Object[] tmp : data) {
                    Users user1 = new Users();

                    user1.setUserid(Integer.parseInt(tmp[0].toString()));
                    user1.setUsername(null == tmp[1] ? "" : tmp[1].toString());
                    user1.setUserpwd(null == tmp[2] ? "" : tmp[2].toString());
                    user1.setUseremail(null == tmp[3] ? "" : tmp[3].toString());
                    user1.setUsergender(null == tmp[4] ? "" : tmp[4].toString());
                    user1.setUserphoto(null == tmp[5] ? "" : tmp[5].toString());
                    user1.setUserschool(null == tmp[6] ? "" : tmp[6].toString());
                    user1.setUserfield(null == tmp[7] ? "" : tmp[7].toString());
                    user1.setUsergraduate(null == tmp[8] ? "" : tmp[8].toString());

                    list.add(user1);
                }

            } else {
                System.out.println("没查到用户信息！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public List<Experience> queryuserexperience(int userid1) {

        int userid = userid1;

        List<Experience> Experiencelist = new ArrayList<Experience>();

        String sql = "SELECT * from experience where userid = " + userid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到项目经验啦！！");

                for (Object[] tmp : data) {
                    Experience exp = new Experience();
                    int i = 0;

                    exp.setExpid(Integer.parseInt(tmp[i++].toString()));
                    exp.setUserid(Integer.parseInt(tmp[i++].toString()));
                    exp.setCname(tmp[i++].toString());
                    exp.setPosition(tmp[i++].toString());
                    exp.setStarttime((Date) tmp[i++]);
                    exp.setEndtime((Date) tmp[i++]);
                    exp.setProgram(tmp[i++].toString());
                    exp.setDuty(tmp[i++].toString());
                    exp.setResult(tmp[i++].toString());

                    Experiencelist.add(exp);

                }

            } else {
                System.out.println("没查到数据！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return Experiencelist;
    }

    // 查询求职信息
    public List<Qiuzhi> queryuserqiuzhi(int userid1) {

        int userid = userid1;

        List<Qiuzhi> qiuzhilist = new ArrayList<Qiuzhi>();

        String sql = "SELECT * from qiuzhi where userid = " + userid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到求职信息啦！！");

                Qiuzhi qiuzhi = null;

                for (Object[] tmp : data) {
                    Qiuzhi qz = new Qiuzhi();
                    int i = 0;

                    qz.setQiuzhiid(Integer.parseInt(tmp[i++].toString()));
                    qz.setUserid(Integer.parseInt(tmp[i++].toString()));
                    qz.setQ_jobname(tmp[i++].toString());
                    qz.setQ_salary(tmp[i++].toString());
                    qz.setQ_city(tmp[i++].toString());
                    qz.setQ_time((Date) tmp[i++]);
                    // qz.setQ_describe(tmp[i++].toString());

                    qiuzhilist.add(qz);

                }

            } else {
                System.out.println("没查到求职信息！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return qiuzhilist;
    }

}
