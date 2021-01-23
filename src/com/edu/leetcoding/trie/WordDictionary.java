package com.edu.leetcoding.trie;


/*
    211. Design Add and Search Words Data Structure

    Design a data structure that supports adding new words and finding if a string matches any previously added string.
    Implement the WordDictionary class:
        WordDictionary() Initializes the object.
        void addWord(word) Adds word to the data structure, it can be matched later.
        bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
            word may contain dots '.' where dots can be matched with any letter.


    Example:
        Input
        ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
        [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        Output
        [null,null,null,null,false,true,true,true]

    Explanation
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True

    Constraints:
        1 <= word.length <= 500
        word in addWord consists lower-case English letters.
        word in search consist of  '.' or lower-case English letters.
        At most 50000 calls will be made to addWord and search.

 */
class WordDictionary {

    private Trie trie;

    public WordDictionary() {
        this.trie = new Trie();
    }

    public void addWord(String word) {
        this.trie.insert(word);
    }

    public boolean search(String word) {
        return this.trie.searchMask(word);
    }

    static class Trie {
        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (!current.contains(ch)) {
                    current.set(ch, new TrieNode());
                }
                current = current.get(ch);
            }
            current.setIsEnd(true);
        }

        public boolean searchMask(String mask) {
            if (mask == null) {
                return false;
            }
            return searchMask(mask, root, 0);
        }

        private boolean searchMask(String mask, TrieNode node, int index) {
            if (mask == null) {
                return false;
            }
            for (int i = index; i < mask.length(); i++) {
                char ch = mask.charAt(i);
                if (ch == '.') {
                    boolean res = false;
                    for (int j = 0; j < 26; j++) {
                        if (node.getByIndex(j) != null) {
                            res = searchMask(mask, node.getByIndex(j), i + 1);
                            if (res) {
                                return res;
                            }
                        }
                    }
                    return res;
                } else if (node.contains(ch)) {
                    node = node.get(ch);
                } else {
                    return false;
                }
            }
            return node.isEnd();
        }
    }

    static class TrieNode {
        private static final int SIZE = 26;
        private final TrieNode[] children;
        private boolean isEnd;

        TrieNode() {
            this(false);
        }

        TrieNode(boolean isEnd) {
            this.children = new TrieNode[SIZE];
            this.isEnd = isEnd;
        }

        public boolean contains(char ch) {
            return children[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
        }

        public TrieNode getByIndex(int id) {
            return children[id];
        }

        public void set(char ch, TrieNode node) {
            children[ch - 'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setIsEnd(boolean isEnd) {
            this.isEnd = isEnd;
        }
    }
}
