package com.edu.leetcoding.string;

import java.util.Stack;

/*
    43. Multiply Strings

    Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

    Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

    Example 1:
        Input: num1 = "2", num2 = "3"
        Output: "6"
    Example 2:
        Input: num1 = "123", num2 = "456"
        Output: "56088"
    Constraints:
        1 <= num1.length, num2.length <= 200
        num1 and num2 consist of digits only.
        Both num1 and num2 do not contain any leading zero, except the number 0 itself.

 */
public class MultiplyStrings {

    public String multiply(String str1, String str2) {
        if(str1.equals("0") || str2.equals("0")) {
            return "0";
        }
        String result = "";
        StringBuilder subResult = new StringBuilder();
        for(int it2 = str2.length() - 1; it2 >= 0; it2--) {
            String carry = "";
            for(int it1 = str1.length() - 1; it1 >= 0; it1--) {
                int num1 = str1.charAt(it1) - '0';
                int num2 = str2.charAt(it2) - '0';
                subResult.delete(0,  subResult.length());
                subResult.append(num1 * num2);
                for(int i = 0; i < str1.length() - 1 - it1; i++) {
                    subResult.append('0');
                }
                carry = add(carry, subResult.toString());
            }
            subResult.delete(0,  subResult.length());
            subResult.append(carry);
            for(int j = 0; j < str2.length() - 1 - it2; j++) {
                subResult.append('0');
            }
            result = add(result, subResult.toString());
        }
        return result;
    }

    private String add(String str1, String str2) {
        Stack<Integer> stack = new Stack<>();
        int str1P = str1.length() - 1;
        int str2P = str2.length() - 1;
        int carry = 0;
        int num1;
        int num2;
        int subResult = 0;
        while(str1P >= 0 || str2P >= 0) {
            num1 = 0;
            num2 = 0;
            if(str1P >= 0) {
                num1 = str1.charAt(str1P) - '0';
                str1P--;
            }
            if(str2P >= 0) {
                num2 = str2.charAt(str2P) - '0';
                str2P--;
            }
            subResult = carry + num1 + num2;
            stack.push(subResult % 10);
            carry = subResult / 10;
        }
        if(carry > 0) {
            stack.push(carry);
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
}
