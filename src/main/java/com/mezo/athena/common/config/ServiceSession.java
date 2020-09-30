package com.mezo.athena.common.config;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ServiceSession {

    ConcurrentHashMap map =new ConcurrentHashMap();

    public void add(Object key,Object val) {
        Object o = map.get(key);
        if (o!=null) {
            throw new IllegalArgumentException("已存在");
        }
        map.put(key,val);
    }

    public void update(Object key,Object val){
        Object o = map.get(key);
        if (o==null) {
            throw new IllegalArgumentException("不存在");
        }
        map.put(key,val);
    }

    public Object get(Object key) {
        return map.get(key);
    }

    public List list() {
       return Collections.singletonList(map.values());
    }
}
