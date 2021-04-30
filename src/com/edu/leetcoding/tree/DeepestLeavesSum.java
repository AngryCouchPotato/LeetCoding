package com.edu.leetcoding.tree;

/**
 *  1302. Deepest Leaves Sum
 *
 *  Given the root of a binary tree, return the sum of values of its deepest leaves.
 *
 *  Example 1:
 *      Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 *      Output: 15
 *  Example 2:
 *      Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 *      Output: 19
 *  Constraints:
 *      The number of nodes in the tree is in the range [1, 104].
 *      1 <= Node.val <= 100
 *
 * */
public class DeepestLeavesSum {

    private int maxLevel = 0;
    private int deepestLeavesSum = 0;

    /**
     *  O(N) - time | O(H) - space to keep stack, where H is a tree height
     */
    public int deepestLeavesSum(TreeNode root) {
        traverse(root, 0);
        return deepestLeavesSum;
    }

    private void traverse(TreeNode node, int level) {
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            if(level == maxLevel) {
                deepestLeavesSum += node.val;
            } else if (level > maxLevel) {
                maxLevel = level;
                deepestLeavesSum = node.val;
            }
            return;
        }
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }
}
