package com.mezo.athena.common.config;

import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class AppCache {
    /**
     * 系统参数
     */
    ConcurrentHashMap globalMap = new ConcurrentHashMap();
    /**
     * 数据字典
     */
    ConcurrentHashMap codeMap = new ConcurrentHashMap();
    /**
     * 在线用户
     */
    ConcurrentHashMap userMap = new ConcurrentHashMap();



    public void init() {

    }
}
