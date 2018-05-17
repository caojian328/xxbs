/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/1/6 星期六 下午 5:22:05                      */
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
   oid                  char(32) comment '所属订单',
   audit_post           varchar(50) comment '审核岗位',
   auditor              varchar(50) comment '审核人员',
   audit_result         varchar(50) comment '审核结果',
   estimate_amount      decimal(18,2) comment '预估金额',
   estimate_suggestion  varchar(500) comment '预估意见',
   audit_status         int comment '审核状态',
   created_date         datetime comment '提交审核时间',
   complete_date        datetime comment '审核完成时间',
   modified_date        datetime comment '修改时间',
   primary key (id)
);

alter table pawn_authenticate_auth_log comment '鉴定审核记录列表';

/*==============================================================*/
/* Table: pawn_basic_type                                       */
/*==============================================================*/
create table pawn_basic_type
(
   pawn_type_id         char(32) not null comment '典当类型id',
   type_no              tinyint comment '典当类型编号',
   type_desc            varchar(64) comment '描述',
   create_date          datetime comment '创建时间',
   last_update_time     datetime comment '修改时间',
   primary key (pawn_type_id)
);

alter table pawn_basic_type comment '典当类型';

/*==============================================================*/
/* Table: pawn_estimate_auth_log                                */
/*==============================================================*/
create table pawn_estimate_auth_log
(
   ID                   char(32) not null comment 'ID',
   pre_order_id         char(32) comment '所属意向',
   audit_post           varchar(50) comment '审核岗位',
   auditor              varchar(50) comment '审核人员',
   audit_result         varchar(50) comment '审核结果',
   estimate_amount      decimal(18,2) comment '预估金额',
   estimate_suggestion  varchar(500) comment '预估意见',
   audit_status         int comment '审核状态',
   created_date         datetime comment '提交审核时间',
   complete_date        datetime comment '审核完成时间',
   modified_date        datetime comment '修改时间',
   primary key (ID)
);

alter table pawn_estimate_auth_log comment '预估审核记录列表';

/*==============================================================*/
/* Table: pawn_finance_data_log                                 */
/*==============================================================*/
create table pawn_finance_data_log
(
   id                   char(32) not null comment 'id',
   oid                  char(32) comment '所属订单',
   finance_type         int comment '财务类型(1:放款,2:续当,3:赎当)',
   data_info            varchar(500) comment '财务数据信息(json或文本)',
   create_time          datetime comment '创建时间',
   primary key (id)
);

alter table pawn_finance_data_log comment '订单_财务数据记录表';

/*==============================================================*/
/* Table: pawn_order                                            */
/*==============================================================*/
create table pawn_order
(
   id                   char(32) not null comment 'ID',
   order_no             varchar(50) comment '订单编号',
   pre_order_id         char(32) comment '意向ID',
   estimate_money       decimal(18,2) comment '预估借款',
   confirm_money        decimal(18,2) comment '最终确认当金',
   synthesize_money     decimal(18,2) comment '综合费用',
   overdue_money        decimal(18,2) comment '逾期滞纳金',
   status               int comment '订单状态',
   create_time          datetime comment '创建时间',
   last_update_time     datetime comment '最后修改时间',
   primary key (id)
);

alter table pawn_order comment '订单';

/*==============================================================*/
/* Table: "pawn_order_ send_package"                            */
/*==============================================================*/
create table "pawn_order_ send_package"
(
   id                   char(32) not null comment 'ID',
   oid                  char(32) comment '所属订单',
   uid                  char(32) comment '收件人',
   send_info            varchar(500) comment '寄件方信息',
   receive_info         varchar(500) comment '收件方信息',
   stauts               int comment '状态',
   express_company      varchar(50) comment '快递公司',
   express_number       varchar(50) comment '快递单号',
   create_time          datetime comment '创建时间',
   last_update_time     datetime comment '最后修改时间',
   delivery_type        tinyint comment '收寄类型(1:收，2:寄)',
   primary key (id)
);

alter table "pawn_order_ send_package" comment '寄件列表';

