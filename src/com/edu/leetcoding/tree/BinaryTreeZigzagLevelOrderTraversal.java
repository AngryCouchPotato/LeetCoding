package com.edu.leetcoding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  103. Binary Tree Zigzag Level Order Traversal
 *
 *  Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 *  (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *  Example 1:
 *      Input: root = [3,9,20,null,null,15,7]
 *      Output: [[3],[20,9],[15,7]]
 *  Example 2:
 *      Input: root = [1]
 *      Output: [[1]]
 *  Example 3:
 *      Input: root = []
 *      Output: []
 *  Constraints:
 *      The number of nodes in the tree is in the range [0, 2000].
 *      -100 <= Node.val <= 100
 *
 * */
public class BinaryTreeZigzagLevelOrderTraversal {

    /**
     *  O(n) - time | O(n) - space
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Integer> curList;
        boolean reverse = false;
        while(!queue.isEmpty()) {
            int size = queue.size();
            curList = new LinkedList<>();
            while(size > 0) {
                TreeNode node = queue.poll();
                if(reverse) {
                    curList.add(0, node.val);
                } else {
                    curList.add(node.val);
                }
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            reverse = !reverse;
            result.add(curList);
        }
        return result;
    }
}
