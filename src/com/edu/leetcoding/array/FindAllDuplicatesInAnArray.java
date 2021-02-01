package com.edu.leetcoding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    442. Find All Duplicates in an Array

     Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
    Find all the elements that appear twice in this array.
    Could you do it without extra space and in O(n) runtime?

    Example:
        Input:
        [4,3,2,7,8,2,3,1]

        Output:
        [2,3]

 */
public class FindAllDuplicatesInAnArray {

    // O(n) time | O(1) space
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            if (nums[val - 1] > 0) {
                nums[val - 1] = (-1) * nums[val - 1];
            } else {
                result.add(val);
            }
        }
        return result;
    }

    // O(n*log(n)) time | O(1) space
    public List<Integer> findDuplicates1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}
