package com.zkai.xxbs.shiro;

import com.zkai.xxbs.datamodel.entity.user.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-12 上午 11:55
 **/
public final class ShiroUtils {

    private ShiroUtils(){}

   public static UserEntity login(String account,String pwd){

       SecurityUtils.getSubject().login(new UsernamePasswordToken(account,pwd));
       return (UserEntity)SecurityUtils.getSubject().getPrincipal();

   }
}
