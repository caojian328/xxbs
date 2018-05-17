package com.zkai.financial.apis.user;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zkai.financial.apis.ApiNames;
import com.zkai.financial.apis.ApiPaths;
import com.zkai.financial.dto.user.UserDto;

/**
 * 用户服务接口
 * 
 * @author caojian
 *
 */
@FeignClient(value = ApiNames.USER_SERVICE_NAME, fallback = UserServiceCallBack.class)
public interface UserServiceApi {

	@RequestMapping(value = ApiPaths.USER_SERVICE_PATH + "/queryByUid", method = RequestMethod.GET)
	UserDto queryByUid(@RequestParam(value = "uid") String uid);
	
}
