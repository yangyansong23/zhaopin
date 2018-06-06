package com.zhaopin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhaopin.po.Qiuzhixin;
import com.zhaopin.po.Yaoqing;
import com.zhaopin.util.DAOSupport;

public class YaoqingDAO extends DAOSupport {

    /*
     * 添加邀请
     */
    public boolean addYaoqing(Yaoqing yaoqing) {
        String sql = "insert into yaoqing (userid,schoolid,qiuzhiid,status,yaoqingtime) values(?,?,?,?,?)";
        Object[] params = new Object[] { yaoqing.getUserid(), yaoqing.getSchoolId(), yaoqing.getQiuzhiid(),
                yaoqing.getStatus(), new Date() };
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

    // 判断该邀请是否存在
    public boolean isExistYq(Yaoqing yaoqing) {

        String sql = "SELECT * from yaoqing where userid=? and schoolid=? and qiuzhiid=?";
        try {
            List<Object[]> data = this.executeDQL(sql,
                    new Object[] { yaoqing.getUserid(), yaoqing.getSchoolId(), yaoqing.getQiuzhiid() });
            if (null != data && data.size() != 0) {
                return true;
            } else {
                System.out.println("没查到求职信！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // 根据学校id获取该学校的所有邀请的列表
    public List<Yaoqing> queryYaoqingBySchoolId(int schoolid) {

        List<Yaoqing> yaoqingList = new ArrayList<Yaoqing>();
        String sql = "SELECT yq.*,qz.q_jobname,u.username from yaoqing yq,qiuzhi qz,users u where yq.qiuzhiid=qz.qiuzhiid and yq.userid=u.userid and yq.schoolid= "
                + schoolid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data && data.size() != 0) {
                System.out.println("查到职位邀请啦！！");
                for (Object[] tmp : data) {
                    Yaoqing yq = new Yaoqing();
                    yq.setYaoqingid(Integer.parseInt(tmp[0].toString()));
                    yq.setUserid(Integer.parseInt(tmp[1].toString()));
                    yq.setSchoolId(schoolid);
                    yq.setQiuzhiid(Integer.parseInt(tmp[3].toString()));
                    yq.setStatus(tmp[4].toString());
                    yq.setYaoqingtime((Date) tmp[5]);
                    yq.setQz_jobname(tmp[6].toString());
                    yq.setUsername(tmp[7].toString());
                    yaoqingList.add(yq);
                }

            } else {
                System.out.println("没查到邀请！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return yaoqingList;
    }

    // 根据学校id获取该学校的所有求职信的列表
    public List<Qiuzhixin> queryQiuzhixinBySchoolId(int schoolid) {

        List<Qiuzhixin> qiuzhixinlist = new ArrayList<Qiuzhixin>();
        String sql = "SELECT qzx.*,zp.z_jobname,u.username from qiuzhixin qzx,zhaopin zp,users u where qzx.zhaopinid=zp.zhaopinid and qzx.userid=u.userid and qzx.userid = "
                + schoolid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data && data.size() != 0) {
                System.out.println("查到求职信啦！！");
                for (Object[] tmp : data) {
                    Qiuzhixin qzx = new Qiuzhixin();
                    qzx.setQiuzhixinid(Integer.parseInt(tmp[0].toString()));
                    qzx.setUserid(Integer.parseInt(tmp[1].toString()));
                    qzx.setSchoolId(Integer.parseInt(tmp[2].toString()));
                    qzx.setZhaopinid(Integer.parseInt(tmp[3].toString()));
                    qzx.setStatus(tmp[4].toString());
                    qzx.setQiuzhitime((Date) tmp[5]);
                    qzx.setQzx_jobname(tmp[6].toString());
                    qzx.setUsername(tmp[7].toString());
                    qiuzhixinlist.add(qzx);
                }

            } else {
                System.out.println("没查到求职信！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return qiuzhixinlist;
    }
}
