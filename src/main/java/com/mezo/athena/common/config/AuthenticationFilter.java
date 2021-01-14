package com.mezo.athena.common.config;

import com.mezo.athena.demain.AthenaUser;
import com.mezo.athena.common.constant.CommonContext;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author qzrs
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURL().toString();
        if (isNeedAuth(url, req)) {
            doAuthenticationFilter(request, response, chain);
            chain.doFilter(request, response);
        }
    }

    private void doAuthenticationFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        request.setAttribute(CommonContext.FILTERED_REQUEST, true);
        HttpServletRequest req = (HttpServletRequest) request;
        AthenaUser sessionUser = getSessionUser(req);
        if (sessionUser == null) {
            try {
                redirectLogin(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private AthenaUser getSessionUser(HttpServletRequest req) {
        return (AthenaUser) req.getSession().getAttribute(CommonContext.CURRENT_USER_CONTEXT);
    }

    private void redirectLogin(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        String url = req.getRequestURL().toString();
        String queryString = req.getQueryString();
        if (StringUtils.isNotEmpty(queryString)) {
            url += queryString;
        }
        req.getSession().setAttribute(CommonContext.LOGIN_REDIRECT_URL, url);
        req.getRequestDispatcher(CommonContext.LOGIN_REDIRECT_URL).forward(request, response);
    }

    private boolean isNeedAuth(String url, HttpServletRequest req) {
        return isEscapeUrls(url) && req.getAttribute(CommonContext.FILTERED_REQUEST) == null;
    }

    private boolean isEscapeUrls(String url) {
        for (String filterPassUrl : CommonContext.FILTER_PASS_URLS) {
            if (url.indexOf(filterPassUrl) >= 0) {
                return true;
            }
        }
        return false;
    }
}
