package com.mezo.athena.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.UndeclaredThrowableException;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * @author qzrs
 */
@Component
public class AthenaHandlerExceptionResolver implements HandlerExceptionResolver {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        Exception e = new Exception();
        if (ex instanceof UndeclaredThrowableException) {
            e = (Exception) ((UndeclaredThrowableException) ex).getUndeclaredThrowable();
        }
        String shortName = ClassUtils.getShortName(ex.getClass());
        if ("NoPermissionException".equals(shortName)) {
            logger.error("AthenaHandlerExceptionResolver NoPermissionException===>{}",shortName);
            e.printStackTrace();
            HashMap map = new HashMap();
            map.put("stackTrace",e.getStackTrace());
            map.put("errorMessage",e.getMessage());
            map.put("url",request.getRequestURI());
            return new ModelAndView("forward:/error/403",map);
        }
        return null;
    }
}
