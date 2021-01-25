package com.edu.leetcoding.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    78. Subsets

    Given an integer array nums of unique elements, return all possible subsets (the power set).
    The solution set must not contain duplicate subsets. Return the solution in any order.

    Example 1:
        Input: nums = [1,2,3]
        Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    Example 2:
        Input: nums = [0]
        Output: [[],[0]]
    Constraints:
        1 <= nums.length <= 10
        -10 <= nums[i] <= 10
        All the numbers of nums are unique.

    */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        subsets(nums, result, new Stack<>(), 0);
        return result;
    }

    private void subsets(int[] nums, List<List<Integer>> result, Stack<Integer> subResult, int start) {
        result.add(new ArrayList<>(subResult));
        for (int i = start; i < nums.length; i++) {
            subResult.push(nums[i]);
            subsets(nums, result, subResult, i + 1);
            subResult.pop();
        }
    }
}
