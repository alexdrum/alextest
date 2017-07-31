package com.test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by alexdrum on 2017/7/31.
 */
public class ForeachTest {
    public static void main(String[] args) {
        List<Object> testList = Lists.newArrayList();
        testList.forEach(hahaha -> System.out.println("hahaha"));
    }
}