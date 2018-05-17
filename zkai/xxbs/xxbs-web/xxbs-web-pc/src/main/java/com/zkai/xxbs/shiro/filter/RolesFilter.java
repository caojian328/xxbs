package com.zkai.xxbs.shiro.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


/**
 * shiro自定义角色过滤器
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-07 下午 12:25
 **/
public class RolesFilter  extends AccessControlFilter {

    static final String LOGIN_URL = "/goLogin";
    static final String UNAUTHORIZED_URL = "/unauthorized";

    @Override
    protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object mappedValue) throws Exception {
        String[] arra = (String[])mappedValue;

        Subject subject = getSubject(request, response);
        for (String role : arra) {
            if(subject.hasRole(role)){
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request,
                                     ServletResponse response) throws Exception {

        Subject subject = getSubject(request, response);
        if (subject.getPrincipal() == null) {//表示没有登录，重定向到登录页面
            saveRequest(request);
            WebUtils.issueRedirect(request, response, LOGIN_URL);
        } else {
            if (StringUtils.hasText(UNAUTHORIZED_URL)) {//如果有未授权页面跳转过去
                WebUtils.issueRedirect(request, response, UNAUTHORIZED_URL);
            } else {//否则返回401未授权状态码
                WebUtils.toHttp(response).sendError(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
        return false;
    }
}
