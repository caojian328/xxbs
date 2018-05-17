package com.zkai.financial.shiro.dao;

import org.springframework.data.repository.CrudRepository;

import com.zkai.financial.web.model.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {
	
	public UserInfo findByUsername(String username);
}
