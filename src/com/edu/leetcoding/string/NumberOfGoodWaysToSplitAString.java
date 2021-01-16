package com.edu.leetcoding.string;

import java.util.HashSet;
import java.util.Set;


/*
    1525. Number of Good Ways to Split a String

    You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q where
    its concatenation is equal to s and the number of distinct letters in p and q are the same.

    Return the number of good splits you can make in s.

    Example 1:
        Input: s = "aacaba"
        Output: 2
        Explanation: There are 5 ways to split "aacaba" and 2 of them are good.
        ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
        ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
        ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
        ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
        ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
    Example 2:
        Input: s = "abcd"
        Output: 1
        Explanation: Split the string as follows ("ab", "cd").
    Example 3:
        Input: s = "aaaaa"
        Output: 4
        Explanation: All possible splits are good.
    Example 4:
        Input: s = "acbadbaada"
        Output: 2

    Constraints:
        s contains only lowercase English letters.
        1 <= s.length <= 10^5

    */
public class NumberOfGoodWaysToSplitAString {

    // O(n) time : O(n) space, where n - length of string
    public int numSplits(String s) {
        int[] prefix = new int[s.length()];
        int[] suffix = new int[s.length()];
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            prefix[i] = set.size();
        }
        set.clear();
        for(int i = s.length() - 1; i >= 0 ; i--) {
            set.add(s.charAt(i));
            suffix[i] = set.size();
        }
        int countWays = 0;
        for(int i = 1; i < s.length(); i++) {
            if(prefix[i - 1] == suffix[i]) {
                countWays++;
            }
        }
        return countWays;
    }
}
