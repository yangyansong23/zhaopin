package com.zhaopin.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import com.zhaopin.po.Exam;
import com.zhaopin.po.ExamWrong;
import com.zhaopin.po.ExamResult;
import com.zhaopin.util.DAOSupport;

public class ExamDao extends DAOSupport {

    /*
     * 学校考试题查询列表
     */
    public List<Exam> queryuserinfo() {
        List<Exam> list = new ArrayList<Exam>();

        String sql = "SELECT * from exam order by created DESC";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到考试题信息啦！！");

                Exam exam = null;

                for (Object[] tmp : data) {
                	Exam exam1 = new Exam();

                	exam1.setTestid(Integer.parseInt(tmp[0].toString()));
                	exam1.setTestname(tmp[1].toString());
                	exam1.setCreated(tmp[7].toString());
                	exam1.setOptiona(tmp[2].toString());
                	exam1.setOptionb(tmp[3].toString());
                	exam1.setOptionc(tmp[4].toString());
                	exam1.setOptiond(tmp[5].toString());
                	exam1.setTestkey(tmp[6].toString());
                    list.add(exam1);
                }

            } else {
                System.out.println("没查到考试题信息！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

    public List<Exam> queryexamlist() {
    	List<Exam> list = new ArrayList<Exam>();

        String sql = "SELECT * from exam order by created limit 5";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到考试题信息啦！！");

                for (Object[] tmp : data) {
                	Exam exam1 = new Exam();

                	exam1.setTestid(Integer.parseInt(tmp[0].toString()));
                	exam1.setTestname(tmp[1].toString());
                	exam1.setCreated(tmp[7].toString());
                	exam1.setOptiona(tmp[2].toString());
                	exam1.setOptionb(tmp[3].toString());
                	exam1.setOptionc(tmp[4].toString());
                	exam1.setOptiond(tmp[5].toString());
                    list.add(exam1);
                }

            } else {
                System.out.println("没查到考试题信息！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    
    /*
     * 学校录入考试题
     */
    public boolean add(Exam exam) {
    	long l = System.currentTimeMillis();
    	Date time=new Date(l);
    	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String create = sdf.format(time).toString();
        String sql = "insert into exam (testname,optiona,optionb,optionc,optiond,testkey,created) values(?,?,?,?,?,?,?)";
        Object[] params = new Object[] { exam.getTestname(), exam.getOptiona(), exam.getOptionb(), exam.getOptionc(), exam.getOptiond(), exam.getTestkey(), create };
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
    
    /*
     * 学校修改考试题
     */
    public boolean edit(Exam exam) {
        String sql = "update exam set testname='"+exam.getTestname() +"',optiona='"+exam.getOptiona()+
        		"',optionb='"+exam.getOptionb()+"',optionc='"+exam.getOptionc()+
        		"',optiond='"+exam.getOptiond()+"',testkey='"+exam.getTestkey()+"' where testid =" + exam.getTestid();
        int i = 0;
        System.out.println(sql);
        try {
            i = this.exeucteDML(sql, null);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (i > 0)
            return true;
        return false;
    }
    
    /*
     * 学校删除考试题
     */
    public boolean delete(int zid2) {
        String sql = "delete from exam where testid =" + zid2;
        int i = 0;
        System.out.println(sql);
        try {
            i = this.exeucteDML(sql, null);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (i > 0)
            return true;
        return false;
    }
    
    public Exam queryDetailById(int zid2) {

        int zid = zid2;

        String sql = "SELECT * from exam where testid = ? ";
        try {
            List<Object[]> data = this.executeDQL(sql, new Object[] { zid });
            if (null != data && !data.isEmpty()) {
                System.out.println("查到试题详情数据啦！！");
                Object[] tmp = data.get(0);
                Exam exam1 = new Exam();
                exam1.setTestid(Integer.parseInt(tmp[0].toString()));
            	exam1.setTestname(tmp[1].toString());
            	exam1.setOptiona(tmp[2].toString());
            	exam1.setOptionb(tmp[3].toString());
            	exam1.setOptionc(tmp[4].toString());
            	exam1.setOptiond(tmp[5].toString());
            	exam1.setTestkey(tmp[6].toString());
            	exam1.setCreated(tmp[7].toString());

                return exam1;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }
    
    public List<ExamResult> queryTestResult(String zid2, String username) {
    	List<ExamResult> list = new ArrayList<ExamResult>();
    	String zid = zid2;
    	if (null == zid || zid.length() == 0 || zid.equals("")) {
    		List<Exam> lists = queryexamlist();
    		for (Exam jc : lists) {
    			zid = zid + ";" + jc.getTestid()+"-空";
    		}
    		
    	}
    	String[] ret = zid.split(";");
    	for (int i=0;i<ret.length;i++) {
    		if (null != ret[i]) {
    			String[] r = ret[i].split("-");
    			String sql = "SELECT * from exam where testid = ? ";
    	        try {
    	            List<Object[]> data = this.executeDQL(sql, new Object[] { r[0] });
    	            if (null != data && !data.isEmpty()) {
    	                System.out.println("查到试题答案数据啦！！");
    	                Object[] tmp = data.get(0);
    	                if (!tmp[6].toString().equals(r[1])) {
	    	                long l = System.currentTimeMillis();
	    	            	Date time=new Date(l);
	    	            	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    	            	String create = sdf.format(time).toString();
	    	                
	    	                String sql2 = "insert into examwrong (testname,optiona,optionb,optionc,optiond,testkey,yourkey,username,created) values(?,?,?,?,?,?,?,?,?)";
	    	                Object[] params = new Object[] { tmp[1].toString(), tmp[2].toString(), tmp[3].toString(), tmp[4].toString(), tmp[5].toString(), tmp[6].toString(), r[1],username,create };
	    	                try {
	    	                    this.exeucteDML(sql2, params);
	    	                } catch (SQLException e) {
	    	                    // TODO Auto-generated catch block
	    	                    e.printStackTrace();
	    	                }
    	                }
    	                ExamResult exam1 = new ExamResult();
    	                exam1.setTestid(Integer.parseInt(tmp[0].toString()));
    	            	exam1.setTestname(tmp[1].toString());
    	            	exam1.setOptiona(tmp[2].toString());
    	            	exam1.setOptionb(tmp[3].toString());
    	            	exam1.setOptionc(tmp[4].toString());
    	            	exam1.setOptiond(tmp[5].toString());
    	            	exam1.setTestkey(tmp[6].toString());
    	            	exam1.setCreated(tmp[7].toString());
    	            	exam1.setYourkey(r[1]);
    	            	exam1.setUsername(username);
    	            	list.add(exam1);
    	            }
    	
    	        } catch (SQLException e) {
    	            // TODO Auto-generated catch block
    	            e.printStackTrace();
    	        }
    		}
    	}
        return list;

    }
    
    /*
     * 学生考试错题集查询列表
     */
    public List<ExamWrong> queryexamwrong() {
        List<ExamWrong> list = new ArrayList<ExamWrong>();

        String sql = "SELECT * from examwrong order by created DESC limit 10";
        try {
            List<Object[]> data = this.executeDQL(sql, null);
            if (null != data) {
                System.out.println("查到我的考试错题集信息啦！！");

                for (Object[] tmp : data) {
                	ExamWrong exam1 = new ExamWrong();

                	exam1.setTestid(Integer.parseInt(tmp[0].toString()));
                	exam1.setTestname(tmp[1].toString());
                	exam1.setOptiona(tmp[2].toString());
                	exam1.setOptionb(tmp[3].toString());
                	exam1.setOptionc(tmp[4].toString());
                	exam1.setOptiond(tmp[5].toString());
                	exam1.setTestkey(tmp[6].toString());
                	exam1.setYourkey(tmp[7].toString());
                	exam1.setUsername(tmp[8].toString());
                	exam1.setCreated(tmp[9].toString());
                    list.add(exam1);
                }

            } else {
                System.out.println("没查到我的考试错题集信息！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }

}
