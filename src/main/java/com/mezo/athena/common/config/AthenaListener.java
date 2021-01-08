package com.mezo.athena.common.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 优先级 listener > filter > servlet
 * @author qzrs
 */
@WebListener
public class AthenaListener implements ServletContextListener {
    /**
     * 用于初始化系统参数，方法等，只在系统启动时加载一次
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {

    }

    /**
     * 在系统关闭时，销毁
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
