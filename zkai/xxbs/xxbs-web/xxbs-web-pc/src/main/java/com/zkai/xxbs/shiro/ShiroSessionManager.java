package com.zkai.xxbs.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * shiro会话管理
 *
 * @author 曹健【115359178@qq.com】
 * @create 2017-06-07 上午 10:45
 **/
public class ShiroSessionManager extends DefaultWebSessionManager {

    /**
     * 此主方法可以接收来自cookie中的sessionid与外部调用参数传来sessionid并切换到对应的会话
     * 如都不存在sessionid则交由shiro原类处理
     */
    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
       /** // 如果参数中包含“__sid”参数，则使用此sid会话。 例如：http://localhost/project?__sid=xxx&__cookie=true
        String sid = request.getParameter("__sid");

        if (StringUtils.isNotBlank(sid)) {
            // 是否将sid保存到cookie，浏览器模式下使用此参数。
            if (WebUtils.isTrue(request, "__cookie")){
                HttpServletRequest rq = (HttpServletRequest)request;
                HttpServletResponse rs = (HttpServletResponse)response;
                org.apache.shiro.web.servlet.Cookie template = getSessionIdCookie();
                SimpleCookie cookie = new SimpleCookie(template);
                cookie.setValue(sid); cookie.saveTo(rq, rs);
            }
            // 设置当前session状态
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
                    ShiroHttpServletRequest.URL_SESSION_ID_SOURCE); // session来源与url
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sid);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return sid;
        }else{

            HttpServletRequest rq = (HttpServletRequest)request;
            String token=rq.getHeader("token");
            if(StringUtils.isNotEmpty(token)){
                return token;
            }
            return super.getSessionId(request, response);
        }
            **/
        return super.getSessionId(request, response);
    }



    @Override
    protected void onStart(Session session, SessionContext context) {
        super.onStart(session, context);
        /**
         * 去掉URL中的jsssionid
         */
        ServletRequest request = WebUtils.getRequest(context);
        request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,ShiroHttpServletRequest.COOKIE_SESSION_ID_SOURCE);
    }

}
