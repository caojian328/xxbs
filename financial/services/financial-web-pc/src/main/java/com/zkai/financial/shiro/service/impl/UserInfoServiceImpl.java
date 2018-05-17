package com.zkai.financial.shiro.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zkai.financial.shiro.dao.UserInfoRepository;
import com.zkai.financial.shiro.service.UserInfoService;
import com.zkai.financial.web.model.UserInfo;

@Service
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoRepository userInfoRepository;

	@Override
	public UserInfo findByUsername(String username) {

		return userInfoRepository.findByUsername(username);
	}

}
