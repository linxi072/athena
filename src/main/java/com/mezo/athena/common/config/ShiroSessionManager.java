package com.mezo.athena.common.config;

import com.alibaba.druid.util.StringUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * 自定义获取token
 */
public class ShiroSessionManager extends DefaultWebSessionManager {
    /**
     * 定义常量
     */
    private final static String AUTHORIZATION = "Authorization";
    private final static String REFERENCED_SESSION_ID_SOURCE = "Stateless request";
    /**
     * 重写构造器
     */
    public ShiroSessionManager(){
        super();
        this.setDeleteInvalidSessions(true);
    }

    /**
     * 重写方法实现从请求头获取token便于接口统一
     * 每次请求进来，shiro会去从请求头找Authorization这个key对应的value（token）
     */
    @Override
    public Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String token = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        //如果请求头中存在token，则从请求头中获取token
        if (!StringUtils.isEmpty(token)) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,REFERENCED_SESSION_ID_SOURCE);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID,token);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID,Boolean.TRUE);
            return token;
        } else {
            //否则按默认规则从cookie去token
            return super.getSessionId(request,response);
        }
    }

}
