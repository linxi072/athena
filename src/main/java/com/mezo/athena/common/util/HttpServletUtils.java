package com.mezo.athena.common.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author qzrs
 */
@Component
public class HttpServletUtils {

   public static HttpServletRequest getRequest() {
       ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
       return requestAttributes.getRequest();
   }

   public static HttpServletResponse getResponse() {
       ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
       return requestAttributes.getResponse();
   }

   public static HttpSession getSession() {
       ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
       return requestAttributes.getRequest().getSession();
   }
}
