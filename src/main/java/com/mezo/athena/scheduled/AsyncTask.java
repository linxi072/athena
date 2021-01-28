package com.mezo.athena.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author qzrs
 */
@EnableScheduling
public class AsyncTask {

    Logger logger = LoggerFactory.getLogger(getClass());
    @Scheduled(cron = "0/5 * * * * ?")
    public void test1() {
        logger.info("---------test1---------");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void test2() {
        logger.info("---------test2---------");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void test3() {
        logger.info("---------test3---------");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void test4() {
        logger.info("---------test4---------");
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void test5() {
        logger.info("---------test5---------");
    }
}
