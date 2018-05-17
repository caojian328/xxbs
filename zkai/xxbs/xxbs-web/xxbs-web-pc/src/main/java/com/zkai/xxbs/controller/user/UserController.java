package com.zkai.xxbs.controller.user;


import com.zkai.xxbs.controller.BaseController;
import com.zkai.xxbs.datamodel.PagerModel;
import com.zkai.xxbs.datamodel.entity.user.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 用户WEB控制器
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-01 下午 3:45
 **/
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @RequestMapping("/info")
    public @ResponseBody Object info() throws Exception{

        PagerModel pagerModel = new PagerModel(10,1);

        Map<String,String> map = new HashMap<String, String>();
        map.put("name","曹健");
        map.put("age","34");
        map.put("id","1");

        return this.getServiceFactory().getUserService().queryPaging(pagerModel);
    }


    /**
     * 用户注册
     * @param mobile
     * @param validCode
     * @return
     * @throws Exception
     */
    @RequestMapping("/register")
    public @ResponseBody Object register(String mobile,String validCode) throws Exception{

        //验证手机验证码 validCode
        if("123456".equals(validCode)){

        }

        //构建用户对象实体
        UserEntity  userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        userEntity.setMobile(mobile);
        userEntity.setAccount(mobile);
        userEntity.setPassword("123456");
        this.getServiceFactory().getUserService().create(userEntity);

        return 1;
    }
}
