package com.edu.leetcoding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  199. Binary Tree Right Side View
 *
 *  Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the
 *  nodes you can see ordered from top to bottom.
 *
 *  Example 1:
 *      Input: root = [1,2,3,null,5,null,4]
 *      Output: [1,3,4]
 *  Example 2:
 *      Input: root = [1,null,3]
 *      Output: [1,3]
 *  Example 3:
 *      Input: root = []
 *      Output: []
 *  Constraints:
 *      The number of nodes in the tree is in the range [0, 100].
 *      -100 <= Node.val <= 100
 *
 * */
public class BinaryTreeRightSideView {

    /**
     *  O(n) - time | O(d) - space, where d is a tree diameter.
     */
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size > 1) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            if(size == 1) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                result.add(node.val);
            }
        }
        return result;
    }
}
