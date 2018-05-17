package com.zkai.xxbs.controller.index;


import com.zkai.xxbs.controller.BaseController;
import com.zkai.xxbs.datamodel.entity.user.UserEntity;
import com.zkai.xxbs.shiro.ShiroUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 首页WEB控制器
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-01 下午 3:45
 **/
@Slf4j
@Controller
@RequestMapping("/")
public class IndexController extends BaseController {


    @RequestMapping("index")
    public String index() throws Exception {

        return "index";
    }


    /**
     * 跳转到没有权限页面
     *
     * @return
     */
    @RequestMapping(value = "unauthorized", method = RequestMethod.GET)
    public ModelAndView unauthorized() {

        return new ModelAndView("/unauthorized");
    }


    /**
     * 跳转到登录页面
     *
     * @return
     */
    @RequestMapping(value = "goLogin", method = RequestMethod.GET)
    public ModelAndView goLogin() {

        return new ModelAndView("/login");
    }


    /**
     * 登录提交
     *
     * @param entity
     * @param rememberMe
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(UserEntity entity,
                        Boolean rememberMe,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        Model model) {

        try {

            entity = ShiroUtils.login(entity.getAccount(), entity.getPassword());

            model.addAttribute("userEntity", entity);
            /**
             * shiro 获取登录之前的地址
             * 之前0.1版本这个没判断空。
             */
            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = null;
            if (null != savedRequest) {
                url = savedRequest.getRequestUrl();
                System.out.println("url=" + url);
                WebUtils.issueRedirect(request, response, url);
            }

        } catch (Exception e) {
            log.error("登录方法出现异常：\n",e);
        }

        return "/index";
    }




    /**
     * 跳转到注册页面
     *
     * @return
     */
    @RequestMapping(value = "goRegister", method = RequestMethod.GET)
    public ModelAndView goRegister() {

        return new ModelAndView("/register");
    }

}
