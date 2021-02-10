package com.edu.leetcoding.array;

import java.util.*;

/*
    15. 3Sum

    Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
    Notice that the solution set must not contain duplicate triplets.

    Example 1:
        Input: nums = [-1,0,1,2,-1,-4]
        Output: [[-1,-1,2],[-1,0,1]]
    Example 2:
        Input: nums = []
        Output: []
    Example 3:
        Input: nums = [0]
        Output: []
    Constraints:
        0 <= nums.length <= 3000
        -105 <= nums[i] <= 105

 */
public class ThreeSum {

    // O(n^2) time : O(1) space
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int left = 0; left < nums.length - 2; left++) {
            int mid = left + 1;
            int right = nums.length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    mid++;
                } else {
                    result.add(List.of(nums[left], nums[mid], nums[right]));
                    mid++;
                    right--;
                }
            }
        }
        return new ArrayList<>(result);
    }
}
