package com.zkai.xxbs.datamodel.entity.user;

import com.zkai.xxbs.datamodel.BaseDataModel;
import lombok.Data;

/**
 * 用户信息实体
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-07 下午 4:50
 **/
@Data
public class UserEntity extends BaseDataModel {

    private static final long serialVersionUID = 13453453453453453L;

    private String nickName;

    private String realName;

    private int age;

    private int sex;

    private String idCard;

    private String mobile;

    private String address;

    private String phone;

    private String account;

    private String password;

    private int state;

}
