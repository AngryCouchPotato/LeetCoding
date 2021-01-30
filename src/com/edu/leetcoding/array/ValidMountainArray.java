package com.edu.leetcoding.array;

/*
    941. Valid Mountain Array

    Given an array of integers arr, return true if and only if it is a valid mountain array.

    Recall that arr is a mountain array if and only if:
        arr.length >= 3
        There exists some i with 0 < i < arr.length - 1 such that:
            arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
            arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
    Example 1:
        Input: arr = [2,1]
        Output: false
    Example 2:
        Input: arr = [3,5,5]
        Output: false
    Example 3:
        Input: arr = [0,3,2,1]
        Output: true
    Constraints:
        1 <= arr.length <= 104
        0 <= arr[i] <= 104

 */
public class ValidMountainArray {

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int previous = -1;
        boolean up = arr[0] < arr[1];
        if (!up) {
            return false;
        }
        for (int current : arr) {
            if (!up && previous < current) {
                return false;
            } else if (previous > current) {
                up = false;
            } else if (previous == current) {
                return false;
            }
            previous = current;
        }
        return !up;
    }
}
