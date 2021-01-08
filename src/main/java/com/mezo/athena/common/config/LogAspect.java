package com.mezo.athena.common.config;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author qzrs
 */
@Aspect
@Component
public class LogAspect {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * com.mezo.athena.controller.*.*(..))")
    public void logPointCut() {

    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        logger.info("请求IP:{},请求类型:{},请求地址:{}",request.getRemoteAddr(),request.getMethod(),request.getRequestURI());
        logger.info("CLASS_METHOD:{}.{}",joinPoint.getSignature().getDeclaringTypeName(),joinPoint.getSignature().getName());
        logger.info("参数:{}", Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret",pointcut = "logPointCut()")
    public void doAfterReturning(Object ret) {
        logger.info("返回值:{}", JSONObject.toJSONString(ret));
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint point) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = point.proceed();
        long endTime = System.currentTimeMillis();
        logger.info("耗时:{}", endTime - startTime);
        return proceed;
    }
}
