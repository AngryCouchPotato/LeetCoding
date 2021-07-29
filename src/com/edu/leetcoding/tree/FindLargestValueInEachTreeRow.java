package com.edu.leetcoding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  515. Find Largest Value in Each Tree Row
 *
 *  Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).
 *
 *  Example 1:
 *      Input: root = [1,3,2,5,3,null,9]
 *      Output: [1,3,9]
 *  Example 2:
 *      Input: root = [1,2,3]
 *      Output: [1,3]
 *  Example 3:
 *      Input: root = [1]
 *      Output: [1]
 *  Example 4:
 *      Input: root = [1,null,2]
 *      Output: [1,2]
 *  Example 5:
 *      Input: root = []
 *      Output: []
 *  Constraints:
 *      The number of nodes in the tree will be in the range [0, 104].
 *      -231 <= Node.val <= 231 - 1
 *
 * */
public class FindLargestValueInEachTreeRow {

    /**
     *  O(n) - time complexity | O(n) - space complexity
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode node;
            int levelMax = Integer.MIN_VALUE;
            for (int i = 0; i < levelSize; i++) {
                node = queue.poll();
                levelMax = Math.max(levelMax, node.val);
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            result.add(levelMax);
        }
        return result;
    }
}
