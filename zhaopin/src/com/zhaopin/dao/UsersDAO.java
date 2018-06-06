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
                user.setUserphoto(null != data[5] ? data[5].toString() : "img/default.jpg");
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
    public boolean addUser(Users users) {
        String sql = "insert into users (username,useremail,userpwd,userphoto) values(?,?,?,?)";
        Object[] params = new Object[] { users.getUsername(), users.getUseremail(), users.getUserpwd(),
                "img/default.jpg" };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i > 0)
            return true;
        return false;
    }

    // 修改用户信息
    public boolean updateUser(Users user) {
        String sql = "update users set username=?,useremail=?,usergender=?,userphoto,userschool=?,userfield=?,usergraduate=? where userid=?";
        Object[] params = new Object[] { user.getUsername(), user.getUseremail(), user.getUsergender(),
                user.getUserphoto(), user.getUserschool(), user.getUserfield(), user.getUsergraduate(),
                user.getUserid() };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            System.out.println("更新用户信息失败");
            e.printStackTrace();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    // 根据用户id获取用户信息
    public Users queryUserById(int userid) {

        String sql = "SELECT * from users where userid = ?";
        try {
            List<Object[]> dataList = this.executeDQL(sql, new Object[] { userid });
            if (null != dataList) {
                System.out.println("查到用户信息啦！！");
                Object[] tmp = dataList.get(0);
                Users user = new Users();

                user.setUserid(Integer.parseInt(tmp[0].toString()));
                user.setUsername(null == tmp[1] ? "" : tmp[1].toString());
                user.setUserpwd(null == tmp[2] ? "" : tmp[2].toString());
                user.setUseremail(null == tmp[3] ? "" : tmp[3].toString());
                user.setUsergender(null == tmp[4] ? "" : tmp[4].toString());
                user.setUserphoto(null == tmp[5] ? "" : tmp[5].toString());
                user.setUserschool(null == tmp[6] ? "" : tmp[6].toString());
                user.setUserfield(null == tmp[7] ? "" : tmp[7].toString());
                user.setUsergraduate(null == tmp[8] ? "" : tmp[8].toString());
                return user;
            } else {
                System.out.println("没查到用户信息！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * 添加项目经验
     */
    public boolean addExp(Experience exp) {
        String sql = "insert into experience (userid,sname,position,starttime,endtime,program,duty,result) values(?,?,?,?,?,?,?,?)";
        Object[] params = new Object[] { exp.getUserid(), exp.getSname(), exp.getPosition(), exp.getStarttime(),
                exp.getEndtime(), exp.getProgram(), exp.getDuty(), exp.getResult() };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (i > 0)
            return true;
        return false;
    }

    // 修改项目经验
    public boolean updateExp(Experience exp) {

        String sql = "update experience set userid=?,sname=?,position=?,starttime=?,endtime=?,program=?,duty=?,result=? where expid = ?";
        Object[] params = new Object[] { exp.getUserid(), exp.getSname(), exp.getPosition(), exp.getStarttime(),
                exp.getEndtime(), exp.getProgram(), exp.getDuty(), exp.getResult(), exp.getExpid() };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            System.out.println("更新用户信息失败");
            e.printStackTrace();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    // 根据用户id获取项目经验列表
    public List<Experience> queryExperiences(int userid1) {

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
                    exp.setSname(tmp[i++].toString());
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
            e.printStackTrace();
        }
        return Experiencelist;
    }

    // 根据经验id获取项目经验信息
    public Experience queryByExpId(int expid) {

        String sql = "SELECT * from experience where expid = " + expid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到项目经验啦！！");
                Object[] tmp = data.get(0);
                Experience exp = new Experience();
                int i = 0;
                exp.setExpid(Integer.parseInt(tmp[i++].toString()));
                exp.setUserid(Integer.parseInt(tmp[i++].toString()));
                exp.setSname(tmp[i++].toString());
                exp.setPosition(tmp[i++].toString());
                exp.setStarttime((Date) tmp[i++]);
                exp.setEndtime((Date) tmp[i++]);
                exp.setProgram(tmp[i++].toString());
                exp.setDuty(tmp[i++].toString());
                exp.setResult(tmp[i++].toString());

                return exp;

            } else {
                System.out.println("没查到项目经验相关的数据！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 根据经验id删除经验信息
    public boolean deleteExp(int expid) {
        String sql = "DELETE from experience where expid=?";
        Object[] params = new Object[] { expid };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            System.out.println("删除经验信息失败");
            e.printStackTrace();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    /*
     * 添加求职信息
     */
    public boolean addQiuzhi(Qiuzhi qiuzhi) {
        String sql = "insert into qiuzhi (userid,q_jobname,q_salary,q_city,q_time) values(?,?,?,?,?)";
        Object[] params = new Object[] { qiuzhi.getUserid(), qiuzhi.getQ_jobname(), qiuzhi.getQ_salary(),
                qiuzhi.getQ_city(), new Date() };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i > 0)
            return true;
        return false;
    }

    /*
     * 修改求职信息
     */
    public boolean updateQiuzhi(Qiuzhi qiuzhi) {
        String sql = "update qiuzhi set q_jobname=?,q_salary=?,q_city=?,q_time=? where qiuzhiid=?";
        Object[] params = new Object[] { qiuzhi.getQ_jobname(), qiuzhi.getQ_salary(), qiuzhi.getQ_city(), new Date(),
                qiuzhi.getQiuzhiid() };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i > 0)
            return true;
        return false;
    }

    // 根据求职id获取求职信息
    public Qiuzhi querQqiuzhiById(int qiuzhiid) {

        String sql = "SELECT * from qiuzhi where qiuzhiid = " + qiuzhiid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data && data.size() != 0) {
                System.out.println("查到求职信息啦！！");
                Object[] tmp = data.get(0);
                Qiuzhi qz = new Qiuzhi();
                int i = 0;
                qz.setQiuzhiid(Integer.parseInt(tmp[0].toString()));
                qz.setUserid(Integer.parseInt(tmp[1].toString()));
                qz.setQ_jobname(null == tmp[2] ? "" : tmp[2].toString());
                qz.setQ_salary(null == tmp[3] ? "" : tmp[3].toString());
                qz.setQ_city(null == tmp[4] ? "" : tmp[4].toString());
                qz.setQ_time((Date) tmp[5]);
                return qz;
            } else {
                System.out.println("没查到求职信息！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 根据求职id删除求职信息
    public boolean deleteQiuzhi(int qiuzhiid) {
        String sql = "DELETE from qiuzhi where qiuzhiid=?";
        Object[] params = new Object[] { qiuzhiid };
        int i = 0;
        try {
            i = this.exeucteDML(sql, params);
        } catch (SQLException e) {
            System.out.println("删除求职信息失败");
            e.printStackTrace();
        }
        if (i > 0) {
            return true;
        }
        return false;
    }

    // 根据用户id获取该用户的所有求职信息
    public List<Qiuzhi> queryuserqiuzhi(int userid) {

        List<Qiuzhi> qiuzhilist = new ArrayList<Qiuzhi>();
        String sql = "SELECT * from qiuzhi where userid = " + userid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data && data.size() != 0) {
                System.out.println("查到求职信息啦！！");
                for (Object[] tmp : data) {
                    Qiuzhi qz = new Qiuzhi();
                    qz.setQiuzhiid(Integer.parseInt(tmp[0].toString()));
                    qz.setUserid(Integer.parseInt(tmp[1].toString()));
                    qz.setQ_jobname(null == tmp[2] ? "" : tmp[2].toString());
                    qz.setQ_salary(null == tmp[3] ? "" : tmp[3].toString());
                    qz.setQ_city(null == tmp[4] ? "" : tmp[4].toString());
                    qz.setQ_time((Date) tmp[5]);

                    qiuzhilist.add(qz);
                }

            } else {
                System.out.println("没查到求职信息！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qiuzhilist;
    }

}
