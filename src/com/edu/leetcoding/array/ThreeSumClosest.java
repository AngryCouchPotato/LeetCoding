package com.edu.leetcoding.array;

import java.util.Arrays;

/**
 *  16. 3Sum Closest
 *
 *  Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest
 *  to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *  Example 1:
 *
 *      Input: nums = [-1,2,1,-4], target = 1
 *      Output: 2
 *      Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *  Constraints:
 *
 *      3 <= nums.length <= 10^3
 *      -10^3 <= nums[i] <= 10^3
 *      -10^4 <= target <= 10^4
 *
 * */
public class ThreeSumClosest {

    /**
     *  O(n^2) time | O(log n) to O(n) space, depending on implementation of sorting algorithm
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int result = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int left = 0; left < length - 1; left++) {
            int mid = left + 1;
            int right = length - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                int diff = Math.abs(target - sum);
                if (minDiff > diff) {
                    minDiff = diff;
                    result = sum;
                }
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    mid++;
                } else {
                    return result;
                }
            }
        }
        return result;
    }
}
