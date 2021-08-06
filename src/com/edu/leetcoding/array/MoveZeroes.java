package com.edu.leetcoding.array;

/**
 *  283. Move Zeroes
 *
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *  Example:
 *      Input: [0,1,0,3,12]
 *      Output: [1,3,12,0,0]
 *  Note:
 *      You must do this in-place without making a copy of the array.
 *      Minimize the total number of operations.
 *
 */
public class MoveZeroes {

    /**
     * O(n) time complexity: O(1) space complexity
     */
    public void moveZeroes(int[] nums) {
        int zeroId = 0;
        for (int current = 0; current < nums.length; current++) {
            if (nums[current] != 0) {
                int temp = nums[zeroId];
                nums[zeroId++] = nums[current];
                nums[current] = temp;
            }
        }
    }
}
