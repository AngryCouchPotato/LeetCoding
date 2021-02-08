package com.edu.leetcoding.array;

import java.util.Arrays;

/*
    1146. Snapshot Array

    Implement a SnapshotArray that supports the following interface:
        SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
        void set(index, val) sets the element at the given index to be equal to val.
        int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
        int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id

    Example 1:
        Input: ["SnapshotArray","set","snap","set","get"]
        [[3],[0,5],[],[0,6],[0,0]]
        Output: [null,null,0,null,5]
        Explanation:
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0,5);  // Set array[0] = 5
        snapshotArr.snap();  // Take a snapshot, return snap_id = 0
        snapshotArr.set(0,6);
        snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5

    Constraints:
        1 <= length <= 50000
        At most 50000 calls will be made to set, snap, and get.
        0 <= index < length
        0 <= snap_id < (the total number of times we call snap())
        0 <= val <= 10^9

 */
public class SnapshotArray {

        private int[][] cache;
        private int[] currentArray;
        private int currentSnapId;

        public SnapshotArray(int length) {
            this.cache = new int[16][];
            this.currentSnapId = 0;
        }

        public void set(int index, int val) {
            if(currentArray == null) {
                currentArray = new int[index + 1];
            } else if(index >= currentArray.length){
                currentArray = Arrays.copyOf(currentArray, (int) (index * 1.5 + 1));
            }
            this.currentArray[index] = val;
        }

        public int snap() {
            int temp = this.currentSnapId;
            this.cache[temp] = currentArray;
            this.currentArray = null;
            this.currentSnapId++;
            if(this.currentSnapId == cache.length) {
                resize();
            }
            return temp;
        }

        private void resize() {
            int newLength = (int)(cache.length * 1.5);
            int[][] temp = new int[newLength][];
            System.arraycopy(cache, 0, temp, 0, cache.length);
            this.cache = temp;
        }

        public int get(int index, int snap_id) {
            for(int i = snap_id; i >= 0; i--) {
                if(cache[i] == null || index >= cache[i].length || cache[i][index] == 0) {
                    continue;
                }
                return cache[i][index];
            }
            return 0;
        }
}
