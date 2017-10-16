package com.test;

/**
 * Created by ALEXDRUM on 2017/6/19.
 */
public class TestConcurrentHashMap {
    public static void main(String[] args){
        test1();
    }

    private static void test1(){
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>(88);
        int putCount = 100000;
        for(int i = 0; i < putCount; i++){
            concurrentHashMap.put(i,i);
        }
//        TestUtils.printMap(concurrentHashMap);
        concurrentHashMap.remove(36);
    }
}
