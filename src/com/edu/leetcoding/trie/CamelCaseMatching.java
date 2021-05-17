package com.edu.leetcoding.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *  1023. Camelcase Matching
 *
 *  A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the
 *  query. (We may insert each character at any position, and may insert 0 characters.)
 *
 *  Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only
 *  if queries[i] matches the pattern.
 *
 *  Example 1:
 *      Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 *      Output: [true,false,true,true,false]
 *      Explanation:
 *      "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
 *      "FootBall" can be generated like this "F" + "oot" + "B" + "all".
 *      "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
 *  Example 2:
 *      Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 *      Output: [true,false,true,false,false]
 *      Explanation:
 *      "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
 *      "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
 *  Example 3:
 *      Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 *      Output: [false,true,false,false,false]
 *      Explanation:
 *      "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 *  Note:
 *      1 <= queries.length <= 100
 *      1 <= queries[i].length <= 100
 *      1 <= pattern.length <= 100
 *      All strings consists only of lower and upper case English letters.
 *
 * */
public class CamelCaseMatching {

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        Trie trie = new Trie();
        trie.insert(pattern);
        List<Boolean> result = new ArrayList<>(queries.length);
        for(String query:queries) {
            result.add(trie.search(query));
        }
        return result;
    }

    class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            TrieNode current = root;
            for(char ch : word.toCharArray()) {
                if(!current.children.containsKey(ch)) {
                    current.children.put(ch, new TrieNode());
                }
                current = current.children.get(ch);
            }
            current.isEnd = true;
        }

        public boolean search(String word) {
            if (word == null) {
                return false;
            }
            TrieNode current = root;
            for(char ch : word.toCharArray()) {
                if(!current.children.containsKey(ch) && Character.isUpperCase(ch)) {
                    return false;
                }
                if(current.children.containsKey(ch)) {
                    current = current.children.get(ch);
                }
            }
            return current.isEnd;
        }

        private class TrieNode {
            private boolean isEnd;
            private final Map<Character, TrieNode> children = new HashMap<>();
        }
    }
}
