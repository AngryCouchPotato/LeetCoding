package com.edu.leetcoding.string;

/**
 *  58. Length of Last Word
 *
 *  Given a string s consists of some words separated by spaces, return the length of the last word in the string.
 *  If the last word does not exist, return 0.
 *
 *  A word is a maximal substring consisting of non-space characters only.
 *
 *  Example 1:
 *      Input: s = "Hello World"
 *      Output: 5
 *  Example 2:
 *      Input: s = " "
 *      Output: 0
 *  Constraints:
 *      1 <= s.length <= 104
 *      s consists of only English letters and spaces ' '.
 *
 * */
public class LengthOfLastWord {

    /**
     *  O(n) - time complexity | O(n) - space complexity
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        int pointer = s.length() - 1;
        while (pointer >= 0 && s.charAt(pointer) == ' ') {
            pointer--;
        }

        int length = 0;
        while (pointer >= 0 && s.charAt(pointer) != ' ') {
            pointer--;
            length++;
        }
        return length;
    }
}
