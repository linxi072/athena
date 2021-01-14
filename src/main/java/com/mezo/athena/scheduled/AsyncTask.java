package com.mezo.athena.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author qzrs
 */
@Component
public class AsyncTask {
    @Scheduled(cron = "0/5 * * * * ?")
    public void test1() {
        System.out.println("---------test1---------");
    }

    @Scheduled(cron = "1/5 * * * * ?")
    public void test2() {
        System.out.println("---------test2---------");
    }

    @Scheduled(cron = "2/5 * * * * ?")
    public void test3() {
        System.out.println("---------test3---------");
    }

    @Scheduled(cron = "3/5 * * * * ?")
    public void test4() {
        System.out.println("---------test4---------");
    }

    @Scheduled(cron = "4/5 * * * * ?")
    public void test5() {
        System.out.println("---------test5---------");
    }
}
