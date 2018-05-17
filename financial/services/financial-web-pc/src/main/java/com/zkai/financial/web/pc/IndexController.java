package com.zkai.financial.web.pc;

import com.zkai.financial.controller.BaseController;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;


@Controller
@RequestMapping("/web/")
public class IndexController extends BaseController{

    
    @RequestMapping("/index")
    public String index(Map<String,Object> model) {
    	
    	model.put("time",new Date());  
        model.put("message","hello freemarker");  
    
    	return "index";
    			
    }


    @RequestMapping("/test/cookie")
    public String cookie(@RequestParam("browser") String browser, HttpServletRequest request, HttpSession session) {
        //取出session中的browser
        Object sessionBrowser = session.getAttribute("browser");
        if (sessionBrowser == null) {
            System.out.println("不存在session，设置browser=" + browser);
            session.setAttribute("browser", browser);
        } else {
            System.out.println("存在session，browser=" + sessionBrowser.toString());
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        return "index";
    }

    @RequestMapping(value="/login")
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {

       // 登录失败从request中获取shiro处理的异常信息。
       // shiroLoginFailure:就是shiro异常类的全类名.
       String exception = (String) request.getAttribute("shiroLoginFailure");
 
       System.out.println("exception=" + exception);
       String msg = "";
       if (exception != null) {
           if (UnknownAccountException.class.getName().equals(exception)) {
              System.out.println("UnknownAccountException -- > 账号不存在：");
              msg = "UnknownAccountException -- > 账号不存在：";
           } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
              System.out.println("IncorrectCredentialsException -- > 密码不正确：");
              msg = "IncorrectCredentialsException -- > 密码不正确：";
           } else if ("kaptchaValidateFailed".equals(exception)) {
              System.out.println("kaptchaValidateFailed -- > 验证码错误");
              msg = "kaptchaValidateFailed -- > 验证码错误";
           } else {
              msg = "else >> "+exception;
              System.out.println("else -- >" + exception);
           }
       }
       map.put("msg", msg);
       // 此方法不处理登录成功,由shiro进行处理.
       return "/login";
    }
    
}