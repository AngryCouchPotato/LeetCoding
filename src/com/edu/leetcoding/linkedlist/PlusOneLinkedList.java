package com.edu.leetcoding.linkedlist;

/**
 *  369. Plus One Linked List
 *
 *  Given a non-negative integer represented as a linked list of digits, plus one to the integer.
 *  The digits are stored such that the most significant digit is at the head of the list.
 *
 *  Example 1:
 *      Input: head = [1,2,3]
 *      Output: [1,2,4]
 *  Example 2:
 *      Input: head = [0]
 *      Output: [1]
 *  Constraints:
 *      The number of nodes in the linked list is in the range [1, 100].
 *      0 <= Node.val <= 9
 *      The number represented by the linked list does not contain leading zeros except for the zero itself.
 *
 * */
public class PlusOneLinkedList {

    /**
     *  O(n) - time | O(n) - space
     */
    public ListNode plusOne(ListNode head) {
        int res = plusOneRecursive(head);
        if (res == 1) {
            return new ListNode(1, head);
        } else {
            return head;
        }
    }

    public int plusOneRecursive(ListNode head) {
        if (head == null) {
            return 1;
        }
        head.val += plusOneRecursive(head.next);
        if (head.val == 10) {
            head.val = 0;
            return 1;
        } else {
            return 0;
        }
    }
}
