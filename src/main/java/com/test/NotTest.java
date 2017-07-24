package com.test;

/**
 * Created by alexdrum on 2017/7/24.
 */
public class NotTest {
    public static void main(String[] args) {
        int a = 100;
        a = ~a;
        TestUtils.log("a:" + a);
    }
}