package com.mezo.athena.common.config;

import org.springframework.util.DigestUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author qzrs
 */
@WebFilter(urlPatterns = "AthenaServlet")
public class AthenaFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);

        Long timeMillis = System.currentTimeMillis();
        DigestUtils.md5DigestAsHex(timeMillis.toString().getBytes());
    }
}
