package com.edu.leetcoding.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {
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
