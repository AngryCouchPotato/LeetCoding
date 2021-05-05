package com.edu.leetcoding.heap;

import java.util.PriorityQueue;

/**
 *  1046. Last Stone Weight
 *
 *  We have a collection of stones, each stone has a positive integer weight.
 *
 *  Each turn, we choose the two heaviest stones and smash them together.
 *  Suppose the stones have weights x and y with x <= y.  The result of this smash is:
 *
 *  If x == y, both stones are totally destroyed;
 *  If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
 *  At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
 *
 *  Example 1:
 *      Input: [2,7,4,1,8,1]
 *      Output: 1
 *      Explanation:
 *      We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
 *      we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
 *      we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
 *      we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of last stone.
 *  Note:
 *      1 <= stones.length <= 30
 *      1 <= stones[i] <= 1000
 *
 * */
public class LastStoneWeight {
    /**
     *  O(N * log(N)) - time | O(N) - size of the heap
     */
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        for(int stone : stones) {
            queue.add(stone);
        }
        while(queue.size() >= 2) {
            int stone1 = queue.poll();
            int stone2 = queue.poll();
            if(stone1 != stone2) {
                int newStone = Math.abs(stone1 - stone2);
                queue.add(newStone);
            }
        }
        if(queue.size() == 0) {
            return 0;
        }
        return queue.poll();
    }
}
