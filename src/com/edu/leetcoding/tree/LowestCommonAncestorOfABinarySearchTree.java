package com.edu.leetcoding.tree;


/**
 *  235. Lowest Common Ancestor of a Binary Search Tree
 *
 *  Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *  According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 *  as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *  Example 1:
 *      Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 *      Output: 6
 *      Explanation: The LCA of nodes 2 and 8 is 6.
 *  Example 2:
 *      Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 *      Output: 2
 *      Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to
 *      the LCA definition.
 *  Example 3:
 *      Input: root = [2,1], p = 2, q = 1
 *      Output: 2
 *  Constraints:
 *      The number of nodes in the tree is in the range [2, 105].
 *      -109 <= Node.val <= 109
 *      All Node.val are unique.
 *      p != q
 *      p and q will exist in the BST.
 *
 * */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     *  O(log(n)) - time | O(log(n)) - space
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode small;
        TreeNode big;
        if(p.val > q.val) {
            small = q;
            big = p;
        } else {
            small = p;
            big = q;
        }

        return lowestCommonAncestorHelper(root, small, big);
    }

    private TreeNode lowestCommonAncestorHelper(TreeNode root, TreeNode small, TreeNode big) {
        if(root.val > small.val && root.val > big.val) {
            return lowestCommonAncestorHelper(root.left, small, big);
        }
        if(root.val < small.val && root.val < big.val) {
            return lowestCommonAncestorHelper(root.right, small, big);
        }
        return root;
    }
}
