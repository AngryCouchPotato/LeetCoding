package com.edu.leetcoding.linkedlist;

/**
 *  61. Rotate List
 *
 *  Given the head of a linked list, rotate the list to the right by k places.
 *
 *  Example 1:
 *      Input: head = [1,2,3,4,5], k = 2
 *      Output: [4,5,1,2,3]
 *  Example 2:
 *      Input: head = [0,1,2], k = 4
 *      Output: [2,0,1]
 *  Constraints:
 *      The number of nodes in the list is in the range [0, 500].
 *      -100 <= Node.val <= 100
 *      0 <= k <= 2 * 109
 *
 * */
public class RotateList {

    /**
     *  O(n) - time | O(1) - space
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = length(head);
        if (length <= 1) {
            return head;
        }
        int newTailLength = length - k % length;
        if (newTailLength == length) {
            return head;
        }
        ListNode previous = null;
        ListNode newHead = head;
        while (newTailLength-- > 0) {
            previous = newHead;
            newHead = newHead.next;
        }
        previous.next = null;

        ListNode node = newHead;
        while (node.next != null) {
            node = node.next;
        }
        node.next = head;
        return newHead;

    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
