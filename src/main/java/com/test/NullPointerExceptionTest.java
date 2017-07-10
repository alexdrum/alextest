package com.test;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by alexdrum on 2017/7/7.
 */
public class NullPointerExceptionTest {
    public static void main(String[] args){
        String[] stringArray = null;
        int arrayLength = stringArray.length;
        System.out.println(arrayLength);
    }
}
