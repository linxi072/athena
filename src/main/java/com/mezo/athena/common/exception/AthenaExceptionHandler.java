package com.mezo.athena.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qzrs
 */
@ControllerAdvice
public class AthenaExceptionHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(value = IllegalDataException.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
        logger.error("AthenaExceptionHandler====>{}",e.getMessage());
        e.printStackTrace();
        String shortName = ClassUtils.getShortName(e.getClass());
        logger.error("AthenaExceptionHandler====>{}",shortName);
        ModelAndView view = new ModelAndView();
        view.addObject("stackTrace",e.getStackTrace());
        view.addObject("errorMessage",e.getMessage());
        view.addObject("url",request.getRequestURI());
        view.setViewName("forward:/error/500");
        return view;
    }
}
