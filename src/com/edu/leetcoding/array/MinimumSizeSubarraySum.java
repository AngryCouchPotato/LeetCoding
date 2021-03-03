package com.edu.leetcoding.array;

/**
 *  209. Minimum Size Subarray Sum
 *
 *  Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous
 *  subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
 *  If there is no such subarray, return 0 instead.
 *
 *  Example 1:
 *      Input: target = 7, nums = [2,3,1,2,4,3]
 *      Output: 2
 *      Explanation: The subarray [4,3] has the minimal length under the problem constraint.
 *  Example 2:
 *      Input: target = 4, nums = [1,4,4]
 *      Output: 1
 *  Example 3:
 *      Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 *      Output: 0
 *  Constraints:
 *      1 <= target <= 10^9
 *      1 <= nums.length <= 10^5
 *      1 <= nums[i] <= 10^5
 *
 *  Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 *
 * */
public class MinimumSizeSubarraySum {

    /**
     * O(n) time | O(1) space
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right + 1 - left);
                sum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    /**
     * O(n^2) time | O(1) space
     */
    public int minSubArrayLenBruteForce(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int counter = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                counter++;
                if (sum == target || sum > target) {
                    if (minLength > counter) {
                        minLength = counter;
                    }
                    break;
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
