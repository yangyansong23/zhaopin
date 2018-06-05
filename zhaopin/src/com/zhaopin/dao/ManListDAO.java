package com.zhaopin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhaopin.po.ManList;
import com.zhaopin.util.DAOSupport;

public class ManListDAO extends DAOSupport {

    public List<ManList> queryOrderByTime() {

        List<ManList> list = new ArrayList<ManList>();
        String sql = "SELECT * from users u,qiuzhi qz where u.userid=qz.userid order by Q_time DESC";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到数据啦！！");
                ManList userlist = null;
                for (Object[] tmp : data) {
                    userlist = new ManList();
                    int i = 0;
                    userlist.setUserid(Integer.parseInt(tmp[i++].toString()));
                    userlist.setUsername(tmp[i++].toString());
                    userlist.setUserphoto(tmp[i++].toString());
                    userlist.setQiuzhiid(Integer.parseInt(tmp[i++].toString()));
                    userlist.setQ_jobname(tmp[i++].toString());
                    userlist.setQ_city(tmp[i++].toString());
                    userlist.setQ_salary(tmp[i++].toString());
                    userlist.setQ_time((Date) tmp[i++]);

                    list.add(userlist);
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
