package com.edu.leetcoding.linkedlist;

/*
    203. Remove Linked List Elements

    Remove all elements from a linked list of integers that have value val.
    Example:
        Input:  1->2->6->3->4->5->6, val = 6
        Output: 1->2->3->4->5

 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head.val == val ? head.next : head;
    }
}
