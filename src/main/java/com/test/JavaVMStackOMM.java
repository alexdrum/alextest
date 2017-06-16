package com.test;

/**
 * VMArgs：-verbose:gc -Xss2m
 * Created by alexdrum on 2017/5/5.
 */
public class JavaVMStackOMM {
    private void dontStop(){
        while (true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args){
        JavaVMStackOMM javaVMStackOMM = new JavaVMStackOMM();
        javaVMStackOMM.stackLeakByThread();
    }
}