/*==============================================================*/
/* Table: pawn_pre_order                                        */
/*==============================================================*/
create table pawn_pre_order
(
   pre_order_id         char(32) not null comment '意向订单id',
   pre_order_no         varchar(64) comment '意向订单编号',
   user_info            varchar(512) comment '用户信息',
   user_id              varchar(64) comment '用户id',
   pre_loan_amount      decimal(18,2) comment '意向借款金额',
   pawn_type_id         char(32) comment '典当类型id',
   pawn_type_no         tinyint comment '典当类型编号',
   pawn_basic_property  varchar(512) comment '物品基础属性',
   pawn_pic             varchar(512) comment '物品图片',
   orther_pic           varchar(512) comment '其他图片',
   pawn_attachment      varchar(512) comment '附件',
   pawn_attachment_pic  varchar(512) comment '附件图片',
   pawn_attachment_property varchar(512) comment '附加属性',
   status               varchar(20) comment '状态',
   operator_post        varchar(64) comment '操作职位',
   operator             varchar(64) comment '操作员',
   remark               varchar(512) comment '备注',
   last_update_time     datetime comment '修改时间',
   create_date          datetime comment '创建时间',
   pre_date             datetime comment '意向提交时间',
   primary key (pre_order_id)
);

alter table pawn_pre_order comment '意向订单';

/*==============================================================*/
/* Table: pawn_put_money_log                                    */
/*==============================================================*/
create table pawn_put_money_log
(
   id                   char(32) not null comment 'id',
   oid                  char(32) comment '所属订单',
   loan_amount          decimal(18,2) comment '放款金额',
   loan_date            datetime comment '放款日期',
   created_date         datetime comment '创建日期',
   load_by              varchar(50) comment '放款人',
   primary key (id)
);

alter table pawn_put_money_log comment '放款记录列表';

/*==============================================================*/
/* Table: pawn_user                                             */
/*==============================================================*/
create table pawn_user
(
   id                   char(32) not null comment 'id',
   name                 varchar(10) comment '姓名',
   card_no              varchar(20) comment '身份证',
   mobile               varchar(20) comment '手机号码',
   pwd                  datetime comment '密码',
   auth                 int comment '是否实名认证(0:未认证，1:已经认证)',
   create_time          datetime comment '注册时间',
   last_update_time     datetime comment '最后修改时间',
   primary key (id)
);

alter table pawn_user comment '用户表';

/*==============================================================*/
/* Table: pawn_user_address                                     */
/*==============================================================*/
create table pawn_user_address
(
   id                   char(32) not null comment 'ID',
   uid                  char(32) comment '用户id',
   name                 varchar(20) comment '收件人',
   province             varchar(10) comment '省',
   city                 varchar(10) comment '市',
   area                 varchar(10) comment '区',
   addr                 varchar(200) comment '地址',
   post_code            varchar(10) comment '邮编',
   mobile               varchar(20) comment '手机',
   phone                varchar(30) comment '座机',
   create_time          datetime comment '添加时间',
   last_update_time     datetime comment '最后修改时间',
   primary key (id)
);

alter table pawn_user_address comment 'pawn_user_address';

/*==============================================================*/
/* Table: pawn_user_bankcard                                    */
/*==============================================================*/
create table pawn_user_bankcard
(
   id                   char(32) not null comment 'id',
   uid                  char(32) comment '用户id',
   account_name         varchar(50) comment '开户户名',
   account_bank         varchar(100) comment '开户银行',
   card_no              varchar(50) comment '银行卡号',
   province             varchar(20) comment '所在省',
   city                 varchar(20) comment '所在市',
   acount_branch_bank   varchar(100) comment '开户支行',
   create_time          datetime comment '添加时间',
   last_update_time     datetime comment '最后修改时间',
   primary key (id)
);

alter table pawn_user_bankcard comment '用户银行卡';

/*==============================================================*/
/* Table: pwan_continue_record                                  */
/*==============================================================*/
create table pwan_continue_record
(
   id                   char(32) not null comment 'id',
   oid                  char(32) comment '所属订单',
   uid                  char(32) comment '所属用户',
   begin_date           date comment '续当日期',
   deadline             int comment '续当期限',
   end_date             date comment '截止日期',
   renewal_money        decimal(18,2) comment '续当费用',
   overdue_fine         decimal(18,2) comment '逾期滞纳金',
   voucher              varchar(32) comment '续当凭证',
   primary key (id)
);

alter table pwan_continue_record comment '续当记录';

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

