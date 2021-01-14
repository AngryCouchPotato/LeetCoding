package com.edu.leetcoding.linkedlist;

/*
    234. Palindrome Linked List

    Given a singly linked list, determine if it is a palindrome.

    Example 1:
        Input: 1->2
        Output: false
    Example 2:
        Input: 1->2->2->1
        Output: true
    Follow up:
        Could you do it in O(n) time and O(1) space?

 */
public class PalindromeLinkedList {

    // O(n) time : O(1) space
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddleOfList(head);
        ListNode reversed = reverse(middle.next);

        ListNode current = head;
        while (reversed != null) {
            if (current.val != reversed.val) {
                return false;
            }
            current = current.next;
            reversed = reversed.next;
        }
        return true;
    }

    private ListNode findMiddleOfList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }
}
