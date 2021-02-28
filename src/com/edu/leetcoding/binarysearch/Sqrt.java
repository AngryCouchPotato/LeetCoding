package com.edu.leetcoding.binarysearch;

/**
 *  69. Sqrt(x)
 *
 *  Given a non-negative integer x, compute and return the square root of x.
 *  Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 *  Example 1:
 *      Input: x = 4
 *      Output: 2
 *  Example 2:
 *      Input: x = 8
 *      Output: 2
 *  Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 *
 *  Constraints:
 *      0 <= x <= 2^31 - 1
 *
 * */
public class Sqrt {

    /**
     *  O(log(n)) - time | O(1) - space
     */
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int left = 2;
        int right = x / 2;
        while (left <= right) {
            int mid = (left + right) / 2;
            long res = (long) mid * mid;
            if (res > x) {
                right = mid - 1;
            } else if (res < x) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return right;
    }
}
