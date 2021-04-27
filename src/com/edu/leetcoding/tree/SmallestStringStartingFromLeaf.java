package com.edu.leetcoding.tree;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 *  988. Smallest String Starting From Leaf
 *
 *  Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value
 *  of 0 represents 'a', a value of 1 represents 'b', and so on.
 *
 *  Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 *  (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is
 *  lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 *
 *  Example 1:
 *      Input: [0,1,2,3,4,3,4]
 *      Output: "dba"
 *  Example 2:
 *      Input: [25,1,3,1,3,0,2]
 *      Output: "adz"
 *  Example 3:
 *      Input: [2,2,1,null,1,0,null,0]
 *      Output: "abc"
 *  Note:
 *      The number of nodes in the given tree will be between 1 and 8500.
 *      Each node in the tree will have a value between 0 and 25.
 *
 * */
public class SmallestStringStartingFromLeaf {
    /**
     *  O(n * log(n)) - time | O(n) - space
     */
    public String smallestFromLeaf(TreeNode root) {
        Queue<String> queue = new PriorityQueue<>();
        traverse(root, createString(root.val, ""), queue);
        return queue.peek();
    }

    private void traverse(TreeNode node, String str, Queue<String> queue) {
        if(node.left == null && node.right == null) {
            queue.offer(str);
            return;
        }
        if(node.left != null) {
            traverse(node.left, createString(node.left.val, str), queue);
        }
        if(node.right != null) {
            traverse(node.right, createString(node.right.val, str), queue);
        }
    }

    private String createString(int charNum, String postfix) {
        StringBuilder sb = new StringBuilder();
        sb.append((char)(charNum + 'a')).append(postfix);
        return sb.toString();
    }

}
