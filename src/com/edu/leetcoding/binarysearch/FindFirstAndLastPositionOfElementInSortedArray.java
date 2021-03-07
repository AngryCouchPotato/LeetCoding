package com.edu.leetcoding.binarysearch;

/**
 *  34. Find First and Last Position of Element in Sorted Array
 *
 *  Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 *  If target is not found in the array, return [-1, -1].
 *
 *  Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 *  Example 1:
 *      Input: nums = [5,7,7,8,8,10], target = 8
 *      Output: [3,4]
 *  Example 2:
 *      Input: nums = [5,7,7,8,8,10], target = 6
 *      Output: [-1,-1]
 *  Example 3:
 *      Input: nums = [], target = 0
 *      Output: [-1,-1]
 *  Constraints:
 *      0 <= nums.length <= 105
 *      -109 <= nums[i] <= 109
 *      nums is a non-decreasing array.
 *      -109 <= target <= 109
 *
 * */
public class FindFirstAndLastPositionOfElementInSortedArray {

    /**
     *  O(log(n)) - time | O(1) - space
     */
    public int[] searchRange(int[] nums, int target) {
        return new int[]{
                search(nums, target, true),
                search(nums, target, false)
        };
    }


    private int search(int[] nums, int target, boolean isLeft) {
        int res = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (isLeft) {
                    res = mid;
                    right = mid - 1;
                } else {
                    res = mid;
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}
