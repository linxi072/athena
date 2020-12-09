package com.mezo.athena.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringContextUtil {

    private ApplicationContext applicationContext;

    public SpringContextUtil() {
        applicationContext = new ClassPathXmlApplicationContext();
    }
    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public Object getBean(String className) {
        return applicationContext.getBean(className);
    }
}
