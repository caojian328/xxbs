/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/1/6 ������ ���� 5:22:05                      */
/*==============================================================*/


drop table if exists pawn_authenticate_auth_log;

drop table if exists pawn_basic_type;

drop table if exists pawn_estimate_auth_log;

drop table if exists pawn_finance_data_log;

drop table if exists pawn_order;

drop table if exists "pawn_order_ send_package";

drop table if exists pawn_pre_order;

drop table if exists pawn_put_money_log;

drop table if exists pawn_user;

drop table if exists pawn_user_address;

drop table if exists pawn_user_bankcard;

drop table if exists pwan_continue_record;

/*==============================================================*/
/* Table: pawn_authenticate_auth_log                            */
/*==============================================================*/
create table pawn_authenticate_auth_log
(
   id                   char(32) not null comment 'id',
   oid                  char(32) comment '��������',
   audit_post           varchar(50) comment '��˸�λ',
   auditor              varchar(50) comment '�����Ա',
   audit_result         varchar(50) comment '��˽��',
   estimate_amount      decimal(18,2) comment 'Ԥ�����',
   estimate_suggestion  varchar(500) comment 'Ԥ�����',
   audit_status         int comment '���״̬',
   created_date         datetime comment '�ύ���ʱ��',
   complete_date        datetime comment '������ʱ��',
   modified_date        datetime comment '�޸�ʱ��',
   primary key (id)
);

alter table pawn_authenticate_auth_log comment '������˼�¼�б�';

/*==============================================================*/
/* Table: pawn_basic_type                                       */
/*==============================================================*/
create table pawn_basic_type
(
   pawn_type_id         char(32) not null comment '�䵱����id',
   type_no              tinyint comment '�䵱���ͱ��',
   type_desc            varchar(64) comment '����',
   create_date          datetime comment '����ʱ��',
   last_update_time     datetime comment '�޸�ʱ��',
   primary key (pawn_type_id)
);

alter table pawn_basic_type comment '�䵱����';

/*==============================================================*/
/* Table: pawn_estimate_auth_log                                */
/*==============================================================*/
create table pawn_estimate_auth_log
(
   ID                   char(32) not null comment 'ID',
   pre_order_id         char(32) comment '��������',
   audit_post           varchar(50) comment '��˸�λ',
   auditor              varchar(50) comment '�����Ա',
   audit_result         varchar(50) comment '��˽��',
   estimate_amount      decimal(18,2) comment 'Ԥ�����',
   estimate_suggestion  varchar(500) comment 'Ԥ�����',
   audit_status         int comment '���״̬',
   created_date         datetime comment '�ύ���ʱ��',
   complete_date        datetime comment '������ʱ��',
   modified_date        datetime comment '�޸�ʱ��',
   primary key (ID)
);

alter table pawn_estimate_auth_log comment 'Ԥ����˼�¼�б�';

/*==============================================================*/
/* Table: pawn_finance_data_log                                 */
/*==============================================================*/
create table pawn_finance_data_log
(
   id                   char(32) not null comment 'id',
   oid                  char(32) comment '��������',
   finance_type         int comment '��������(1:�ſ�,2:����,3:�굱)',
   data_info            varchar(500) comment '����������Ϣ(json���ı�)',
   create_time          datetime comment '����ʱ��',
   primary key (id)
);

alter table pawn_finance_data_log comment '����_�������ݼ�¼��';

/*==============================================================*/
/* Table: pawn_order                                            */
/*==============================================================*/
create table pawn_order
(
   id                   char(32) not null comment 'ID',
   order_no             varchar(50) comment '�������',
   pre_order_id         char(32) comment '����ID',
   estimate_money       decimal(18,2) comment 'Ԥ�����',
   confirm_money        decimal(18,2) comment '����ȷ�ϵ���',
   synthesize_money     decimal(18,2) comment '�ۺϷ���',
   overdue_money        decimal(18,2) comment '�������ɽ�',
   status               int comment '����״̬',
   create_time          datetime comment '����ʱ��',
   last_update_time     datetime comment '����޸�ʱ��',
   primary key (id)
);

alter table pawn_order comment '����';

/*==============================================================*/
/* Table: "pawn_order_ send_package"                            */
/*==============================================================*/
create table "pawn_order_ send_package"
(
   id                   char(32) not null comment 'ID',
   oid                  char(32) comment '��������',
   uid                  char(32) comment '�ռ���',
   send_info            varchar(500) comment '�ļ�����Ϣ',
   receive_info         varchar(500) comment '�ռ�����Ϣ',
   stauts               int comment '״̬',
   express_company      varchar(50) comment '��ݹ�˾',
   express_number       varchar(50) comment '��ݵ���',
   create_time          datetime comment '����ʱ��',
   last_update_time     datetime comment '����޸�ʱ��',
   delivery_type        tinyint comment '�ռ�����(1:�գ�2:��)',
   primary key (id)
);

alter table "pawn_order_ send_package" comment '�ļ��б�';

/*==============================================================*/
/* Table: pawn_pre_order                                        */
/*==============================================================*/
create table pawn_pre_order
(
   pre_order_id         char(32) not null comment '���򶩵�id',
   pre_order_no         varchar(64) comment '���򶩵����',
   user_info            varchar(512) comment '�û���Ϣ',
   user_id              varchar(64) comment '�û�id',
   pre_loan_amount      decimal(18,2) comment '��������',
   pawn_type_id         char(32) comment '�䵱����id',
   pawn_type_no         tinyint comment '�䵱���ͱ��',
   pawn_basic_property  varchar(512) comment '��Ʒ��������',
   pawn_pic             varchar(512) comment '��ƷͼƬ',
   orther_pic           varchar(512) comment '����ͼƬ',
   pawn_attachment      varchar(512) comment '����',
   pawn_attachment_pic  varchar(512) comment '����ͼƬ',
   pawn_attachment_property varchar(512) comment '��������',
   status               varchar(20) comment '״̬',
   operator_post        varchar(64) comment '����ְλ',
   operator             varchar(64) comment '����Ա',
   remark               varchar(512) comment '��ע',
   last_update_time     datetime comment '�޸�ʱ��',
   create_date          datetime comment '����ʱ��',
   pre_date             datetime comment '�����ύʱ��',
   primary key (pre_order_id)
);

