package com.test;

/**
 * Created by zhaojw on 2017/4/18.
 */
public class TestMain {
    public static void main(String[] args){
        System.out.println("shit shit shit");

        Integer a = 100;
        Integer b = 100;

        Integer c = 200;
        Integer d = 200;

        System.out.println(a==b);
        System.out.println(c==d);

        System.out.println(c.equals(d));


        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);


        String str3 = new StringBuilder("ma").append("bi").toString();
        System.out.println(str3.intern() == str3);

        System.out.println("本机可使用的CPU数：" + Runtime.getRuntime().availableProcessors());

    }
}
