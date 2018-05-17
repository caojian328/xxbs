package com.zkai.xxbs.service.api.user;

import com.zkai.xxbs.datamodel.entity.user.UserEntity;
import com.zkai.xxbs.service.IService;

/**
 * 用户服务接口
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-01 下午 3:39
 **/
public interface UserService extends IService {

   UserEntity queryUser(String name,String password)throws Exception;

}
