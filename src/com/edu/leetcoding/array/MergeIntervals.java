package com.edu.leetcoding.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *  56. Merge Intervals
 *
 *  Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 *  and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *  Example 1:
 *      Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 *      Output: [[1,6],[8,10],[15,18]]
 *      Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *  Example 2:
 *      Input: intervals = [[1,4],[4,5]]
 *      Output: [[1,5]]
 *      Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *  Constraints:
 *      1 <= intervals.length <= 104
 *      intervals[i].length == 2
 *      0 <= starti <= endi <= 104
 *
 */
public class MergeIntervals {

    /**
     *  O(n*log(n)) - time complexity | O(n) - space complexity, to store the result
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) {
            return intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] interval = intervals[0];
        List<int[]> list = new LinkedList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (interval[1] >= current[1]) {
                // swallow
            } else if (interval[1] >= current[0]) {
                interval[1] = current[1];
            } else if (interval[1] < current[0]) {
                list.add(interval);
                interval = current;
            }
        }
        list.add(interval);

        int[][] merged = new int[list.size()][2];
        int counter = 0;
        for (int[] array : list) {
            merged[counter++] = array;
        }
        return merged;
    }
}