alter table pawn_pre_order comment '���򶩵�';

/*==============================================================*/
/* Table: pawn_put_money_log                                    */
/*==============================================================*/
create table pawn_put_money_log
(
   id                   char(32) not null comment 'id',
   oid                  char(32) comment '��������',
   loan_amount          decimal(18,2) comment '�ſ���',
   loan_date            datetime comment '�ſ�����',
   created_date         datetime comment '��������',
   load_by              varchar(50) comment '�ſ���',
   primary key (id)
);

alter table pawn_put_money_log comment '�ſ��¼�б�';

/*==============================================================*/
/* Table: pawn_user                                             */
/*==============================================================*/
create table pawn_user
(
   id                   char(32) not null comment 'id',
   name                 varchar(10) comment '����',
   card_no              varchar(20) comment '���֤',
   mobile               varchar(20) comment '�ֻ�����',
   pwd                  datetime comment '����',
   auth                 int comment '�Ƿ�ʵ����֤(0:δ��֤��1:�Ѿ���֤)',
   create_time          datetime comment 'ע��ʱ��',
   last_update_time     datetime comment '����޸�ʱ��',
   primary key (id)
);

alter table pawn_user comment '�û���';

/*==============================================================*/
/* Table: pawn_user_address                                     */
/*==============================================================*/
create table pawn_user_address
(
   id                   char(32) not null comment 'ID',
   uid                  char(32) comment '�û�id',
   name                 varchar(20) comment '�ռ���',
   province             varchar(10) comment 'ʡ',
   city                 varchar(10) comment '��',
   area                 varchar(10) comment '��',
   addr                 varchar(200) comment '��ַ',
   post_code            varchar(10) comment '�ʱ�',
   mobile               varchar(20) comment '�ֻ�',
   phone                varchar(30) comment '����',
   create_time          datetime comment '���ʱ��',
   last_update_time     datetime comment '����޸�ʱ��',
   primary key (id)
);

alter table pawn_user_address comment 'pawn_user_address';

/*==============================================================*/
/* Table: pawn_user_bankcard                                    */
/*==============================================================*/
create table pawn_user_bankcard
(
   id                   char(32) not null comment 'id',
   uid                  char(32) comment '�û�id',
   account_name         varchar(50) comment '��������',
   account_bank         varchar(100) comment '��������',
   card_no              varchar(50) comment '���п���',
   province             varchar(20) comment '����ʡ',
   city                 varchar(20) comment '������',
   acount_branch_bank   varchar(100) comment '����֧��',
   create_time          datetime comment '���ʱ��',
   last_update_time     datetime comment '����޸�ʱ��',
   primary key (id)
);

alter table pawn_user_bankcard comment '�û����п�';

/*==============================================================*/
/* Table: pwan_continue_record                                  */
/*==============================================================*/
create table pwan_continue_record
(
   id                   char(32) not null comment 'id',
   oid                  char(32) comment '��������',
   uid                  char(32) comment '�����û�',
   begin_date           date comment '��������',
   deadline             int comment '��������',
   end_date             date comment '��ֹ����',
   renewal_money        decimal(18,2) comment '��������',
   overdue_fine         decimal(18,2) comment '�������ɽ�',
   voucher              varchar(32) comment '����ƾ֤',
   primary key (id)
);

alter table pwan_continue_record comment '������¼';

alter table pawn_authenticate_auth_log add constraint FK_Reference_8 foreign key (oid)
      references pawn_order (id) on delete restrict on update restrict;

alter table pawn_estimate_auth_log add constraint FK_Reference_4 foreign key (pre_order_id)
      references pawn_pre_order (pre_order_id) on delete restrict on update restrict;

alter table pawn_finance_data_log add constraint FK_Reference_11 foreign key (oid)
      references pawn_order (id) on delete restrict on update restrict;

alter table pawn_order add constraint FK_Reference_6 foreign key (pre_order_id)
      references pawn_pre_order (pre_order_id) on delete restrict on update restrict;

alter table "pawn_order_ send_package" add constraint FK_Reference_7 foreign key (oid)
      references pawn_order (id) on delete restrict on update restrict;

alter table pawn_pre_order add constraint FK_Reference_5 foreign key (user_id)
      references pawn_user (id) on delete restrict on update restrict;

alter table pawn_pre_order add constraint FK_pre_order_type_no foreign key (pawn_type_id)
      references pawn_basic_type (pawn_type_id) on delete restrict on update restrict;

alter table pawn_put_money_log add constraint FK_Reference_9 foreign key (oid)
      references pawn_order (id) on delete restrict on update restrict;

alter table pawn_user_address add constraint FK_Reference_3 foreign key (uid)
      references pawn_user (id) on delete restrict on update restrict;

alter table pawn_user_bankcard add constraint FK_Reference_2 foreign key (uid)
      references pawn_user (id) on delete restrict on update restrict;

alter table pwan_continue_record add constraint FK_Reference_10 foreign key (oid)
      references pawn_order (id) on delete restrict on update restrict;

