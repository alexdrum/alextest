package com.test;

/**
 * Created by alexdrum on 2017/6/16.
 */
public class ShiftTest {
    public static void main(String[] args)
    {
        test1();


    }

    public static void test1(){
        System.out.println(3<<2);//3左移2位
        System.out.println(-3<<2);//-3左移2位
        System.out.println(6>>2);//6右移2位
        System.out.println(-6>>2);//-6右移2位
    }
}
