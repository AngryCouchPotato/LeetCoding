package com.edu.leetcoding.linkedlist;

/**
 *  92. Reverse Linked List II
 *
 *  Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of
 *  the list from position left to position right, and return the reversed list.
 *
 *  Example 1:
 *      Input: head = [1,2,3,4,5], left = 2, right = 4
 *      Output: [1,4,3,2,5]
 *  Example 2:
 *      Input: head = [5], left = 1, right = 1
 *      Output: [5]
 *  Constraints:
 *      The number of nodes in the list is n.
 *      1 <= n <= 500
 *      -500 <= Node.val <= 500
 *      1 <= left <= right <= n
 *
 *  Follow up: Could you do it in one pass?
 *
 * */
public class ReverseLinkedListII {

    /**
     *  O(n) - time | O(1) - space
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        ListNode previous = null;
        while (left > 1) {
            previous = current;
            current = current.next;
            left--;
            right--;
        }

        ListNode nodeBeforeReverse = previous;
        ListNode tail = current;

        ListNode temp = null;
        while (right-- > 0) {
            temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }

        if (nodeBeforeReverse != null) {
            nodeBeforeReverse.next = previous;
        } else {
            head = previous;
        }
        tail.next = current;
        return head;
    }
}
