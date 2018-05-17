package com.zkai.financial.dao.bonus;

import java.util.List;

import com.zkai.financial.db.BaseReadMapper;
import com.zkai.financial.dto.bonus.UserBonusDto;

public interface UserBonusMapper extends BaseReadMapper{
 
	public List<UserBonusDto> queryBonusByUid(String uid);
	 
}  
  