package com.edu.leetcoding.array;

import java.util.Arrays;

/**
    414. Third Maximum Number

    Given integer array nums, return the third maximum number in this array. If the third maximum does not exist, return the maximum number.
    Example 1:
        Input: nums = [3,2,1]
        Output: 1
        Explanation: The third maximum is 1.
    Example 2:
        Input: nums = [1,2]
        Output: 2
        Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
    Example 3:
        Input: nums = [2,2,3,1]
        Output: 1
        Explanation: Note that the third maximum here means the third maximum distinct number.
        Both numbers with value 2 are both considered as second maximum.
    Constraints:
        1 <= nums.length <= 10^4
        -2^31 <= nums[i] <= 2^31 - 1

    Follow up: Can you find an O(n) solution? // TODO

 */
public class ThirdMaximumNumber {

    /**
     *  O(n*log(n)) time : O(1) space
     */
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int firstMax = nums[nums.length - 1];
        int prev = firstMax;
        int counter = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (prev > nums[i]) {
                counter++;
                prev = nums[i];
            }
            if (counter == 3) {
                return prev;
            }
        }
        return firstMax;
    }
}
