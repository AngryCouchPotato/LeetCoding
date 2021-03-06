package com.edu.leetcoding.binarysearch;


/**
 *  1351. Count Negative Numbers in a Sorted Matrix
 *
 *  Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 *  return the number of negative numbers in grid.
 *
 *  Example 1:
 *      Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 *      Output: 8
 *      Explanation: There are 8 negatives number in the matrix.
 *  Example 2:
 *      Input: grid = [[3,2],[1,0]]
 *      Output: 0
 *  Example 3:
 *      Input: grid = [[1,-1],[-1,-1]]
 *      Output: 3
 *  Example 4:
 *      Input: grid = [[-1]]
 *      Output: 1
 *  Constraints:
 *      m == grid.length
 *      n == grid[i].length
 *      1 <= m, n <= 100
 *      -100 <= grid[i][j] <= 100
 *
 *  Follow up: Could you find an O(n + m) solution?
 *
 * */
public class CountNegativeNumbersInASortedMatrix {

    /**
     *  O(m*log(n)) - time | O(1) - space, where m - number of rows and n - number of columns.
     */
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int rowId = 0; rowId < grid.length; rowId++) {
            int[] row = grid[rowId];
            int length = row.length;
            if (row[length - 1] < 0) {
                int left = 0;
                int right = length - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (row[mid] < 0) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                count += (length - left);
            }
        }
        return count;
    }
}
