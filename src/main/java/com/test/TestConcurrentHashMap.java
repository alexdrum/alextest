package com.test;

import com.google.common.collect.Maps;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ALEXDRUM on 2017/6/19.
 */
@Slf4j
public class TestConcurrentHashMap {
    public static void main(String[] args){
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap(32);
        int putCount = 3600;
        for(int i = 0; i < putCount; i++){
            concurrentHashMap.put(i,i);
        }
        for(Map.Entry<Integer, Integer> entry : concurrentHashMap.entrySet()){
            TestUtils.log("当前键值对：");
            TestUtils.log(entry.getKey());
            TestUtils.log(entry.getValue());
        }
    }
}
