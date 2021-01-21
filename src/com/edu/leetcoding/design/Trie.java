package com.edu.leetcoding.design;

/*
    208. Implement Trie (Prefix Tree)

    Implement a trie with insert, search, and startsWith methods.

    Example:
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // returns true
        trie.search("app");     // returns false
        trie.startsWith("app"); // returns true
        trie.insert("app");
        trie.search("app");     // returns true
    Note:
        You may assume that all inputs are consist of lowercase letters a-z.
        All inputs are guaranteed to be non-empty strings.

 */
public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int id = ch - 'a';
            if (current.children[id] == null) {
                current.children[id] = new TrieNode();
            }
            current = current.children[id];
        }
        current.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int id = ch - 'a';
            if (current.children[id] == null) {
                return false;
            }
            current = current.children[id];
        }
        return current.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            int id = ch - 'a';
            if (current.children[id] == null) {
                return false;
            }
            current = current.children[id];
        }
        return true;
    }

    private class TrieNode {
        private static final int SIZE = 26;
        private boolean isEnd;
        private final TrieNode[] children = new TrieNode[SIZE];
    }
}
