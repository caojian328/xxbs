package com.zkai.financial.shiro.service;

import com.zkai.financial.web.model.UserInfo;

public interface UserInfoService {

	 /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}
