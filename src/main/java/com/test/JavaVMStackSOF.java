package com.test;

/**
 * VMArgs：-verbose:gc -Xss128k
 * Created by alexdrum on 2017/5/5.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    private void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args){
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Exception e){
            System.out.println("stack length:"+oom.stackLength);
        }
    }
}
