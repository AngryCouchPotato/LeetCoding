package com.edu.leetcoding.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    144. Binary Tree Preorder Traversal

    Given the root of a binary tree, return the preorder traversal of its nodes' values.

    Example 1:
        Input: root = [1,null,2,3]
        Output: [1,2,3]
    Example 2:
        Input: root = []
        Output: []
    Example 3:
        Input: root = [1]
        Output: [1]
    Example 4:
        Input: root = [1,2]
        Output: [1,2]
    Example 5:
        Input: root = [1,null,2]
        Output: [1,2]
    Constraints:
        The number of nodes in the tree is in the range [0, 100].
        -100 <= Node.val <= 100

    Follow up: Recursive solution is trivial, could you do it iteratively?

 */
public class BinaryTreePreorderTraversal {

    //  O(n) time : O(1) space
    public List<Integer> preorderTraversalIterative(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }

    //  O(n) time : O(n) space
    public List<Integer> preorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalRecursive(root, result);
        return result;
    }

    private void preorderTraversalRecursive(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorderTraversalRecursive(node.left, result);
        preorderTraversalRecursive(node.right, result);
    }
}
