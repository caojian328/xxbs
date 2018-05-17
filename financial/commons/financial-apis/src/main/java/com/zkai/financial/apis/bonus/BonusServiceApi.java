package com.zkai.financial.apis.bonus;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zkai.financial.apis.ApiNames;
import com.zkai.financial.apis.ApiPaths;
import com.zkai.financial.dto.bonus.UserBonusDto;

/**
 * 红包服务接口
 * @author caojian
 * 
 */
@FeignClient(value = ApiNames.BONUS_SERVICE_NAME, fallback = BonusServiceCallBack.class)
public interface BonusServiceApi { 

	@RequestMapping(value = ApiPaths.BONUS_SERVICE_PATH+"/queryBonusByUid",method = RequestMethod.GET)
	List<UserBonusDto> queryBonusByUid(@RequestParam(value = "uid") String uid);
	 
}
