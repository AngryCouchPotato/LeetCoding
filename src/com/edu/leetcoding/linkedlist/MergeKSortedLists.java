package com.edu.leetcoding.linkedlist;

/**
 *  23. Merge k Sorted Lists
 *
 *  You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *  Merge all the linked-lists into one sorted linked-list and return it.
 *
 *  Example 1:
 *      Input: lists = [[1,4,5],[1,3,4],[2,6]]
 *      Output: [1,1,2,3,4,4,5,6]
 *      Explanation: The linked-lists are:
 *      [
 *          1->4->5,
 *          1->3->4,
 *          2->6
 *      ]
 *      merging them into one sorted list:
 *      1->1->2->3->4->4->5->6
 *  Example 2:
 *      Input: lists = []
 *      Output: []
 *  Example 3:
 *      Input: lists = [[]]
 *      Output: []
 *
 *  Constraints:
 *      k == lists.length
 *      0 <= k <= 10^4
 *      0 <= lists[i].length <= 500
 *      -10^4 <= lists[i][j] <= 10^4
 *      lists[i] is sorted in ascending order.
 *      The sum of lists[i].length won't exceed 10^4.
 *
 * */
public class MergeKSortedLists {

    /**
     *  O(k*n) - time | O(1) - space where
     *      k is the number of linked lists and
     *      n is the total number of nodes in all lists
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode current = null;
        boolean isAllNull = false;
        while (!isAllNull) {
            isAllNull = true;
            int min = Integer.MAX_VALUE;
            int minId = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                isAllNull = false;
                if (lists[i].val < min) {
                    minId = i;
                    min = lists[i].val;
                }
            }
            if (!isAllNull) {
                if (head == null) {
                    head = lists[minId];
                    current = head;
                } else {
                    current.next = lists[minId];
                    current = current.next;
                }
                lists[minId] = lists[minId].next;
            }
        }
        return head;
    }
}
