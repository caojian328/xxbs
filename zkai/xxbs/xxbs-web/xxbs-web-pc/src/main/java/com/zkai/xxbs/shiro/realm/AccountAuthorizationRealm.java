package com.zkai.xxbs.shiro.realm;

import com.zkai.common.str.MD5Utils;
import com.zkai.xxbs.datamodel.entity.user.UserEntity;
import com.zkai.xxbs.service.ServiceFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-07 下午 12:15
 **/
@Slf4j
public class AccountAuthorizationRealm extends AuthorizingRealm {

    @Autowired
    private ServiceFactory serviceFactory;



    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;
        String userName = token.getUsername();
        String password = new String(token.getPassword());
        UserEntity user;
        try{
            user = this.serviceFactory.getUserService().queryUser(userName,MD5Utils.md5(password));
            if(user == null){
                throw new AccountException("帐号或密码不正确");
            }
            //用户状态是否是锁定
            if(user.getState() == -1){
                throw new AccountException("帐号已经锁定");
            }

        }catch (Exception e){
            log.error("登录验证失败",e);
            throw new AccountException(e);
        }

        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        //String username = (String)principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<String>();
        roles.add("1001");
        roles.add("1002");
        info.setRoles(roles);

        Set<String> permissions = new HashSet<String>();
        permissions.add("/user/list");
        permissions.add("/user/info");
        info.setStringPermissions(permissions);

        return info;
    }
}
