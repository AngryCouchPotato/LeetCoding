package com.edu.leetcoding.linkedlist;

/**
 *  82. Remove Duplicates from Sorted List II
 *
 *  Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 *  numbers from the original list. Return the linked list sorted as well.
 *
 *  Example 1:
 *      Input: head = [1,2,3,3,4,4,5]
 *      Output: [1,2,5]
 *  Example 2:
 *      Input: head = [1,1,1,2,3]
 *      Output: [2,3]
 *  Constraints:
 *      The number of nodes in the list is in the range [0, 300].
 *      -100 <= Node.val <= 100
 *      The list is guaranteed to be sorted in ascending order.
 *
 * */
public class RemoveDuplicatesFromSortedListII {

    /**
     *  O(n) - time | O(1) - space
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(0, head);
        ListNode node = newHead;
        int valueToDelete = 0;
        boolean needToDelete = false;
        while (node.next != null && node.next.next != null) {
            if (node.next.val == node.next.next.val) {
                valueToDelete = node.next.val;
                needToDelete = true;
            }
            if (needToDelete) {
                ListNode tempNode = node;
                while (tempNode.next != null && tempNode.next.val == valueToDelete) {
                    tempNode.next = tempNode.next.next;
                }
                node.next = tempNode.next;
                needToDelete = false;
            } else {
                node = node.next;
            }
        }
        return newHead.next;
    }
}
