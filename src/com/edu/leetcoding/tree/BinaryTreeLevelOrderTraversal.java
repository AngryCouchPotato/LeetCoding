package com.edu.leetcoding.tree;

import java.util.ArrayList;
import java.util.List;

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
        levelOrder(root, 0, result);
        return result;
    }

    private void levelOrder(TreeNode node, int level, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        levelOrder(node.left, level + 1, result);
        levelOrder(node.right, level + 1, result);
    }
}
