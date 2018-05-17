/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/20 星期二 上午 9:43:29                     */
/*==============================================================*/


drop table if exists xxbs_member;

/*==============================================================*/
/* Table: xxbs_member                                           */
/*==============================================================*/
create table xxbs_member
(
   ID                   varchar(32) not null comment 'ID',
   nick_name            varchar(50) comment '昵称',
   real_name            varchar(10) comment '真实姓名',
   sex                  int comment '性别',
   age                  int comment '年龄',
   id_card              varchar(18) comment '身份证',
   mobile               varchar(20) comment '手机',
   address              varchar(300) comment '住址',
   phone                varchar(20) comment '联系电话',
   account              varchar(50) comment '帐号',
   password             varchar(50) comment '密码',
   state                int comment '状态(0:正常，-1锁定)',
   register_time        datetime comment '注册时间',
   primary key (ID)
)
type = InnoDB;

alter table xxbs_member comment '会员信息表';

