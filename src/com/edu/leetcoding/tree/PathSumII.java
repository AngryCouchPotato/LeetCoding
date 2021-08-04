package com.edu.leetcoding.tree;

import java.util.ArrayList;
import java.util.List;

/**
 *  113. Path Sum II
 *
 *  Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each
 *  path's sum equals targetSum.
 *
 *  A leaf is a node with no children.
 *
 *  Example 1:
 *      Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 *      Output: [[5,4,11,2],[5,8,4,5]]
 *  Example 2:
 *      Input: root = [1,2,3], targetSum = 5
 *      Output: []
 *  Example 3:
 *      Input: root = [1,2], targetSum = 0
 *      Output: []
 *  Constraints:
 *      The number of nodes in the tree is in the range [0, 5000].
 *      -1000 <= Node.val <= 1000
 *      -1000 <= targetSum <= 1000
 *
 * */
public class PathSumII {

    /**
     *  O(n^2) - time complexity | O(n) - space complexity
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> paths = new ArrayList<Integer>();
        dfs(root, targetSum, paths, result);
        return result;
    }

    private void dfs(TreeNode node, int targetSum, List<Integer> paths, List<List<Integer>> result) {
        if (node == null) {
            return;
        }
        paths.add(node.val);
        if (targetSum == node.val && node.right == null && node.left == null) {
            result.add(new ArrayList<>(paths));
        } else {
            dfs(node.left, targetSum - node.val, paths, result);
            dfs(node.right, targetSum - node.val, paths, result);
        }

        paths.remove(paths.size() - 1);
    }
}
