package com.edu.leetcoding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
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
        -10^5 <= nums[i] <= 10^5

 */
public class ThreeSum {

    /**
     *  O(n^2) time : O(n) space
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return Collections.EMPTY_LIST;
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int left = 0; left < nums.length - 2; left++) {
            if (left - 1 >= 0 && nums[left] == nums[left - 1]) {
                continue;
            }
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
                    while (mid + 1 < right && nums[mid] == nums[mid + 1]) {
                        mid++;
                    }
                    while (right - 1 > mid && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    mid++;
                    right--;
                }
            }
        }
        return result;
    }
}
