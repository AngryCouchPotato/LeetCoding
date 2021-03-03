package com.edu.leetcoding.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
    1161. Maximum Level Sum of a Binary Tree

    Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
    Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

    Example 1:
        Input: root = [1,7,0,7,-8,null,null]
        Output: 2
        Explanation:
        Level 1 sum = 1.
        Level 2 sum = 7 + 0 = 7.
        Level 3 sum = 7 + -8 = -1.
        So we return the level with the maximum sum which is level 2.

    Example 2:
        Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
        Output: 2

    Constraints:
        The number of nodes in the tree is in the range [1, 10^4].
        -10^5 <= Node.val <= 10^5

 */
public class MaximumLevelSumOfBinaryTree {

    /**
     *   First solution with DFS algorithm
     *       O(n) time : O(h) space where h is maximum height of Binary Tree.
     */
    public int maxLevelSum_DFS(TreeNode root) {
        Map<Integer, Integer> cache = new HashMap<>();
        maxLevelSum(root, cache, 1);

        int minLevel = Integer.MAX_VALUE;
        int maxAmount = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : cache.entrySet()) {
            if (entry.getValue() > maxAmount ||
                    entry.getValue() == maxAmount && minLevel > entry.getKey()) {
                minLevel = entry.getKey();
                maxAmount = entry.getValue();
            }
        }
        return minLevel;
    }

    public void maxLevelSum(TreeNode root, Map<Integer, Integer> cache, int level) {
        if (root != null) {
            cache.put(level, cache.getOrDefault(level, 0) + root.val);
            maxLevelSum(root.left, cache, level + 1);
            maxLevelSum(root.right, cache, level + 1);
        }
    }

    /**
     *  Second solution with BFS algorithm
     *      O(n) time : O(w) where w is maximum width of Binary Tree
     */
    public int maxLevelSum_BFS(TreeNode root) {
        int minLevel = Integer.MAX_VALUE;
        int maxAmount = Integer.MIN_VALUE;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int amount = 0;
            level++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                amount = amount + node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (amount > maxAmount || amount == maxAmount && level < minLevel) {
                minLevel = level;
                maxAmount = amount;
            }
        }
        return minLevel;
    }
}
