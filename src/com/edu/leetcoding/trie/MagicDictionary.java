package com.edu.leetcoding.trie;

class MagicDictionary {

    private Trie trie;

    public MagicDictionary() {
        trie = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for(String word : dictionary) {
            trie.insert(word);
        }
    }

    public boolean search(String searchWord) {
        return trie.search(searchWord);
    }

    class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode('a');
        }

        public void insert(String word) {
            if(word == null) {
                return;
            }
            TrieNode current = root;
            for(char ch:word.toCharArray()) {
                if(!current.contains(ch)) {
                    current.put(ch);
                }
                current = current.get(ch);
            }
            current.setIsEnd(true);
        }

        public boolean search(String word) {
            if(word == null) {
                return false;
            }
            return search(word, root, 0, 0);
        }

        private boolean search(String word, TrieNode current, int startIndex, int count) {
            if(count > 1) {
                return false;
            }
            if(startIndex >= word.length()) {
                return current.isEnd() && count == 1;
            }
            for(TrieNode node:current.getChildren()) {
                if(node == null) {
                    continue;
                }
                if(search(word, node, startIndex + 1, node.getChar() == word.charAt(startIndex) ? count : count + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    class TrieNode {
        private final static int SIZE = 26;
        private TrieNode[] children = new TrieNode[SIZE];
        private char value;
        private boolean isEnd;

        TrieNode(char value) {
            this.value = value;
        }

        public boolean contains(char ch) {
            int id = ch - 'a';
            return children[id] != null;
        }

        public TrieNode get(char ch) {
            int id = ch - 'a';
            return children[id];
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public void put(char ch) {
            int id = ch - 'a';
            children[id] = new TrieNode(ch);
        }

        public void setIsEnd(boolean value) {
            isEnd = value;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public char getChar() {
            return value;
        }
    }

}
