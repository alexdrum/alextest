package com.test;

/**
 * Created by zhaojw on 2017/5/8.
 */
public class JavaMethodAreaOOM {

    static class OOMObject{}

    public static void main(String[] args){
        while(true){
            System.out.print("sdd");
            System.out.print("sdd");
        }
    }

}
