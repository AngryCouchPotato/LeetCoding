package com.edu.leetcoding.binarysearch;


/**
 *  240. Search a 2D Matrix II
 *
 *  Write an efficient algorithm that searches for a target value in an m x n integer matrix.
 *  The matrix has the following properties:
 *      Integers in each row are sorted in ascending from left to right.
 *      Integers in each column are sorted in ascending from top to bottom.
 *  Example 1:
 *      Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 *      Output: true
 *  Example 2:
 *      Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 *      Output: false
 *  Constraints:
 *      m == matrix.length
 *      n == matrix[i].length
 *      1 <= n, m <= 300
 *      -10^9 <= matix[i][j] <= 10^9
 *      All the integers in each row are sorted in ascending order.
 *      All the integers in each column are sorted in ascending order.
 *      -10^9 <= target <= 10^9
 *
 * */
public class SearchA2DMatrixII {

    /**
     *  O(m*log(n)) - time | O(1) - space
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            int length = row.length;
            if (row[length - 1] == target) {
                return true;
            } else if (row[length - 1] > target) {
                int left = 0;
                int right = length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (row[mid] == target) {
                        return true;
                    } else if (row[mid] >= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
            }
        }
        return false;
    }
}
