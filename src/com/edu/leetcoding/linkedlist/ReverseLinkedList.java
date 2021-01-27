package com.edu.leetcoding.linkedlist;

/*
    206. Reverse Linked List

    Reverse a singly linked list.
    Example:
        Input: 1->2->3->4->5->NULL
        Output: 5->4->3->2->1->NULL
    Follow up:
        A linked list can be reversed either iteratively or recursively. Could you implement both?

    */
public class ReverseLinkedList {

    // O(n) time : O(1) space, where n - size of the list
    public ListNode reverseListIterative(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
    }

    // O(n) time : O(n) space, where n - size of the list
    public ListNode reverseListRecursive(ListNode head) {
        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode current, ListNode previous) {
        if (current == null) {
            return previous;
        }
        ListNode next = current.next;
        current.next = previous;
        return reverseList(next, current);
    }
}
