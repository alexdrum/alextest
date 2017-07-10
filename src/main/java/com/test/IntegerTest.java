package com.test;

import java.lang.*;

public class IntegerTest {

    public static void main(String[] args) {

        int i = 170;
        System.out.println("Number = " + i);

         /* returns the string representation of the unsigned integer value
         represented by the argument in binary (base 2) */
        System.out.println("Binary = " + Integer.toBinaryString(i));

        // returns the number of one-bits
        System.out.println("Number of one bits = " + Integer.bitCount(i));

        /* returns an int value with at most a single one-bit, in the position
        of the highest-order ("leftmost") one-bit in the specified int value */
        System.out.println("Highest one bit = " + Integer.highestOneBit(i));

        /* returns an int value with at most a single one-bit, in the position
        of the lowest-order ("rightmost") one-bit in the specified int value.*/
        System.out.println("Lowest one bit = " + Integer.lowestOneBit(i));

        /*returns the number of zero bits preceding the highest-order
        ("leftmost")one-bit */
        System.out.print("Number of leading zeros = ");
        System.out.println(Integer.numberOfLeadingZeros(i));

    }
}