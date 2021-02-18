package com.edu.leetcoding.string;

import java.util.HashSet;
import java.util.Set;

/**
 *  3. Longest Substring Without Repeating Characters
 *
 *  Given a string s, find the length of the longest substring without repeating characters.
 *      Example 1:
 *          Input: s = "abcabcbb"
 *          Output: 3
 *          Explanation: The answer is "abc", with the length of 3.
 *      Example 2:
 *          Input: s = "bbbbb"
 *          Output: 1
 *          Explanation: The answer is "b", with the length of 1.
 *      Example 3:
 *          Input: s = "pwwkew"
 *          Output: 3
 *          Explanation: The answer is "wke", with the length of 3.
 *          Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *      Example 4:
 *          Input: s = ""
 *          Output: 0
 *      Constraints:
 *          0 <= s.length <= 5 * 104
 *          s consists of English letters, digits, symbols and spaces.
 *
 * */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * O(n) - time | O(min(n, m) - space, where n - length of the string and m - number chars in alphabet.
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = Integer.MIN_VALUE;
        Set<Character> cache = new HashSet<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (cache.contains(s.charAt(right))) {
                while (s.charAt(left) != s.charAt(right)) {
                    cache.remove(s.charAt(left));
                    left++;
                }
                left++;
                right++;
            } else {
                cache.add(s.charAt(right));
                right++;
                maxLength = Math.max(maxLength, right - left);
            }
        }
        return maxLength;
    }

    /**
     * O(n^2) - time | O(min(n, m) - space, where n - length of the string and m - number chars in alphabet.
     */
    public int lengthOfLongestSubstringBruteForce(String s) {
        Set<Character> symbols = new HashSet<>();
        int maxlength = 0;

        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (symbols.contains(s.charAt(j))) {
                    break;
                } else {
                    counter++;
                    symbols.add(s.charAt(j));
                }
            }
            maxlength = Math.max(maxlength, counter);
            symbols.clear();
            counter = 0;
        }
        return maxlength;
    }
}
