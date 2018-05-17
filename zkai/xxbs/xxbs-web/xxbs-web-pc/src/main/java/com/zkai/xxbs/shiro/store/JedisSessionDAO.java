/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.zkai.xxbs.shiro.store;

import com.zkai.xxbs.shiro.Servlets;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Collection;

/**
 * 自定义授权会话管理类
 *
 * @author ThinkGem
 * @version 2014-7-20
 */
public class JedisSessionDAO extends AbstractSessionDAO {

    public static final String SESSION_KEY_PREFIX = "session_xxbs_";

    @Autowired
    private JedisManager jedisManager;


    @Override
    protected Serializable doCreate(Session session) {

        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.update(session);

        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {

        if (sessionId == null) {
            return null;
        }

        Session session = null;
        HttpServletRequest request = Servlets.getRequest();
        if (request != null) {
            String uri = request.getServletPath();
            // 如果是静态文件，则不获取SESSION
            if (Servlets.isStaticFile(uri)) {
                return null;
            }
            session = (Session) request.getAttribute(SESSION_KEY_PREFIX + sessionId);
            if (session != null) {
                return session;
            }
        }

        session = jedisManager.get(sessionId.toString());

        if (request != null && session != null) {
            request.setAttribute(SESSION_KEY_PREFIX + sessionId, session);
        }

        return session;
    }


    @Override
    public void update(Session session) throws UnknownSessionException {

        HttpServletRequest request = Servlets.getRequest();
        if (request != null) {
            String uri = request.getServletPath();
            // 如果是静态文件，则不更新SESSION
            if (Servlets.isStaticFile(uri)) {
                return;
            }
        }

        jedisManager.save(session);
    }

    @Override
    public void delete(Session session) {
        jedisManager.delete(session.getId().toString());
    }

    @Override
    public Collection<Session> getActiveSessions() {

        return this.jedisManager.getAllSessions();
    }
}
