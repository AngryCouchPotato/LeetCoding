package com.edu.leetcoding.linkedlist;

import java.util.Stack;

/*
    445. Add Two Numbers II

    You are given two non-empty linked lists representing two non-negative integers.
    The most significant digit comes first and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Follow up:
        What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

    Example:
        Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
        Output: 7 -> 8 -> 0 -> 7

    */
public class AddTwoNumbersII {

    // O(n + m) time : O(n + m) space where n - length of list1 and m - length of list2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while(l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode res = null;
        while(!stack1.empty() || !stack2.empty() || carry > 0) {
            if(!stack1.empty()) {
                carry = carry + stack1.pop().val;
            }
            if(!stack2.empty()) {
                carry = carry + stack2.pop().val;
            }
            ListNode node = new ListNode(carry % 10, res);
            res = node;
            carry = carry / 10;
        }
        return res;
    }
}
