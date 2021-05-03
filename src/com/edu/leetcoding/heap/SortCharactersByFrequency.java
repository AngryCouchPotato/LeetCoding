package com.edu.leetcoding.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *  451. Sort Characters By Frequency
 *
 *  Given a string s, sort it in decreasing order based on the frequency of characters, and return the sorted string.
 *
 *  Example 1:
 *      Input: s = "tree"
 *      Output: "eert"
 *      Explanation: 'e' appears twice while 'r' and 't' both appear once.
 *      So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *  Example 2:
 *      Input: s = "cccaaa"
 *      Output: "aaaccc"
 *      Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 *      Note that "cacaca" is incorrect, as the same characters must be together.
 *  Example 3:
 *      Input: s = "Aabb"
 *      Output: "bbAa"
 *      Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
 *
 *  Note that 'A' and 'a' are treated as two different characters.
 *
 *  Constraints:
 *      1 <= s.length <= 5 * 105
 *      s consists of English letters and digits.
 *
 * */
public class SortCharactersByFrequency {

    /**
     *  O(n) - time | O(k * log(k)) - space, where k is count of characters
     */
    public String frequencySort(String s) {
        if (s.length() == 1) {
            return s;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        Comparator<Map.Entry<Character, Integer>> comparator = new Comparator<Map.Entry<Character, Integer>>() {
            public int compare(Map.Entry<Character, Integer> entryOne, Map.Entry<Character, Integer> entryTwo) {
                return entryTwo.getValue() - entryOne.getValue();
            }
        };

        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>(comparator);
        queue.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        Map.Entry<Character, Integer> entry = null;
        while (!queue.isEmpty()) {
            entry = queue.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}
