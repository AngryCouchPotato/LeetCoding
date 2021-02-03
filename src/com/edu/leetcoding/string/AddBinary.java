package com.edu.leetcoding.string;

import java.util.Stack;

/*
    67. Add Binary

    Given two binary strings a and b, return their sum as a binary string.

    Example 1:
        Input: a = "11", b = "1"
        Output: "100"
    Example 2:
        Input: a = "1010", b = "1011"
        Output: "10101"
    Constraints:
        1 <= a.length, b.length <= 104
        a and b consist only of '0' or '1' characters.
        Each string does not contain leading zeros except for the zero itself.

 */
public class AddBinary {

    // O(n) time | O(n) space
    public String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        Stack<Character> stack = new Stack<>();
        char carry = '0';
        for (int i = 1; i <= length; i++) {
            char chA = '0';
            if (i <= a.length()) {
                chA = a.charAt(a.length() - i);
            }
            char chB = '0';
            if (i <= b.length()) {
                chB = b.charAt(b.length() - i);
            }
            if (chA == '0' && chB == '0') {
                if (carry == '1') {
                    stack.push('1');
                    carry = '0';
                } else {
                    stack.push('0');
                }
            } else if (chA == '1' && chB == '1') {
                if (carry == '1') {
                    stack.push('1');
                } else {
                    stack.push('0');
                }
                carry = '1';
            } else {
                if (carry == '1') {
                    stack.push('0');
                    carry = '1';
                } else {
                    stack.push('1');
                }
            }
        }
        if (carry == '1') {
            stack.push('1');
        }
        char[] result = new char[stack.size()];
        int id = 0;
        while (!stack.isEmpty()) {
            result[id++] = stack.pop();
        }
        return new String(result);
    }
}
