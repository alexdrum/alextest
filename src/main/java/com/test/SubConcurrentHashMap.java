package com.test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhaojw on 2017/6/20.
 */
public class SubConcurrentHashMap<K,V> extends ConcurrentHashMap {

    /* ---------------- 常量 -------------- */

    /**
     * 本类中table的最大容量.  该值必须正好为1 << 30，以保持在两个
     * table大小的幂的Java数组分配和索引限制之内。再次，32bit 最高
     * 两bit将用于控制和调度
     */
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    /**
     * table 初始化和大小调整信号值.
     * 当它为负值时，table正在初始化或调整大小：
     * -1 为初始化
     * 其他负值为活跃的调整大小线程个数，例如-3就有3个活跃线程
     * 其他情况，当table为null时，保存初始化时要使用的表初始大小（默认值0）
     * 初始化后，保存下一个元素计数值，以在需要的时候调整table大小。
     */
    private transient volatile int sizeCtl;

    /**
     * 将输入的table大小转换为最相近的一个2次方数
     */
    private static final int tableSizeFor(int c) {
        // 计算最相近的2次方数
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        // 判断最后计算出的数是不是比table最大容量大，如果是就返回最大容量
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * 新建一个带有初始大小（2的n次幂数）的空map，且此值兼容一定数量
     * 元素并不需要动态扩容
     *
     * @param initialCapacity 初始化大小，在放入这个值数量以内的元素后table不需要动态扩容
     * @throws IllegalArgumentException 如果传入参数为负数
     *
     */
    public SubConcurrentHashMap(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException();
        int cap = 0;
        int halfMaximumCapacity = MAXIMUM_CAPACITY >>> 1;
        if(initialCapacity >= halfMaximumCapacity){
            cap = MAXIMUM_CAPACITY;
        }else{
            int toBePoweredInitialCapacity =  initialCapacity + (initialCapacity >>> 1) + 1;
            int poweredInitialCapacity = toBePoweredInitialCapacity;
            cap = poweredInitialCapacity;
        }
        sizeCtl = cap;
    }
}

