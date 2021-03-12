package com.edu.leetcoding.linkedlist;

/**
 *  1669. Merge In Between Linked Lists
 *
 *  You are given two linked lists: list1 and list2 of sizes n and m respectively.
 *  Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 *
 *  Example 1:
 *      Input: list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 *      Output: [0,1,2,1000000,1000001,1000002,5]
 *      Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place. The blue edges and nodes in the above figure indicate the result.
 *  Example 2:
 *      Input: list1 = [0,1,2,3,4,5,6], a = 2, b = 5, list2 = [1000000,1000001,1000002,1000003,1000004]
 *      Output: [0,1,1000000,1000001,1000002,1000003,1000004,6]
 *      Explanation: The blue edges and nodes in the above figure indicate the result.
 *
 *  Constraints:
 *      3 <= list1.length <= 104
 *      1 <= a <= b < list1.length - 1
 *      1 <= list2.length <= 104
 *
 * */
public class MergeInBetweenLinkedLists {

    /**
     *  O(n) - time | O(1) - space
     */
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head2 = list2;
        ListNode tail2 = list2;
        while (tail2.next != null) {
            tail2 = tail2.next;
        }
        int length = b - a + 1;
        ListNode fast = list1;
        for (int i = 0; i < length; i++) {
            fast = fast.next;
        }
        ListNode slow = list1;
        fast = fast.next;
        for (int i = 1; i < a; i++) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = head2;
        tail2.next = fast;
        return list1;
    }
}
