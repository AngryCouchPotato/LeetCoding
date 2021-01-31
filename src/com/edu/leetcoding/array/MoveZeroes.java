package com.edu.leetcoding.array;

/*
    283. Move Zeroes

    Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
    Example:
        Input: [0,1,0,3,12]
        Output: [1,3,12,0,0]
    Note:
        You must do this in-place without making a copy of the array.
        Minimize the total number of operations.

 */
public class MoveZeroes {

    // O(n) time : O(1) space
    public void moveZeroes(int[] nums) {
        int zeroId = -1;
        for (int current = 0; current < nums.length; current++) {
            if (nums[current] == 0 && zeroId == -1) {
                zeroId = current;
            } else if (nums[current] != 0 && zeroId != -1) {
                nums[zeroId++] = nums[current];
                nums[current] = 0;
            }
        }
    }
}
