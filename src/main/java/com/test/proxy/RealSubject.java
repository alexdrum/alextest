package com.test.proxy;

/**
 * Created by alexdrum on 2017/8/2.
 */
public class RealSubject implements Subject {
    public void doSomething() {
        System.out.println("call doSomething()");
    }
}
