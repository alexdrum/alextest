package com.test.proxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static void main(String args[]) throws IOException{
        RealSubject real = new RealSubject();
        Subject proxySubject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),
                new Class[]{Subject.class},
                new ProxyHandler(real));

        proxySubject.doSomething();

        //write proxySubject class binary data to file
        createProxyClassFile();
    }

    public static void createProxyClassFile() throws IOException{
        String name = "ProxySubject";
        byte[] data = ProxyGenerator.generateProxyClass(name, new Class[]{Subject.class});
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(name + ".class");
            out.write(data);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(out!=null){
                out.close();
            }
        }
    }
}