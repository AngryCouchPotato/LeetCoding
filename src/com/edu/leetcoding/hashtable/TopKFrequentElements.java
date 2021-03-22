package com.edu.leetcoding.hashtable;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *  347. Top K Frequent Elements
 *
 *  Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 *  Example 1:
 *      Input: nums = [1,1,1,2,2,3], k = 2
 *      Output: [1,2]
 *  Example 2:
 *      Input: nums = [1], k = 1
 *      Output: [1]
 *
 *  Constraints:
 *      1 <= nums.legth <= 105
 *      k is in the range [1, the number of unique elements in the array].
 *      It is guaranteed that the answer is unique.
 *
 *  Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 *
 * */
public class TopKFrequentElements {

    /**
     *  O(n*log(n)) - time | O(n + n) - space, hashmap with n elements + heap with n elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Comparator<Map.Entry<Integer, Integer>> entryComparator = (entryOne, entryTwo) -> entryTwo.getValue() - entryOne.getValue();

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue(entryComparator);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry);
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll().getKey();
        }
        return res;
    }
}
