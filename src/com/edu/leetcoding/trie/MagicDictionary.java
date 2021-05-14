package com.edu.leetcoding.trie;

/**
 *  676. Implement Magic Dictionary
 *
 *  Design a data structure that is initialized with a list of different words.
 *  Provided a string, you should determine if you can change exactly one character in this string to
 *  match any word in the data structure.
 *
 *  Implement the MagicDictionary class:
 *  MagicDictionary() Initializes the object.
 *  void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
 *  bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match
 *  any string in the data structure, otherwise returns false.
 *
 *  Example 1:
 *      Input
 *      ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 *      [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 *      Output
 *      [null, null, false, true, false, false]
 *  Explanation
 *      MagicDictionary magicDictionary = new MagicDictionary();
 *      magicDictionary.buildDict(["hello", "leetcode"]);
 *      magicDictionary.search("hello"); // return False
 *      magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
 *      magicDictionary.search("hell"); // return False
 *      magicDictionary.search("leetcoded"); // return False
 *  Constraints:
 *      1 <= dictionary.length <= 100
 *      1 <= dictionary[i].length <= 100
 *      dictionary[i] consists of only lower-case English letters.
 *      All the strings in dictionary are distinct.
 *      1 <= searchWord.length <= 100
 *      searchWord consists of only lower-case English letters.
 *      buildDict will be called only once before search.
 *      At most 100 calls will be made to search.
 *
 * */
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
