/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/6/20 ���ڶ� ���� 9:43:29                     */
/*==============================================================*/


drop table if exists xxbs_member;

/*==============================================================*/
/* Table: xxbs_member                                           */
/*==============================================================*/
create table xxbs_member
(
   ID                   varchar(32) not null comment 'ID',
   nick_name            varchar(50) comment '�ǳ�',
   real_name            varchar(10) comment '��ʵ����',
   sex                  int comment '�Ա�',
   age                  int comment '����',
   id_card              varchar(18) comment '���֤',
   mobile               varchar(20) comment '�ֻ�',
   address              varchar(300) comment 'סַ',
   phone                varchar(20) comment '��ϵ�绰',
   account              varchar(50) comment '�ʺ�',
   password             varchar(50) comment '����',
   state                int comment '״̬(0:������-1����)',
   register_time        datetime comment 'ע��ʱ��',
   primary key (ID)
)
type = InnoDB;

alter table xxbs_member comment '��Ա��Ϣ��';

