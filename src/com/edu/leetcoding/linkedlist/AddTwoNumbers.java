package com.edu.leetcoding.linkedlist;

/*
    2. Add Two Numbers

    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order, and each of their nodes contains a single digit.
    Add the two numbers and return the sum as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Example 1:
        Input: l1 = [2,4,3], l2 = [5,6,4]
        Output: [7,0,8]
        Explanation: 342 + 465 = 807.

    Example 2:
        Input: l1 = [0], l2 = [0]
        Output: [0]

    Example 3:
        Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
        Output: [8,9,9,9,0,0,0,1]
*/

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        addTwoNumbers(l1, l2, res, 0);
        return res;
    }

    public void addTwoNumbers(ListNode l1, ListNode l2, ListNode res, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return;
        }
        if (l1 != null) {
            carry = carry + l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            carry = carry + l2.val;
            l2 = l2.next;
        }
        res.val = carry % 10;
        carry = carry / 10;
        if (l1 != null || l2 != null || carry != 0) {
            res.next = new ListNode();
        }
        addTwoNumbers(l1, l2, res.next, carry);
    }
}
