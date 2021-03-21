package com.edu.leetcoding.stack;

import java.util.Stack;

/**
 *  394. Decode String
 *
 *  Given an encoded string, return its decoded string.
 *
 *  The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 *  exactly k times. Note that k is guaranteed to be a positive integer.
 *
 *  You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 *  Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 *  repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 *  Example 1:
 *      Input: s = "3[a]2[bc]"
 *      Output: "aaabcbc"
 *  Example 2:
 *      Input: s = "3[a2[c]]"
 *      Output: "accaccacc"
 *  Example 3:
 *      Input: s = "2[abc]3[cd]ef"
 *      Output: "abcabccdcdcdef"
 *  Example 4:
 *      Input: s = "abc3[cd]xyz"
 *      Output: "abccdcdcdxyz"
 *
 *  Constraints:
 *      1 <= s.length <= 30
 *      s consists of lowercase English letters, digits, and square brackets '[]'.
 *      s is guaranteed to be a valid input.
 *      All the integers in s are in the range [1, 300].
 *
 * */
public class DecodeString {

    public String decodeString(String s) {
        Stack<Integer> digitStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currentDigit = new StringBuilder();
        StringBuilder currentString = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(Character.isDigit(current)) {
                currentDigit.append(current);
            } else if (Character.isLetter(current)) {
                currentString.append(current);
            } else if (current == '[') {
                int num = Integer.parseInt(currentDigit.toString());
                digitStack.push(num);
                currentDigit.delete(0, currentDigit.length());
                stringStack.push(currentString);
                currentString = new StringBuilder();
            } else if (current == ']') {
                StringBuilder decodedString = stringStack.pop();
                for(int currentNum = digitStack.pop(); currentNum > 0; currentNum--) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
            } else {
                throw new RuntimeException(String.format("Current symbol %s is invalid", current));
            }
        }
        return currentString.toString();
    }

    public String decodeStringOneStack(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == ']'){
                StringBuilder sb = new StringBuilder();
                while(stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();// pop [
                int base = 1;
                int num = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    num = num + (stack.pop() - '0') * base; // pop all digits
                    base *= 10;
                }
                String str = sb.toString();
                while(num-- > 1) {
                    sb.append(str);
                }
                str = sb.toString();
                for(int j = str.length() - 1; j >= 0; j--) {
                    stack.push(str.charAt(j));
                }
            } else {
                stack.push(current);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
