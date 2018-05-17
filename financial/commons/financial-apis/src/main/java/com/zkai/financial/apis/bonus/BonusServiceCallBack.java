package com.zkai.financial.apis.bonus;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zkai.financial.dto.bonus.UserBonusDto;

@Component
public class BonusServiceCallBack implements BonusServiceApi{


	public List<UserBonusDto> queryBonusByUid(String uid) {
		 
		
		return new ArrayList<UserBonusDto>();
	}
	

}
