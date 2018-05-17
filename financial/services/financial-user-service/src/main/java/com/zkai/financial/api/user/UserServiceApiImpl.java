package com.zkai.financial.api.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zkai.financial.apis.ApiPaths;
import com.zkai.financial.apis.bonus.BonusServiceApi;
import com.zkai.financial.biz.user.UserBiz;
import com.zkai.financial.dto.user.UserDto;

@RestController
@RequestMapping(ApiPaths.USER_SERVICE_PATH)
public class UserServiceApiImpl {

	@Autowired
	private UserBiz userBiz;

	@Autowired
	private BonusServiceApi bonusServiceApi;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceApiImpl.class);

	
	@RequestMapping(value = "/queryByUid", method = RequestMethod.GET)
	public UserDto queryByUid(@RequestParam(value = "uid") String uid) {

		LOGGER.info("uid>>>" + uid);
		UserDto userDto = null;
		
		userDto = this.userBiz.queryByUid(uid);
		LOGGER.info("userDto>>>" + userDto);
		userDto.setBonusList(this.bonusServiceApi.queryBonusByUid(uid));
		/*
		try {
			
			
		} catch (Exception e) {
			
			LOGGER.error("查询用户信息出错：\n",e);
		}*/
 
		return userDto;
	}

}