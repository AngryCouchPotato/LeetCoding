package com.edu.leetcoding.tree;

/**
 *  938. Range Sum of BST
 *
 *  Given the root node of a binary search tree, return the sum of values of all nodes with a
 *  value in the range [low, high].
 *
 *  Example 1:
 *      Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 *      Output: 32
 *  Example 2:
 *      Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 *      Output: 23
 *  Constraints:
 *      The number of nodes in the tree is in the range [1, 2 * 104].
 *      1 <= Node.val <= 105
 *      1 <= low <= high <= 105
 *      All Node.val are unique.
 *
 * */
public class RangeSumOfBST {
    private int rangeSum = 0;

    /**
     *  O(n) - time | O(n) - space
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return rangeSum;
    }

    public void traverse(TreeNode node, int low, int high) {
        if(node == null) {
            return;
        }
        if(low <= node.val && node.val <= high) {
            rangeSum += node.val;
        }
        traverse(node.left, low, high);
        traverse(node.right, low, high);
    }
}
