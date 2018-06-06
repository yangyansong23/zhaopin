package com.zhaopin.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zhaopin.po.Qiuzhixin;
import com.zhaopin.po.Yaoqing;
import com.zhaopin.util.DAOSupport;

public class QiuzhixinDAO extends DAOSupport {

    /*
     * 添加求职信
     */
    public boolean addQiuzhixin(Qiuzhixin qiuzhixin) {
        String sql = "insert into qiuzhixin (userid,schoolid,zhaopinid,status,qiuzhitime) values(?,?,?,?,?)";
        Object[] params = new Object[] { qiuzhixin.getUserid(), qiuzhixin.getSchoolId(), qiuzhixin.getZhaopinid(),
                qiuzhixin.getStatus(), new Date() };
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
     * 修改求职信
     */
    public boolean updateQiuzhixinSts(int qiuzhixinid, String msg) {
        String sql = "update qiuzhixin set status=? where qiuzhixinid=?";
        Object[] params = new Object[] { msg, qiuzhixinid };
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

    // 判断该求职信是否存在
    public boolean isExistQzx(Qiuzhixin qiuzhixin) {

        String sql = "SELECT * from qiuzhixin where userid=? and schoolid=? and zhaopinid=?";
        try {
            List<Object[]> data = this.executeDQL(sql,
                    new Object[] { qiuzhixin.getUserid(), qiuzhixin.getSchoolId(), qiuzhixin.getZhaopinid() });
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

    // 根据求职信id获取求职信
    public Qiuzhixin querQqiuzhixinById(int qiuzhixinid) {

        String sql = "SELECT * from qiuzhixin where qiuzhixinid = " + qiuzhixinid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data && data.size() != 0) {
                System.out.println("查到求职信啦！！");
                Object[] tmp = data.get(0);
                Qiuzhixin qzx = new Qiuzhixin();
                int i = 0;
                return qzx;
            } else {
                System.out.println("没查到求职信！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 根据求职信id删除求职信
    public boolean deleteQiuzhixin(int qiuzhixinid) {
        String sql = "DELETE from qiuzhixin where qiuzhixinid=?";
        Object[] params = new Object[] { qiuzhixinid };
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

    // 根据用户id获取该用户的所有求职信的列表
    public List<Qiuzhixin> queryQiuzhixinByUserId(int userid) {

        List<Qiuzhixin> qiuzhixinlist = new ArrayList<Qiuzhixin>();
        String sql = "SELECT qzx.*,s.schoolname,zp.z_jobname from qiuzhixin qzx, schools s,zhaopin zp where qzx.schoolid=s.schoolid and qzx.zhaopinid=zp.zhaopinid and qzx.userid = "
                + userid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data && data.size() != 0) {
                System.out.println("查到求职信啦！！");
                for (Object[] tmp : data) {
                    Qiuzhixin qzx = new Qiuzhixin();
                    qzx.setQiuzhixinid(Integer.parseInt(tmp[0].toString()));
                    qzx.setUserid(userid);
                    qzx.setSchoolId(Integer.parseInt(tmp[2].toString()));
                    qzx.setZhaopinid(Integer.parseInt(tmp[3].toString()));
                    qzx.setStatus(tmp[4].toString());
                    qzx.setQiuzhitime((Date) tmp[5]);
                    qzx.setSchoolname(tmp[6].toString());
                    qzx.setQzx_jobname(tmp[7].toString());
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

    // 根据用户id获取该用户的所有邀请的列表
    public List<Yaoqing> queryYaoqingByUserId(int userid) {

        List<Yaoqing> yaoqingList = new ArrayList<Yaoqing>();
        String sql = "SELECT yq.*,qz.q_jobname,s.schoolname from yaoqing yq,qiuzhi qz,schools s where yq.qiuzhiid=qz.qiuzhiid and yq.schoolid=s.schoolid and yq.userid= "
                + userid;
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data && data.size() != 0) {
                System.out.println("查到职位邀请啦！！");
                for (Object[] tmp : data) {
                    Yaoqing yq = new Yaoqing();
                    yq.setYaoqingid(Integer.parseInt(tmp[0].toString()));
                    yq.setUserid(userid);
                    yq.setSchoolId(Integer.parseInt(tmp[2].toString()));
                    yq.setQiuzhiid(Integer.parseInt(tmp[3].toString()));
                    yq.setStatus(tmp[4].toString());
                    yq.setYaoqingtime((Date) tmp[5]);
                    yq.setQz_jobname(tmp[6].toString());
                    yq.setSchoolname(tmp[7].toString());
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

}
