package com.edu.leetcoding.tree;


import java.util.ArrayList;
import java.util.List;

/**
 *  572. Subtree of Another Tree
 *
 *  Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values
 *  with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants.
 *  The tree s could also be considered as a subtree of itself.
 *
 *  Example 1:
 *  Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *  Given tree t:
 *    4
 *   / \
 *  1   2
 *  Return true, because t has the same structure and node values with a subtree of s.
 *  Example 2:
 *  Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 *  Given tree t:
 *    4
 *   / \
 *  1   2
 *  Return false.
 *
 * */
public class SubtreeOfAnotherTree {

    /**
     *  O(n * m) - time | O(n * m) - space
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        List<TreeNode> treeNodes = new ArrayList<>();
        searchRoots(s, t, treeNodes);

        for(TreeNode node : treeNodes) {
            if(compare(node, t)) {
                return true;
            }
        }
        return false;
    }

    private boolean compare(TreeNode big, TreeNode small) {
        if(big == null && small == null) {
            return true;
        }
        if(big == null && small != null ||
                big != null && small == null ||
                big.val != small.val) {
            return false;
        }
        boolean res = compare(big.left, small.left);
        if(!res) {
            return res;
        }
        res = compare(big.right, small.right);
        if(!res) {
            return res;
        }
        return big.val == small.val;
    }

    private void searchRoots(TreeNode big, TreeNode small, List<TreeNode> store) {
        if(big == null) {
            return;
        }
        if(big.val == small.val) {
            store.add(big);
        }
        searchRoots(big.left, small, store);
        searchRoots(big.right, small, store);
    }
}
