package com.zkai.financial.web.pc;

import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zkai.financial.controller.BaseController;


@Controller
@RequestMapping("/userInfo/")
public class UserController extends BaseController{

    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userAdd(Map<String,Object> model) {
    	

    	return "add";
    			
    }
    
}