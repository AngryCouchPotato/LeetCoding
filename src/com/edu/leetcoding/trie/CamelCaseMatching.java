package com.edu.leetcoding.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
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
