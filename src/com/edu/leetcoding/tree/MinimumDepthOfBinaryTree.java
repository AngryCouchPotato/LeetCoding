package com.edu.leetcoding.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  111. Minimum Depth of Binary Tree
 *
 *  Given a binary tree, find its minimum depth.
 *  The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 *  Note: A leaf is a node with no children.
 *
 *  Example 1:
 *      Input: root = [3,9,20,null,null,15,7]
 *      Output: 2
 *  Example 2:
 *      Input: root = [2,null,3,null,4,null,5,null,6]
 *      Output: 5
 *  Constraints:
 *      The number of nodes in the tree is in the range [0, 105].
 *      -1000 <= Node.val <= 1000
 *
 * */
public class MinimumDepthOfBinaryTree {

    /**
     *  O(n) - time complexity | O(n) - space complexity
     */
    public int minDepth(TreeNode root) {
        int minDepth = 0;
        if (root == null) {
            return minDepth;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode node;
            minDepth++;
            for (int i = 0; i < levelSize; i++) {
                node = queue.poll();

                if (node.left == null && node.right == null) {
                    return minDepth;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return minDepth;
    }
}
