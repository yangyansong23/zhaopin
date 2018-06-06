DROP DATABASE IF EXISTS zhaopin;

CREATE DATABASE zhaopin DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE zhaopin;

CREATE TABLE links(
		linkid INT (10) auto_increment PRIMARY KEY,
		linname VARCHAR (50) NOT NULL ,
		linkurl VARCHAR (50) ,
		linkimg VARCHAR (50)  
);

CREATE TABLE admins(
		adminid INT (10) auto_increment PRIMARY KEY,
		adminname VARCHAR (50),
		adminemail VARCHAR (50),
		adminpwd VARCHAR (50)
);

CREATE TABLE schools(
		schoolid INT (10) auto_increment PRIMARY KEY ,
		schoolname VARCHAR (50),
		schoolpwd VARCHAR (50) ,
		schoolemail VARCHAR (50),
		schoollogo VARCHAR (50),
		schoolbrief VARCHAR (255),
		schoolsize VARCHAR (50),
		schoollocate VARCHAR (255)
);

CREATE TABLE users(
		userid INT (10) auto_increment PRIMARY KEY ,
		username VARCHAR (50) ,
		userpwd VARCHAR (50) NOT NULL ,
		useremail VARCHAR (50),
		usergender VARCHAR (50),
		userphoto VARCHAR (50),
		userschool VARCHAR (50),
		userfield VARCHAR (50) ,
		usergraduate VARCHAR (50) 
);

CREATE TABLE exam(
		testid INT (10) auto_increment PRIMARY KEY ,
		testname VARCHAR (50) ,
		optiona VARCHAR (50) ,
		optionb VARCHAR (50),
		optionc VARCHAR (50),
		optiond VARCHAR (50),
		testkey VARCHAR (50),
		created VARCHAR (50)
);

CREATE TABLE examwrong(
		testid INT (10) auto_increment PRIMARY KEY ,
		testname VARCHAR (50) ,
		optiona VARCHAR (50) ,
		optionb VARCHAR (50),
		optionc VARCHAR (50),
		optiond VARCHAR (50),
		testkey VARCHAR (50),
		yourkey VARCHAR (50),
		username VARCHAR (50),
		created VARCHAR (50)
);

CREATE TABLE experience(
		expid INT (10) auto_increment PRIMARY KEY ,
		userid INT (10) NOT NULL,
		sname VARCHAR (50),
		position VARCHAR (50),
		starttime DATE ,
		endtime DATE ,
		program VARCHAR (255),
		duty VARCHAR (50),
		result VARCHAR (50),
		FOREIGN KEY (userid) REFERENCES users(userid) 
);

CREATE TABLE qiuzhi(
		qiuzhiid INT (10) auto_increment PRIMARY KEY ,
		userid INT (10) NOT NULL ,
		q_jobname VARCHAR (50),
		q_salary VARCHAR  (10),
		q_city VARCHAR (50),
		q_time DATE ,
		FOREIGN KEY (userid) REFERENCES users(userid)
);

CREATE TABLE zhaopin(
		zhaopinid INT (10) auto_increment PRIMARY KEY ,
		schoolid INT (10) NOT NULL ,
		z_jobname VARCHAR (50),
		z_salary VARCHAR  (10),
		z_city VARCHAR (50),
		z_description VARCHAR (255),
		z_requirement VARCHAR (255),
		z_time DATE ,
		z_count INT (10),
		FOREIGN KEY (schoolid) REFERENCES schools(schoolid)
);

CREATE TABLE yaoqing(
		yaoqingid INT (10) auto_increment PRIMARY KEY ,
		userid INT (10) NOT NULL ,
		schoolid INT (10) NOT NULL ,
		qiuzhiid INT (10) NOT NULL,
		status VARCHAR (50),
		yaoqingtime DATE ,
		FOREIGN KEY (userid) REFERENCES users(userid),
		FOREIGN KEY (schoolid) REFERENCES schools(schoolid),
		FOREIGN KEY (qiuzhiid) REFERENCES qiuzhi(qiuzhiid)
);

CREATE TABLE qiuzhixin(
		qiuzhixinid INT (10) auto_increment PRIMARY KEY ,
		userid INT (10) NOT NULL ,
		schoolid INT (10) NOT NULL ,
		zhaopinid INT (10) NOT NULL ,
		status VARCHAR (50),
		qiuzhitime DATE ,
		FOREIGN KEY (userid) REFERENCES users(userid),
		FOREIGN KEY (schoolid) REFERENCES schools(schoolid),
		FOREIGN KEY (zhaopinid) REFERENCES zhaopin(zhaopinid)
);
