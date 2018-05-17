package com.zkai.xxbs.dao.api.user;

import com.zkai.xxbs.dao.IDao;
import com.zkai.xxbs.datamodel.entity.user.UserEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Author 曹健【115359178@qq.com】
 * @Date by 2017/6/10 0010 上午 9:50
 */
public interface UserDao extends IDao {

    UserEntity queryByAccountAndPwd(@Param("account") String userName,
                                    @Param("pwd") String pwd)throws Exception;

}
