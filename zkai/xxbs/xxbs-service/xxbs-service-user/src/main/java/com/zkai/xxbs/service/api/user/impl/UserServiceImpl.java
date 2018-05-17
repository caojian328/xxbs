package com.zkai.xxbs.service.api.user.impl;

import com.zkai.xxbs.dao.IDao;
import com.zkai.xxbs.datamodel.entity.user.UserEntity;
import com.zkai.xxbs.service.AbstractService;
import com.zkai.xxbs.service.api.user.UserService;
import org.springframework.stereotype.Service;

/**
 * 用户服务接口实现
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-01 下午 3:45
 **/
@Service("userService")
public class UserServiceImpl extends AbstractService implements UserService{

    protected IDao getDao() {
        return this.getDaoFactory().getUserDao();
    }


    public UserEntity queryUser(String name, String password) throws Exception {

        return this.getDaoFactory().getUserDao().queryByAccountAndPwd(name,password);
    }
}
