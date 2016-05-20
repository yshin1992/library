create database library default charset=utf8;

use library;


create table manager(
managerId varchar(18) primary key,
username varchar(30) not null,
sex nvarchar(2) not null,
password char(128) not null,
telephone varchar(11) not null,
email varchar(64),
isadmin bool default 0,
status bool default 0) default charset=utf8,engine=InnoDB;

create table BookType
(
   id                   int auto_increment not null,
   typeName             varchar(254) not null,
   days                 int not null,
   fine                 float not null,
   parentId             int not null default 0,
   level 				int,
   primary key (id)
);

insert into BookType values(null,'科技',30,0.3,0,1);
insert into booktype values(null,'电子与通信',30,0.3,1,2);
insert into booktype values(null,'基础与理论',30,0.3,2,3);


create table BookInfo
(
   ISBN                 varchar(254) not null,
   typeId               int, 
   bookname             varchar(254) not null,
   author               varchar(254),
   translator           varchar(254),
   publisher            varchar(254),
   date                 datetime,
   price                float,
   primary key (ISBN),
   foreign key(typeId) references BookType(id)
);

alter table BookInfo comment '图书信息';

insert into BookInfo values('WZK-7-123-00232-7',3,'电子学(第2版)','Paul Horowitz,Winfield Hill','吴利民,余国文,欧阳华','电子工业出版社','2009/3/1',77.60);


create table Reader
(
   ISBN                 varchar(254) not null,
   name                 varchar(254) not null,
   sex                  varchar(2) not null,
   age                  int not null,
   idCard               varchar(254) not null,
   regDate              datetime not null,
   maxNum               int,
   telphone             varchar(254) not null,
   keepMoney            float not null,
   cardType             int,
   job                  varchar(254),
   validDate            datetime not null,
   primary key (ISBN)
);


create table BorrowInfo
(
   aiid                 bigint not null,
   bookISBN             varchar(254),
   managerId            varchar(254),
   readerISBN           varchar(254),
   isback               bool,
   brrowDate            datetime,
   backDate             datetime,
   primary key (aiid)
);

alter table BorrowInfo comment '图书借阅信息';


create table OrderInfo
(
   aiid                 bigint not null,
   ISBN                 varchar(254) not null,
   orderDate            datetime not null,
   typeId               int not null,
   number               int,
   managerId            varchar(254),
   checkAccept          bool,
   discount             float,
   primary key (aiid)
);


CREATE TABLE `operatelog` (
  `aiid` bigint(20) NOT NULL AUTO_INCREMENT,
  `userid` varchar(18) NOT NULL,
  `sessionId` varchar(254) NOT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `url` varchar(254) DEFAULT NULL,
  `targetObject` varchar(254) NOT NULL,
  `userAgent` varchar(254) DEFAULT NULL,
  `acceptLanguage` varchar(254) DEFAULT NULL,
  `operateTime` datetime DEFAULT NULL,
  `operateResult` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`aiid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


create table sysfunc(
aiid int primary key auto_increment,
funckey varchar(64) not null,
funcname varchar(64) not null,
functype varchar(64) not null,
url varchar(254),
css varchar(64),
parentid int default 0 not null,
DESCRIPTION varchar(254),
state tinyint default 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into sysfunc values(null,'BookManage','书籍管理','Menu','','source',0,'书籍管理菜单',0);
insert into sysfunc values(null,'BookTypeManage','图书类别管理','MenuItem','manager/booktype.do','',1,'图书类别管理菜单项',0);
insert into sysfunc values(null,'BookInfoManage','图书信息管理','MenuItem','manager/bookinfo.do','',1,'图书信息管理菜单项',0);

insert into sysfunc values(null,'SystemManage','系统管理','Menu','','syetem_management',0,'系统管理菜单',0);
insert into sysfunc values(null,'ManagerInfo','用户基本信息','MenuItem','manager/managerinfo.do','',4,'用户基本信息菜单项',0);
insert into sysfunc values(null,'UpdateMgrInfo','修改用户信息','MenuItem','manager/updateMgrInfo.do','',4,'修改用户信息菜单项',0);

create table sysrole(
roleid int primary key auto_increment,
rolename varchar(64) not null,
DESCRIPTION varchar(254),
state tinyint default 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into sysrole values(null,'manager','普通管理员',0);
insert into sysrole values(null,'admin','超级管理员',0);

create table role2func(
roleid int not null,
funcid int not null,
state tinyint not null default 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into role2func values(1,1,0);
insert into role2func values(1,2,0);
insert into role2func values(1,3,0);
insert into role2func values(1,4,0);
insert into role2func values(1,5,0);
insert into role2func values(1,6,0);

create table manager2role(
managerid varchar(18) not null,
roleid int not null,
state tinyint not null default 0
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into manager2role values('101',1,0);
insert into manager2role values('340121199209010442',1,0);