package com.edu.leetcoding.heap;

import java.util.*;

/**
 *  692. Top K Frequent Words
 *
 *  Given a non-empty list of words, return the k most frequent elements.
 *
 *  Your answer should be sorted by frequency from highest to lowest.
 *  If two words have the same frequency, then the word with the lower alphabetical order comes first.
 *
 *  Example 1:
 *      Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 *      Output: ["i", "love"]
 *      Explanation: "i" and "love" are the two most frequent words.
 *          Note that "i" comes before "love" due to a lower alphabetical order.
 *  Example 2:
 *      Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 *      Output: ["the", "is", "sunny", "day"]
 *      Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 *          with the number of occurrence being 4, 3, 2 and 1 respectively.
 *  Note:
 *      You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 *      Input words contain only lowercase letters.
 *      Follow up:
 *      Try to solve it in O(n log k) time and O(n) extra space.
 *
 * */
public class TopKFrequentWords {

    /**
     *  O(N * log(k)) - time | O(N) - size of the map
     */
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Comparator<Map.Entry<String, Integer>> comparator = new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> entryOne, Map.Entry<String, Integer> entryTwo) {
                if(entryOne.getValue() == entryTwo.getValue()) {
                    int res = entryTwo.getKey().compareTo(entryOne.getKey());
                    return res;
                }
                return entryOne.getValue() - entryTwo.getValue();
            }
        };

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(comparator);
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(queue.size() == k) {
                if(comparator.compare(queue.peek(), entry) < 0) {
                    queue.poll();
                    queue.add(entry);
                }
            } else {
                queue.add(entry);
            }
        }
        List<String> result = new ArrayList<>(k);
        int i = 0;
        while(!queue.isEmpty() && i < k) {
            result.add(queue.poll().getKey());
            i++;
        }
        Collections.reverse(result);
        return result;
    }
}
