package com.edu.leetcoding.trie;

import java.util.HashMap;
import java.util.Map;

/*
    677. Map Sum Pairs

    Implement the MapSum class:
        MapSum() Initializes the MapSum object.
        void insert(String key, int val) Inserts the key-val pair into the map. If the key already existed, the original key-value pair will be overridden to the new one.
        int sum(string prefix) Returns the sum of all the pairs' value whose key starts with the prefix.

    Example 1:
        Input
            ["MapSum", "insert", "sum", "insert", "sum"]
            [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
            Output
            [null, null, 3, null, 5]

        Explanation
            MapSum mapSum = new MapSum();
            mapSum.insert("apple", 3);
            mapSum.sum("ap");           // return 3 (apple = 3)
            mapSum.insert("app", 2);
            mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)


    Constraints:

        1 <= key.length, prefix.length <= 50
        key and prefix consist of only lowercase English letters.
        1 <= val <= 1000
        At most 50 calls will be made to insert and sum.

    */
public class MapSum {
    private TrieNode root;
    private Map<String, Integer> cache;

    public MapSum() {
        root = new TrieNode();
        cache = new HashMap<>();
    }

    public void insert(String key, int val) {
        if (key == null) {
            return;
        }
        int value = 0;
        if(cache.containsKey(key)) {
            value = val - cache.get(key);
        } else {
            value = val;
        }
        cache.put(key, val);
        TrieNode current = root;
        for (char ch : key.toCharArray()) {
            if (current.contains(ch)) {
                current = current.get(ch);
                current.setValue(current.getValue() + value);
            } else {
                current.setNode(ch, new TrieNode());
                current = current.get(ch);
                current.setValue(value);
            }
        }
    }

    public int sum(String prefix) {
        TrieNode current = root;
        int sum = 0;
        for (char ch : prefix.toCharArray()) {
            if (current.contains(ch)) {
                sum = current.get(ch).getValue();
                current = current.get(ch);
            } else {
                sum = 0;
                break;
            }
        }
        return sum;
    }

    class TrieNode {
        private static final int SIZE = 26;
        private TrieNode[] children = new TrieNode[SIZE];
        private int value;

        public boolean contains(char ch) {
            return children[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public void setNode(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
