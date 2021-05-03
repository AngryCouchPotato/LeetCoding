package com.edu.leetcoding.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *  1834. Single-Threaded CPU
 *
 *  You are given n tasks labeled from 0 to n - 1 represented by a 2D integer array tasks,
 *  where tasks[i] = [enqueueTimei, processingTimei] means that the i-th task will be available to process
 *  at enqueueTimei and will take processingTimei to finish processing.
 *
 *  You have a single-threaded CPU that can process at most one task at a time and will act in the following way:
 *  If the CPU is idle and there are no available tasks to process, the CPU remains idle.
 *  If the CPU is idle and there are available tasks, the CPU will choose the one with the shortest processing time.
 *  If multiple tasks have the same shortest processing time, it will choose the task with the smallest index.
 *  Once a task is started, the CPU will process the entire task without stopping.
 *  The CPU can finish a task then start a new one instantly.
 *  Return the order in which the CPU will process the tasks.
 *
 *  Example 1:
 *      Input: tasks = [[1,2],[2,4],[3,2],[4,1]]
 *      Output: [0,2,3,1]
 *      Explanation: The events go as follows:
 *      - At time = 1, task 0 is available to process. Available tasks = {0}.
 *      - Also at time = 1, the idle CPU starts processing task 0. Available tasks = {}.
 *      - At time = 2, task 1 is available to process. Available tasks = {1}.
 *      - At time = 3, task 2 is available to process. Available tasks = {1, 2}.
 *      - Also at time = 3, the CPU finishes task 0 and starts processing task 2 as it is the shortest. Available tasks = {1}.
 *      - At time = 4, task 3 is available to process. Available tasks = {1, 3}.
 *      - At time = 5, the CPU finishes task 2 and starts processing task 3 as it is the shortest. Available tasks = {1}.
 *      - At time = 6, the CPU finishes task 3 and starts processing task 1. Available tasks = {}.
 *      - At time = 10, the CPU finishes task 1 and becomes idle.
 *  Example 2:
 *      Input: tasks = [[7,10],[7,12],[7,5],[7,4],[7,2]]
 *      Output: [4,3,2,0,1]
 *      Explanation: The events go as follows:
 *      - At time = 7, all the tasks become available. Available tasks = {0,1,2,3,4}.
 *      - Also at time = 7, the idle CPU starts processing task 4. Available tasks = {0,1,2,3}.
 *      - At time = 9, the CPU finishes task 4 and starts processing task 3. Available tasks = {0,1,2}.
 *      - At time = 13, the CPU finishes task 3 and starts processing task 2. Available tasks = {0,1}.
 *      - At time = 18, the CPU finishes task 2 and starts processing task 0. Available tasks = {1}.
 *      - At time = 28, the CPU finishes task 0 and starts processing task 1. Available tasks = {}.
 *      - At time = 40, the CPU finishes task 1 and becomes idle.
 *  Constraints:
 *      tasks.length == n
 *      1 <= n <= 105
 *      1 <= enqueueTimei, processingTimei <= 109
 *
 * */
public class SingleThreadedCPU {

    /**
     *  O(n * log(n)) - time complexity | O(n) - space complexity, where n is count of the tasks
     */
    public int[] getOrder(int[][] tasks) {
        Triplet[] triplets = new Triplet[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            triplets[i] = new Triplet(i, tasks[i][0], tasks[i][1]);
        }

        // O(n * log(n)) - time complexity, where n - count of the tasks
        Arrays.sort(triplets, new Comparator<Triplet>() {
                    public int compare(Triplet tripletOne, Triplet tripletTwo) {
                        if (tripletOne.enqueueTime == tripletTwo.enqueueTime) {
                            if (tripletOne.processingTime == tripletTwo.processingTime) {
                                return tripletOne.index - tripletTwo.index;
                            }
                            return tripletOne.processingTime - tripletTwo.processingTime;
                        }
                        return tripletOne.enqueueTime - tripletTwo.enqueueTime;
                    }
                }
        );

        // O(n) - space complexity, where n - count of the tasks
        PriorityQueue<Triplet> queue = new PriorityQueue<Triplet>(
                new Comparator<Triplet>() {
                    public int compare(Triplet tripletOne, Triplet tripletTwo) {
                        if (tripletOne.processingTime == tripletTwo.processingTime) {
                            return tripletOne.index - tripletTwo.index;
                        }
                        return tripletOne.processingTime - tripletTwo.processingTime;
                    }
                }
        );

        Triplet triplet = null;
        int id = 0;

        // O(n) - space complexity, where n - count of the tasks
        int[] result = new int[tasks.length];
        int resId = 0;
        while (id < triplets.length) {
            long time = triplets[id].enqueueTime;// 1

            // O(log(n)) - time complexity, where n - count of the tasks
            queue.add(triplets[id]);
            id++;
            while (!queue.isEmpty()) {
                triplet = queue.poll();
                result[resId] = triplet.index;
                resId++;
                time += triplet.processingTime;
                while (id < triplets.length && triplets[id].enqueueTime <= time) {
                    queue.add(triplets[id]);
                    id++;
                }
            }
        }
        return result;
    }


    class Triplet {
        public int index;
        public int enqueueTime;
        public int processingTime;

        Triplet(int index, int enqueueTime, int processingTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }
    }
}
