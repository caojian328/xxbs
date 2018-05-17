package com.zkai.financial.dao.user;

import com.zkai.financial.db.BaseReadMapper;
import com.zkai.financial.dto.user.UserDto;


public interface UserMapper extends BaseReadMapper{
 
	public UserDto queryByUid(String uid);
	 
}  
  