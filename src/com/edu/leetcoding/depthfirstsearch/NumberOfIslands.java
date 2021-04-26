package com.edu.leetcoding.depthfirstsearch;

/**
 *  200. Number of Islands
 *
 *  Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 *  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 *  You may assume all four edges of the grid are all surrounded by water.
 *
 *  Example 1:
 *      Input: grid = [
 *          ["1","1","1","1","0"],
 *          ["1","1","0","1","0"],
 *          ["1","1","0","0","0"],
 *          ["0","0","0","0","0"]
 *      ]
 *      Output: 1
 *
 *  Example 2:
 *      Input: grid = [
 *          ["1","1","0","0","0"],
 *          ["1","1","0","0","0"],
 *          ["0","0","1","0","0"],
 *          ["0","0","0","1","1"]
 *      ]
 *      Output: 3
 *
 *  Constraints:
 *      m == grid.length
 *      n == grid[i].length
 *      1 <= m, n <= 300
 *      grid[i][j] is '0' or '1'.
 *
 * */
public class NumberOfIslands {

    /**
     *  O(n * m) - time | O(n * m) - space
     */
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == '1') {
                    countIslands(grid, row, col);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    public void countIslands(char[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        countIslands(grid, row - 1, col);
        countIslands(grid, row + 1, col);
        countIslands(grid, row, col - 1);
        countIslands(grid, row, col + 1);
    }
}
