package com.edu.leetcoding.linkedlist;

/*
    19. Remove Nth Node From End of List

    Given the head of a linked list, remove the nth node from the end of the list and return its head.
    Follow up: Could you do this in one pass?

    Example 1:
        Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]
    Example 2:
        Input: head = [1], n = 1
        Output: []
    Example 3:
        Input: head = [1,2], n = 1
        Output: [1]
    Constraints:
        The number of nodes in the list is sz.
        1 <= sz <= 30
        0 <= Node.val <= 100
        1 <= n <= sz

    */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int count = 0;
        while(current != null) {
            current = current.next;
            count++;
        }
        if(count == n) {
            return head.next;
        }
        current = head;
        for(int i = 0; i < count - n - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        return head;
    }

}
