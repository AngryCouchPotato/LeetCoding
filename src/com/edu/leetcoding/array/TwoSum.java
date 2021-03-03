package com.edu.leetcoding.array;

import java.util.HashMap;
import java.util.Map;

/**
    1. Two Sum

    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.

    Example 1:
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Output: Because nums[0] + nums[1] == 9, we return [0, 1].
    Example 2:
        Input: nums = [3,2,4], target = 6
        Output: [1,2]
    Example 3:
        Input: nums = [3,3], target = 6
        Output: [0,1]
    Constraints:
        2 <= nums.length <= 10^3
        -10^9 <= nums[i] <= 10^9
        -10^9 <= target <= 10^9
        Only one valid answer exists.

    */
public class TwoSum {

    /**
     *  O(n) time : O(n) space
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (cache.containsKey(diff)) {
                return new int[]{i, cache.get(diff)};
            } else {
                cache.put(nums[i], i);
            }
        }
        return null;
    }
}
