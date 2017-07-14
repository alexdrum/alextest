package com.test;

/**
 * Created by alexdrum on 2017/7/13.
 */
public class PercentTest {
    public static void main(String[] args) {
        // 计算准确率
        double k = (double) 3400 / 780000;
        k = (1-k) * 100;
        java.math.BigDecimal big = new java.math.BigDecimal(k);
        String accuracyRate = big.setScale(2, java.math.BigDecimal.ROUND_HALF_UP).doubleValue() + "%";
        TestUtils.log(accuracyRate);
    }
}