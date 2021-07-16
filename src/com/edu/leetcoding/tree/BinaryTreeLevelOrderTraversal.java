package com.edu.leetcoding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    102. Binary Tree Level Order Traversal

    Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
    For example:
        Given binary tree [3,9,20,null,null,15,7],
            3
           / \
          9  20
            /  \
           15   7

        return its level order traversal as:
        [
          [3],
          [9,20],
          [15,7]
        ]

    */
public class BinaryTreeLevelOrderTraversal {

    //  O(n) time : O(n) space
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        levelOrderDFS(root, 0, result);
        return result;
    }

    private void levelOrderDFS(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        levelOrderDFS(node.left, level + 1, result);
        levelOrderDFS(node.right, level + 1, result);
    }

    //  O(n) time : O(n) space
    public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            result.add(list);
            while (size > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }

        return result;
    }
}
