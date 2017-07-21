package com.test;

/**
 * Created by alexdrum on 2017/6/16.
 */
public class ShiftTest {
    public static void main(String[] args)
    {
        test3();
    }

    public static void test1(){
        System.out.println(3<<2);//3左移2位
        System.out.println(-3<<2);//-3左移2位
        System.out.println(6>>2);//6右移2位
        System.out.println(-6>>2);//-6右移2位
    }

    public static void test2(){
        System.out.println(-8>>>1);
        System.out.println(-8>>1);
    }


    public static void test3(){
        Integer var1 = new Integer(7865421);
        System.out.println(TestUtils.toFullBinaryString(var1));
        Integer var2 = var1 >>> 16;
        System.out.println(TestUtils.toFullBinaryString(var2));
        var1 ^= var2;
        System.out.println(TestUtils.toFullBinaryString(var1));
        Integer var3 = 0x7fffffff;
        System.out.println(TestUtils.toFullBinaryString(var3));
    }

    public static void andTest() {
        long nowTime = 20170717000000L;
    }
}