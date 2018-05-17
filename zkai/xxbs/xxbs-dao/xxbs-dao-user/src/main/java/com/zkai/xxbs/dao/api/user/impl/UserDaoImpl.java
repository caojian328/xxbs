package com.zkai.xxbs.dao.api.user.impl;

import com.zkai.xxbs.dao.AbstractDao;
import com.zkai.xxbs.dao.IDao;
import com.zkai.xxbs.dao.api.user.UserDao;
import com.zkai.xxbs.dao.mapper.user.UserMapper;
import com.zkai.xxbs.datamodel.entity.user.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author 曹健【115359178@q.com】
 * @create 2017-06-10 上午 10:25
 **/
@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected IDao getMapper() {
        return this.userMapper;
    }

    public UserEntity queryByAccountAndPwd(@Param("account") String account, @Param("pwd") String pwd) throws Exception {
        return userMapper.queryByAccountAndPwd(account, pwd);
    }
}
