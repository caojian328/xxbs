package com.zkai.financial.biz.bonus;

import java.util.List;

import com.zkai.financial.dto.bonus.UserBonusDto;

public interface UserBonusBiz {

	public List<UserBonusDto> queryBonusByUid(String uid);
} 
  