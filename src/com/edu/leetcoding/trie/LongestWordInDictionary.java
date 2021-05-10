package com.edu.leetcoding.trie;

import java.util.Arrays;

/**
 *  720. Longest Word in Dictionary
 *
 *  Given an array of strings words representing an English Dictionary, return the longest word in words that can
 *  be built one character at a time by other words in words.
 *
 *  If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 *  If there is no answer, return the empty string.
 *
 *  Example 1:
 *    Input: words = ["w","wo","wor","worl","world"]
 *    Output: "world"
 *    Explanation: The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 *  Example 2:
 *    Input: words = ["a","banana","app","appl","ap","apply","apple"]
 *    Output: "apple"
 *  Explanation: Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is
 *  lexicographically smaller than "apply".
 *
 *  Constraints:
 *    1 <= words.length <= 1000
 *    1 <= words[i].length <= 30
 *    words[i] consists of lowercase English letters.
 *
 * */
public class LongestWordInDictionary {

    public String longestWord(String[] words) {
        Arrays.sort(words);

        Trie trie = new Trie();
        int maxLength = 0;// 2
        String result = null;// wo
        for(String word:words) {
            trie.insert(word);
            int length = trie.getBranchLength();// 2
            if(length > maxLength) {
                maxLength = length;
                result = word;
            }
        }
        return result;

    }

    class Trie {
        public TrieNode root;
        private int count = 0;// 2

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if(word == null) {
                return;
            }
            TrieNode current = root;
            count = 0;
            int num = 0;
            for(char ch:word.toCharArray()) {
                int id = ch - 'a';
                if(current.children[id] == null) {
                    if(word.length() - num > 1) {
                        count = 0;
                        return;
                    }
                    current.children[id] = new TrieNode();
                    count++;
                } else {
                    num++;
                    count++;
                }
                current = current.children[id];
            }
            current.isEnd = true;
        }

        public int getBranchLength() {
            return count;
        }
    }

    class TrieNode {
        private static final int SIZE = 26;
        public TrieNode[] children = new TrieNode[SIZE];
        public boolean isEnd;
    }
}
