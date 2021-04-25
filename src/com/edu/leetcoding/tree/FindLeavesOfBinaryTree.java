package com.edu.leetcoding.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  366. Find Leaves of Binary Tree
 *
 *  Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 *  Collect all the leaf nodes.
 *  Remove all the leaf nodes.
 *  Repeat until the tree is empty.
 *
 *  Example 1:
 *      Input: root = [1,2,3,4,5]
 *      Output: [[4,5,3],[2],[1]]
 *      Explanation:
 *      [[3,5,4],[2],[1]] and [[3,4,5],[2],[1]] are also considered correct answers since per each level it
 *      does not matter the order on which elements are returned.
 *  Example 2:
 *      Input: root = [1]
 *      Output: [[1]]
 *
 *  Constraints:
 *      The number of nodes in the tree is in the range [1, 100].
 *      1 <= Node.val <= 100
 *
 * */
public class FindLeavesOfBinaryTree {

    /**
     *  O(n * log(n)) - time | O(n * log(n)) - space
     */
    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> layer;
        while(!(root.left == null && root.right == null)) {
            layer = new ArrayList<>();
            traverse(root, layer);
            result.add(layer);
        }
        layer = new ArrayList<>();
        layer.add(root.val);
        result.add(layer);
        return result;
    }

    public boolean traverse(TreeNode node, List<Integer> res) {
        if(node == null) {
            return false;
        }
        if(node.left == null && node.right == null) {
            return true;
        }

        boolean isLeaf = traverse(node.left, res);
        if(isLeaf) {
            res.add(node.left.val);
            node.left = null;
        }
        isLeaf = traverse(node.right, res);
        if(isLeaf) {
            res.add(node.right.val);
            node.right = null;
        }
        return false;
    }
}
