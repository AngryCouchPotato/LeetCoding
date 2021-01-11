package com.edu.leetcoding.tree;

/*
    1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree

    Given two binary trees original and cloned and given a reference to a node target in the original tree.
    The cloned tree is a copy of the original tree.
    Return a reference to the same node in the cloned tree.

    Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

    Follow up: Solve the problem if repeated values on the tree are allowed.

    */
public class FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return search(original, cloned, target);
    }

    private TreeNode search(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original != null) {
            TreeNode node = search(original.left, cloned.left, target);
            if(node != null) {
                return node;
            }
            if(original.val == target.val) {
                return cloned;
            }
            node = search(original.right, cloned.right, target);
            if(node != null) {
                return node;
            }
        }
        return null;
    }

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
