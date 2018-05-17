package com.zkai.financial.api.bonus;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zkai.financial.apis.ApiPaths;
import com.zkai.financial.biz.bonus.UserBonusBiz;
import com.zkai.financial.dto.bonus.UserBonusDto;

@RestController
@RequestMapping(ApiPaths.BONUS_SERVICE_PATH)
public class BonusServiceApiImpl{ 

	@Autowired
	private UserBonusBiz userBonusBiz;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BonusServiceApiImpl.class);

	
	@RequestMapping(value = "/queryBonusByUid",method = RequestMethod.GET)
    public List<UserBonusDto> queryBonusByUid(@RequestParam(value = "uid") String uid){
		LOGGER.info("查询用户红包信息：uid="+uid);
		return this.userBonusBiz.queryBonusByUid(uid); 
	}

}