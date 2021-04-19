package com.edu.leetcoding.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  104. Maximum Depth of Binary Tree
 *
 *  Given the root of a binary tree, return its maximum depth.
 *  A binary tree's maximum depth is the number of nodes along the longest path from the root
 *  node down to the farthest leaf node.
 *
 *  Example 1:
 *      Input: root = [3,9,20,null,null,15,7]
 *      Output: 3
 *  Example 2:
 *      Input: root = [1,null,2]
 *      Output: 2
 *  Example 3:
 *      Input: root = []
 *      Output: 0
 *  Example 4:
 *      Input: root = [0]
 *      Output: 1
 *  Constraints:
 *      The number of nodes in the tree is in the range [0, 104].
 *      -100 <= Node.val <= 100
 *
 * */
public class MaximumDepthOfBinaryTree {
    /**
     *  O(n) - time | O(d) - space, where d is a tree diameter.
     */
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root == null){
            return depth;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

    /**
     *  O(n) - time | O(n) - space
     */
    public int maxDepthDFS(TreeNode root) {
        if(root == null){
            return 0;
        }
        return traverse(root, 0);
    }

    public int traverse(TreeNode node, int level) {
        if(node == null){
            return level;
        }
        int left = traverse(node.left, level + 1);
        int right = traverse(node.right, level + 1);
        return Math.max(left, right);
    }
}
