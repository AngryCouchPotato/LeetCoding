package com.edu.leetcoding.stack;

/**
 *  1381. Design a Stack With Increment Operation
 *
 *  Design a stack which supports the following operations.
 *
 *  Implement the CustomStack class:
 *      -   CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements
 *          in the stack or do nothing if the stack reached the maxSize.
 *      -   void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
 *      -   int pop() Pops and returns the top of stack or -1 if the stack is empty.
 *      -   void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less
 *          than k elements in the stack, just increment all the elements in the stack.
 *
 *  Constraints:
 *      -   1 <= maxSize <= 1000
 *      -   1 <= x <= 1000
 *      -   1 <= k <= 1000
 *      -   0 <= val <= 100
 *      -   At most 1000 calls will be made to each method of increment, push and pop each separately.
 *
 * */
public class CustomStack {
    private int[] array;
    private int topId;

    public CustomStack(int maxSize) {
        array = new int[maxSize];
        topId = -1;
    }

    /**
     *  O(1) - time | O(n) - space
     */
    public void push(int x) {
        if(topId == array.length - 1) {
            return;
        }
        array[++topId] = x;
    }

    /**
     *  O(1) - time | O(n) - space
     */
    public int pop() {
        if(topId < 0) {
            return -1;
        } else {
            int top = array[topId];
            array[topId--] = 0;
            return top;
        }
    }

    /**
     *  O(k) - time | O(n) - space
     */
    public void increment(int k, int val) {
        if(topId < 0) {
            return;
        }
        int min = Math.min(k, topId + 1);
        for(int i = 0; i < min; i++) {
            array[i] += val;
        }
    }
}
