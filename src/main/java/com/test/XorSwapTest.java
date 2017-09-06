package com.test;

import lombok.extern.slf4j.Slf4j;

/**
 * 异或运算测试
 */
@Slf4j
public class XorSwapTest {

    public static void main(String[] args) {
        Integer a = 5;
        Integer b = 4;
        xorSwap(a, b);
        TestUtils.log("a:" + a);
        TestUtils.log("b:" + b);
    }

    public static void xorSwap(Integer a, Integer b) {
        a = a + b;
        b = a - b;
        a = a - b;
    }
}
