package com.test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by alexdrum on 2017/7/5.
 */
public class ListsTest {
    public static void main(String[] args) {
        List<String> testList = Lists.newArrayList();
        TestUtils.log(testList);
    }
}