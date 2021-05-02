package com.edu.leetcoding.heap;

import java.util.PriorityQueue;

/**
 *  215. Kth Largest Element in an Array
 *
 *  Given an integer array nums and an integer k, return the kth largest element in the array.
 *  Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 *  Example 1:
 *      Input: nums = [3,2,1,5,6,4], k = 2
 *      Output: 5
 *  Example 2:
 *      Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 *      Output: 4
 *  Constraints:
 *      1 <= k <= nums.length <= 104
 *      -104 <= nums[i] <= 104
 *
 * */
public class KthLargestElementInAnArray {

    /**
     *  O(N * log(k)) - time | O(k) - size of the heap
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num:nums) {
            queue.add(num);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
