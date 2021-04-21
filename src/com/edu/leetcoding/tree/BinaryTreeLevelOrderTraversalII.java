package com.edu.leetcoding.tree;

import java.util.*;

/**
 *  107. Binary Tree Level Order Traversal II
 *
 *  Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
 *  (i.e., from left to right, level by level from leaf to root).
 *
 *  Example 1:
 *      Input: root = [3,9,20,null,null,15,7]
 *      Output: [[15,7],[9,20],[3]]
 *  Example 2:
 *      Input: root = [1]
 *      Output: [[1]]
 *  Example 3:
 *      Input: root = []
 *      Output: []
 *  Constraints:
 *      The number of nodes in the tree is in the range [0, 2000].
 *      -1000 <= Node.val <= 1000
 *
 * */
public class BinaryTreeLevelOrderTraversalII {

    /**
     *  O(n) - time | O(n) - space
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> curList;
        while(!queue.isEmpty()) {
            int size = queue.size();
            curList = new ArrayList<>();
            stack.push(curList);
            while(size > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                curList.add(node.val);
                size--;
            }
        }
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }
}
