package com.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by ALEXDRUM on 2017/6/19.
 */
public class TestUtils {
    public static void printMap(ConcurrentHashMap<Object, Object> map){
        for(Map.Entry<Object, Object> entry : map.entrySet()){
            log("Key：" + entry.getKey());
            log("Value：" + entry.getValue());
        }
    }

    public static void log(Object log){
        System.out.println(log);
    }
}
