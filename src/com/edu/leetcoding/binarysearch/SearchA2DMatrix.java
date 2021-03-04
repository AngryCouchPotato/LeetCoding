package com.edu.leetcoding.binarysearch;

/**
 *  74. Search a 2D Matrix
 *
 *  Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 *  Integers in each row are sorted from left to right.
 *  The first integer of each row is greater than the last integer of the previous row.
 *  Example 1:
 *      Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 *      Output: true
 *  Example 2:
 *      Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 *      Output: false
 *  Constraints:
 *      m == matrix.length
 *      n == matrix[i].length
 *      1 <= m, n <= 100
 *      -10^4 <= matrix[i][j], target <= 10^4
 *
 * */
public class SearchA2DMatrix {

    /**
     *  O(log(m) + log(n)) - time | O(1) - space
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        while (top <= bottom) {
            int midV = (top + bottom) / 2;
            int[] row = matrix[midV];
            if (row[0] == target) {
                return true;
            } else if (row[0] < target && target <= row[row.length - 1]) {
                int left = 0;
                int right = row.length - 1;
                while (left <= right) {
                    int midH = (left + right) / 2;
                    if (row[midH] == target) {
                        return true;
                    } else if (row[midH] > target) {
                        right = midH - 1;
                    } else {
                        left = midH + 1;
                    }
                }
                return false;
            } else if (row[0] > target) {
                bottom = midV - 1;
            } else {
                top = midV + 1;
            }
        }
        return false;
    }
}
