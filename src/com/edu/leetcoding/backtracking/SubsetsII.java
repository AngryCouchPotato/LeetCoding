package com.edu.leetcoding.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/*
    90. Subsets II

    Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.

    Example 1:
        Input: nums = [1,2,2]
        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
    Example 2:
        Input: nums = [0]
        Output: [[],[0]]
    Constraints:
        1 <= nums.length <= 10
        -10 <= nums[i] <= 10

 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDup(nums, result, new Stack<>(), 0);
        return result;
    }

    public void subsetsWithDup(int[] nums, List<List<Integer>> result, Stack<Integer> subResult, int start) {
        result.add(new ArrayList<>(subResult));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            subResult.push(nums[i]);
            subsetsWithDup(nums, result, subResult, i + 1);
            subResult.pop();
        }
    }
}
