package com.zkai.financial.biz.bonus.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkai.financial.biz.bonus.UserBonusBiz;
import com.zkai.financial.dao.bonus.UserBonusMapper;
import com.zkai.financial.dto.bonus.UserBonusDto;

@Service
public class UserBonusBizImpl implements UserBonusBiz{

	@Autowired
	private UserBonusMapper userBonusMapper;
	
	@Override
	public List<UserBonusDto> queryBonusByUid(String uid) {
		
		return userBonusMapper.queryBonusByUid(uid);
	}

}
