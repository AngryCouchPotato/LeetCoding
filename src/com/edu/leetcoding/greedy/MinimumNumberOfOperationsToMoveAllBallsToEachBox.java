package com.edu.leetcoding.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 *  1769. Minimum Number of Operations to Move All Balls to Each Box
 *
 *  You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0'
 *  if the ith box is empty, and '1' if it contains one ball.
 *
 *  In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1.
 *  Note that after doing so, there may be more than one ball in some boxes.
 *
 *  Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
 *
 *  Each answer[i] is calculated considering the initial state of the boxes.
 *
 *  Example 1:
 *      Input: boxes = "110"
 *      Output: [1,1,3]
 *      Explanation: The answer for each box is as follows:
 *      1) First box: you will have to move one ball from the second box to the first box in one operation.
 *      2) Second box: you will have to move one ball from the first box to the second box in one operation.
 *      3) Third box: you will have to move one ball from the first box to the third box in two operations,
 *      and move one ball from the second box to the third box in one operation.
 *  Example 2:
 *      Input: boxes = "001011"
 *      Output: [11,8,5,4,3,4]
 *  Constraints:
 *      n == boxes.length
 *      1 <= n <= 2000
 *      boxes[i] is either '0' or '1'.
 *
 * */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {

    /**
     *  O(3*n) - time | O(3*n) - space
     */
    public int[] minOperations(String boxes) {
        int[] prefix = new int[boxes.length()];
        int count = 0;
        for(int i = 1; i < boxes.length(); i++) {
            if(boxes.charAt(i - 1) == '1') {
                prefix[i] = prefix[i - 1] + 1 + count;
                count++;
            } else {
                prefix[i] = prefix[i - 1] + count;
            }

        }

        int[] suffix = new int[boxes.length()];
        count = 0;
        for(int i = boxes.length() - 2; i >= 0; i--) {
            if(boxes.charAt(i + 1) == '1') {
                suffix[i] = suffix[i + 1] + 1 + count;
                count++;
            } else {
                suffix[i] = suffix[i + 1] + count;
            }
        }

        int[] res = new int[boxes.length()];
        for(int i = 0; i < res.length; i++) {
            res[i] = prefix[i] + suffix[i];
        }
        return res;
    }

    /**
     *  O(n*n) - time | O(n) - space
     */
    public int[] minOperationsWithSet(String boxes) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < boxes.length(); i++) {
            if(boxes.charAt(i) == '1') {
                set.add(i);
            }
        }
        int[] res = new int[boxes.length()];
        for(int i = 0; i < boxes.length(); i++) {
            int sum = 0;
            for(Integer val : set) {
                sum = sum + Math.abs(val - i);
            }
            res[i] = sum;
        }
        return res;
    }
}
