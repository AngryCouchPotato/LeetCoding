package com.edu.leetcoding.array;

/*
    238. Product of Array Except Self

    Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

    Example:
        Input:  [1,2,3,4]
        Output: [24,12,8,6]
    Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

    Note: Please solve it without division and in O(n).

    Follow up:
        Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)

 */
public class ProductOfArrayExceptSelf {

    // O(n) time | O(1) space
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }

        int prev = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            int temp = nums[i - 1];
            nums[i - 1] = nums[i] * prev;
            prev = temp;
        }
        nums[nums.length - 1] = 1;

        for (int i = 0; i < nums.length; i++) {
            result[i] = result[i] * nums[i];
        }
        return result;
    }

    // O(n) time | O(n) space
    public int[] productExceptSelf2(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }

        int[] right = new int[nums.length];
        right[nums.length - 1] = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            right[i - 1] = nums[i] * right[i];
        }

        for (int i = 0; i < nums.length; i++) {
            left[i] = left[i] * right[i];
        }
        return left;
    }
}
