DROP TABLE IF EXISTS mybatis;

CREATE TABLE tbl_employee (
  id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
  name varchar(20) NOT NULL COMMENT '姓名',
  email varchar(20) NOT NULL COMMENT '邮箱',
  gender varchar(64) NOT NULL COMMENT '性别',
  departmentId varchar(64) NOT NULL COMMENT '性别',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tbl_department;

CREATE TABLE tbl_department (
  id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
  name varchar(20) NOT NULL COMMENT '姓名',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE concurrent (
  id INT NOT NULL AUTO_INCREMENT COMMENT '主键',
  name varchar(20) NOT NULL COMMENT '名称',
  amount varchar(20) NOT NULL COMMENT '数量',
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;