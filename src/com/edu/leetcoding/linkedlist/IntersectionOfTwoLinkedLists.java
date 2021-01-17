package com.edu.leetcoding.linkedlist;

import java.util.HashSet;
import java.util.Set;

/*
    160. Intersection of Two Linked Lists

    Write a program to find the node at which the intersection of two singly linked lists begins.

    Example 1:
        Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
        Output: Reference of the node with value = 8
        Input Explanation:  The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
                            From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
                            There are 2 nodes before the intersected node in A;
                            There are 3 nodes before the intersected node in B.

 */
public class IntersectionOfTwoLinkedLists {

    // O(n + m) time : O(n) or O(m) space, where n and m are lengths of lists
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        Set<ListNode> cache = new HashSet<>();
        ListNode temp = headA;
        while(temp != null) {
            cache.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null) {
            if(cache.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
