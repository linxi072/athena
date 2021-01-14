package com.mezo.athena.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author qzrs
 */
@Configuration
public class CustomScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        //设定一个长度5的定时任务线程池
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
        taskRegistrar.setScheduler(executor);
    }
}
