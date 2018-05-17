package com.zkai.financial.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zkai.financial.apis.user.UserServiceApi;
import com.zkai.financial.controller.BaseController;
import com.zkai.financial.dto.ResponseDto;
import com.zkai.financial.dto.user.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/user")
public class TestController extends BaseController{

	//@Value("${from}")
	private String from;

    @Autowired
    private UserServiceApi userServiceApi;

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/test")
    @HystrixCommand(
    		fallbackMethod = "fallback"/*, 
    		commandProperties = {
    				@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    		}*/
    )
    public ResponseDto<?> test(String uid) {
    	
    	UserDto userDto = this.userServiceApi.queryByUid(uid);
    	userDto.setAddress(this.from);
    	try{
    		//Thread.sleep(1800);
    	}catch(Exception e){
    		
    	}
    	//System.out.println(1/0);
    	return success(userDto);
    			
    }

    
    public ResponseDto<?> fallback(String productId) {
        LOGGER.error("熔断了....");
        return fail();
    }

}