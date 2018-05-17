package com.zkai.xxbs.shiro.filter;

import com.zkai.xxbs.shiro.Servlets;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 是否登录过滤器
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-07 下午 12:28
 **/
public class LoginFilter extends AccessControlFilter {

    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {

        if (isLoginRequest(request, response)) {
            return true;
        } else {
            Subject subject = getSubject(request, response);
            Object o = subject.getPrincipal();
            return  o != null;
        }
    }

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Subject subject = getSubject(request, response);
        httpResponse.setStatus(200);
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;

        if (Servlets.isAjaxRequest((HttpServletRequest)request))
        {
            String msg = "";
            try {
                out = httpResponse.getWriter();
                if (subject.getPrincipal() == null) {
                    msg = "您尚未登录或登录时间过长,请重新登录!";
                } else {
                    msg = "您没有足够的权限执行该操作!";
                }
                out.print("{result:0,msg:'"+msg+"'}");
            }catch(IOException e){

            }finally {
                if (out != null) {
                    out.close();
                }
            }
        }else {
            String url = ((HttpServletRequest) request).getRequestURI();
            if(url.indexOf("/login") == -1){
                saveRequestAndRedirectToLogin(request, response);
            }
        }

        return false;
    }
}
