package com.zkai.financial.apis.user;

import org.springframework.stereotype.Component;

import com.zkai.financial.dto.user.UserDto;

@Component
public class UserServiceCallBack implements UserServiceApi{

	public UserDto queryByUid(String uid) {
		UserDto dto = new UserDto();
		dto.setId("-1");
		dto.setName("-1");
		dto.setMobile("-1");
		return dto;
	}

}
