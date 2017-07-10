package com.test;

/**
 * Created by alexdrum on 2017/7/7.
 */
public class pointerTest {
    public static void main(String[] args){
        int i = 0;
        int result = i;
        i = 65535;
        TestUtils.log(result);

        Integer a = 0;
        Integer b = a;
        a = 65536;
        TestUtils.log(b);
    }
}
