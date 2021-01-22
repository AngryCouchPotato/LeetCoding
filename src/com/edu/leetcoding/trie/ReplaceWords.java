package com.edu.leetcoding.trie;

import java.util.List;

/*
    648. Replace Words

    In English, we have a concept called root, which can be followed by some other word to form another longer word - let's call this word successor.
    For example, when the root "an" is followed by the successor word "other", we can form a new word "another".
    Given a dictionary consisting of many roots and a sentence consisting of words separated by spaces, replace all the successors in
    the sentence with the root forming it. If a successor can be replaced by more than one root, replace it with the root that has the shortest length.
    Return the sentence after the replacement.

    Example 1:
        Input: dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
        Output: "the cat was rat by the bat"
    Example 2:
        Input: dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
        Output: "a a b c"
    Example 3:
        Input: dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
        Output: "a a a a a a a a bbb baba a"
    Example 4:
        Input: dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
        Output: "the cat was rat by the bat"
    Example 5:
        Input: dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
        Output: "it is ab that this solution is ac"
    Constraints:
        1 <= dictionary.length <= 1000
        1 <= dictionary[i].length <= 100
        dictionary[i] consists of only lower-case letters.
        1 <= sentence.length <= 10^6
        sentence consists of only lower-case letters and spaces.
        The number of words in sentence is in the range [1, 1000]
        The length of each word in sentence is in the range [1, 1000]
        Each two consecutive words in sentence will be separated by exactly one space.
        sentence does not have leading or trailing spaces.

 */
public class ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word : dictionary) {
            trie.insert(word);
        }

        String[] splitted = sentence.split(" ");

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < splitted.length; i++) {
            String word = splitted[i];
            String prefix = trie.searchShortestPrefix(word);
            if (prefix == null) {
                res.append(word);
            } else {
                res.append(prefix);
            }
            if (i < (splitted.length - 1)) {
                res.append(" ");
            }
        }
        return res.toString();
    }

    static class Trie {
        private final TrieNode root = new TrieNode();

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

        public String searchShortestPrefix(String word) {
            if (word == null) {
                return null;
            }
            TrieNode current = root;
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                if (current.isEnd()) {
                    return sb.toString();
                } else if (current.contains(ch)) {
                    sb.append(ch);
                    current = current.get(ch);
                } else {
                    return null;
                }
            }
            return null;
        }
    }

    static class TrieNode {
        private static final int SIZE = 26;
        private final TrieNode[] children = new TrieNode[SIZE];
        private boolean isEnd;

        public boolean contains(char ch) {
            return children[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return children[ch - 'a'];
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
