package com.edu.leetcoding.string;

/*
    344. Reverse String

    Write a function that reverses a string. The input string is given as an array of characters char[].
    Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
    You may assume all the characters consist of printable ascii characters.

    Example 1:
        Input: ["h","e","l","l","o"]
        Output: ["o","l","l","e","h"]
    Example 2:
        Input: ["H","a","n","n","a","h"]
        Output: ["h","a","n","n","a","H"]

    */
public class ReverseString {

    // O(n) time : O(n) space, where n - length of the string
    public void reverseStringRecursive(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        reverseStringRecursive(s, 0, s.length - 1);
    }

    public void reverseStringRecursive(char[] s, int l, int r) {
        if (l >= r) {
            return;
        }
        char temp = s[l];
        s[l++] = s[r];
        s[r--] = temp;
        reverseStringRecursive(s, l, r);
    }

    // O(n) time : O(1) space, where n - length of the string
    public void reverseStringIterative(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        }
        int l = 0;
        int r = s.length - 1;
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
