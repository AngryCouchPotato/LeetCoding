package com.edu.leetcoding.string;

/*
    415. Add Strings
    Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

    Note:

        The length of both num1 and num2 is < 5100.
        Both num1 and num2 contains only digits 0-9.
        Both num1 and num2 does not contain any leading zero.
        You must not use any built-in BigInteger library or convert the inputs to integer directly.

*/
public class AddStrings {

    // O(n + m) time : O(n + m) space
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int temp = 0;
        while(i1 >= 0 || i2 >= 0 || temp > 0) {
            if(i1 >= 0) {
                temp = temp + (num1.charAt(i1--) - '0');
            }
            if(i2 >= 0) {
                temp = temp + (num2.charAt(i2--) - '0');
            }
            sb.append(temp % 10);
            temp = temp / 10;
        }
        return sb.reverse().toString();
    }
}
