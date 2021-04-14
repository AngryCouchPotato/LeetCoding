package com.edu.leetcoding.tree;

/**
 *  230. Kth Smallest Element in a BST
 *
 *  Given the root of a binary search tree, and an integer k, return the kth (1-indexed) smallest element in the tree.
 *
 *  Example 1:
 *      Input: root = [3,1,4,null,2], k = 1
 *      Output: 1
 *  Example 2:
 *      Input: root = [5,3,6,2,4,null,null,1], k = 3
 *      Output: 3
 *  Constraints:
 *      The number of nodes in the tree is n.
 *      1 <= k <= n <= 104
 *      0 <= Node.val <= 104
 *
 *  Follow up:  If the BST is modified often (i.e., we can do insert and delete operations) and you need to find
 *              the kth smallest frequently, how would you optimize?
 *
 * */
public class KthSmallestElementInABST {

    private int traversed;

    /**
     *  O(n) - time | O(n) - space
     */
    public int kthSmallest(TreeNode root, int k) {
        TreeNode node = traverse(root, k);
        return node.val;
    }

    private TreeNode traverse(TreeNode current, int k) {
        if(current == null) {
            return null;
        }
        TreeNode node = traverse(current.left, k);
        if(node != null) {
            return node;
        }
        traversed++;
        if(traversed == k) {
            return current;
        }
        node = traverse(current.right, k);
        if(node != null) {
            return node;
        }
        return null;
    }
}
