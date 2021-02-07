package com.edu.leetcoding.array;

import java.util.ArrayList;
import java.util.List;

/*
    54. Spiral Matrix

    Given an m x n matrix, return all elements of the matrix in spiral order.

    Example 1:
        Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
        Output: [1,2,3,6,9,8,7,4,5]
    Example 2:
        Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        Output: [1,2,3,4,8,12,11,10,9,5,6,7]
    Constraints:
        m == matrix.length
        n == matrix[i].length
        1 <= m, n <= 10
        -100 <= matrix[i][j] <= 100

 */
public class SpiralMatrix {

    // O(n) time : O(1) space
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        List<Integer> result = new ArrayList<>(right * bottom);
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top = top + 1;
            for (int j = top; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }
            right = right - 1;
            for (int i = right; i >= left; i--) {
                if (top > bottom) {
                    break;
                }
                result.add(matrix[bottom][i]);
            }
            bottom = bottom - 1;
            for (int j = bottom; j >= top; j--) {
                if (left > right) {
                    break;
                }
                result.add(matrix[j][left]);
            }
            left = left + 1;
        }
        return result;
    }
}
