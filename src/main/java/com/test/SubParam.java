package com.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class SubParam extends Param<HeapOOM, JavaVMStackOMM>
        implements InterfaceTest0
        , InterfaceTest1<HeapOOM, JavaVMStackOMM>
        , InterfaceTest2<JavaVMStackSOF, JavaMethodAreaOOM>
        , Comparable<SubParam> {
    public static void main(String[] args) {
        SubParam subParamTest = new SubParam();
        Class subParamTestClass = comparableClassFor(subParamTest);
        TestUtils.log(subParamTestClass);
    }

    public void interfaceMethod0() {
        TestUtils.log("I am interfaceMethod0");
    }

    public void interfaceMethod1() {
        TestUtils.log("I am interfaceMethod1");
    }

    public void interfaceMethod2() {
        TestUtils.log("I am interfaceMethod2");
    }

    public void interfaceMethod3() {
        TestUtils.log("I am interfaceMethod3");
    }

    public void interfaceMethod4() {
        TestUtils.log("I am interfaceMethod4");
    }

    @Override
    public int compareTo(SubParam o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    /**
     * 用来判断传入对象是否是实现了Comparable接口的类
     * 如果是则返回次对象，不是则返回null
     */
    public static Class<?> comparableClassFor(Object x) {
        // 如果对象实现了Comparable接口
        if (x instanceof Comparable) {

            // 获得对象x的相关信息
            Class<?> comparableClass = x.getClass();                // x所属的类信息
            Type[] actualizedInterfaces = comparableClass.getGenericInterfaces();  // 获得x所属类直接实现的接口
            Type[] typeArguments;
            Type currentInterface;
            ParameterizedType parameterizedType;

            // 短路检查，如果是String类型直接返回
            if (comparableClass == String.class)
                return comparableClass;

            // 如果继承了接口，则逐个检查
            if (actualizedInterfaces != null) {
                for (int i = 0; i < actualizedInterfaces.length; ++i) {
                    // 获得当前判断的接口
                    currentInterface = actualizedInterfaces[i];
                    // 获得接口的n（若干个）泛型参数类型
                    try {
                        parameterizedType = (ParameterizedType) currentInterface;
                    }catch (ClassCastException e){
                        TestUtils.log(e);
                        continue;
                    }
                    // 将n个泛型参数类型放入typeArguments数组中用于判断
                    typeArguments = parameterizedType.getActualTypeArguments();
                    // 如果：
                    // 当前实现接口含有泛型参数
                    // 当前接口是Comparable接口或者实现了Comparable接口
                    // 当前接口泛型参数不为null、长度为1、泛型参数就是当前方法传入对象的类
                    if ((currentInterface instanceof ParameterizedType) &&
                            (parameterizedType.getRawType() == Comparable.class) &&
                            (typeArguments != null && typeArguments.length == 1 && typeArguments[0] == comparableClass)){
                        // 满足以上条件返回传入对象x的所属类
                        return comparableClass;
                    }
                }
            }
        }
        return null;
    }
}