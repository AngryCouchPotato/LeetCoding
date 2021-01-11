package com.edu.leetcoding.string;

/*
    1662. Check If Two String Arrays are Equivalent

    Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
    A string is represented by an array if the array elements concatenated in order forms the string.

        Example 1:

        Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
        Output: true
        Explanation:
        word1 represents string "ab" + "c" -> "abc"
        word2 represents string "a" + "bc" -> "abc"
        The strings are the same, so return true.
        Example 2:

        Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
        Output: false
        Example 3:

        Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
        Output: true

        */
public class ArrayStringsAreEqual {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return createString(word1).equals(createString(word2));
    }

    private String createString(String[] arr){
        StringBuilder sb = new StringBuilder();
        for(String str : arr){
            sb.append(str);
        }
        return sb.toString();
    }
}
