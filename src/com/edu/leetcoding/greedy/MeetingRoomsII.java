package com.edu.leetcoding.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 *  253. Meeting Rooms II
 *
 *  Given an array of meeting time intervals intervals where intervals[i] = [starti, endi],
 *  return the minimum number of conference rooms required.
 *
 *  Example 1:
 *      Input: intervals = [[0,30],[5,10],[15,20]]
 *      Output: 2
 *  Example 2:
 *      Input: intervals = [[7,10],[2,4]]
 *      Output: 1
 *  Constraints:
 *      1 <= intervals.length <= 104
 *      0 <= starti < endi <= 106
 *
 * */
public class MeetingRoomsII {

    /**
     *  O(n^2) - time | O(1) - space
     */
    public int minMeetingRooms(int[][] intervals) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0] - arr2[0];
            }
        };
        Arrays.sort(intervals, comparator);
        int result = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] == null) {
                continue;
            }
            int end = intervals[i][1];
            intervals[i] = null;
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[j] == null) {
                    continue;
                }
                if (intervals[j][0] >= end) {
                    end = intervals[j][1];
                    intervals[j] = null;
                }
            }
            result++;
        }
        return result;
    }
}
