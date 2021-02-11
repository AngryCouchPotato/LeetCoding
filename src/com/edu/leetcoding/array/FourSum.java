package com.edu.leetcoding.array;

import java.util.*;

import static java.util.Collections.EMPTY_LIST;

/*
    18. 4Sum

    Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
    Notice that the solution set must not contain duplicate quadruplets.

    Example 1:
        Input: nums = [1,0,-1,0,-2,2], target = 0
        Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
    Example 2:
        Input: nums = [], target = 0
        Output: []
    Constraints:
        0 <= nums.length <= 200
        -109 <= nums[i] <= 109
        -109 <= target <= 109

 */
public class FourSum {

    // O(n^3) time : O(n) space
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return EMPTY_LIST;
        }
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int left = 0; left < nums.length - 3; left++) {
            for (int midLeft = left + 1; midLeft < nums.length - 2; midLeft++) {
                int sumWithoutLeft = target - nums[midLeft] - nums[left];
                int midRight = midLeft + 1;
                int right = nums.length - 1;
                while (midRight < right) {
                    if (sumWithoutLeft - nums[midRight] - nums[right] < 0) {
                        right--;
                    } else if (sumWithoutLeft - nums[midRight] - nums[right] > 0) {
                        midRight++;
                    } else {
                        result.add(List.of(nums[left], nums[midLeft], nums[midRight], nums[right]));
                        right--;
                        midRight++;
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
