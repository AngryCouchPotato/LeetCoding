package com.edu.leetcoding.array;

/*
    66. Plus One

    Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
    The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.
    You may assume the integer does not contain any leading zero, except the number 0 itself.

    Example 1:
        Input: digits = [1,2,3]
        Output: [1,2,4]
        Explanation: The array represents the integer 123.
    Example 2:
        Input: digits = [4,3,2,1]
        Output: [4,3,2,2]
        Explanation: The array represents the integer 4321.
    Example 3:
        Input: digits = [0]
        Output: [1]
    Constraints:
        1 <= digits.length <= 100
        0 <= digits[i] <= 9

 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int lastId = digits.length - 1;
        if (digits[lastId] < 9) {
            digits[lastId] = digits[lastId] + 1;
            return digits;
        }
        if (isAllNines(digits)) {
            int[] result = new int[digits.length + 1];
            int rest = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int val = digits[i] + rest;
                if (val == 10) {
                    result[i + 1] = 0;
                    rest = 1;
                } else {
                    result[i + 1] = val;
                    rest = 0;
                }
            }
            if (rest == 1) {
                result[0] = 1;
            }
            return result;
        } else {
            int rest = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                int val = digits[i] + rest;
                if (val == 10) {
                    digits[i] = 0;
                    rest = 1;
                } else {
                    digits[i] = val;
                    rest = 0;
                }
            }
            return digits;
        }

    }

    private boolean isAllNines(int[] digits) {
        if (digits.length == 0) {
            return false;
        }
        for (int num : digits) {
            if (num != 9) {
                return false;
            }
        }
        return true;
    }
}
