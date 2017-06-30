package com.test;

/**
 * Created by ALEXDRUM on 2017/6/19.
 */
public class TestConcurrentHashMap {
    public static void main(String[] args){
        test1();
    }

    private static void test1(){
        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>(32);
        int putCount = 3600;
        for(int i = 0; i < putCount; i++){
            concurrentHashMap.put(i,i);
        }
        TestUtils.printMap(concurrentHashMap);
    }

    private static void test2(){
        int putCount = 11;
        SubConcurrentHashMap<Integer, Integer> subConcurrentHashMap = new SubConcurrentHashMap<Integer, Integer>(putCount);
        for(int i = 0; i < putCount; i++){
            subConcurrentHashMap.put(i,i);
        }

        // 打印结果
        TestUtils.printMap(subConcurrentHashMap);
    }
}
