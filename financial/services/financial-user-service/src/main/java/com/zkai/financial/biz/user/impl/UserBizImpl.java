package com.zkai.financial.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkai.financial.biz.user.UserBiz;
import com.zkai.financial.dao.user.UserMapper;
import com.zkai.financial.dto.user.UserDto;

@Service
public class UserBizImpl implements UserBiz {

	@Autowired 
	private UserMapper userMapper; 

	public UserDto queryByUid(String uid) {
		return this.userMapper.queryByUid(uid);
	}

}  
