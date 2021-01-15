package com.edu.leetcoding.bitmanipulation;

/*
    338. Counting Bits

    Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

    Example 1:
        Input: 2
        Output: [0,1,1]

    Example 2:
        Input: 5
        Output: [0,1,1,2,1,2]

 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            int temp = i;
            int count = 0;
            while (temp != 0) {
                count = count + (temp & 1);
                temp = temp >>> 1;
            }
            res[i] = count;
        }
        return res;
    }
}
