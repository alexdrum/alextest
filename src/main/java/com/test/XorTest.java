package com.test;

/**
 * Created by alexdrum on 2017/7/24.
 */
public class XorTest {
    public static void main(String[] arguments) {
        int a = 8;
        int b = 23;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        TestUtils.log("a:" + a);
        TestUtils.log("b:" + b);
    }
}