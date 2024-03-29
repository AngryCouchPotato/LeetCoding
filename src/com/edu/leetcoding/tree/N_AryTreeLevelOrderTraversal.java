package com.edu.leetcoding.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *  429. N-ary Tree Level Order Traversal
 *
 *  Given an n-ary tree, return the level order traversal of its nodes' values.
 *
 *  Nary-Tree input serialization is represented in their level order traversal, each group of children
 *  is separated by the null value (See examples).
 *
 *  Example 1:
 *      Input: root = [1,null,3,2,4,null,5,6]
 *      Output: [[1],[3,2,4],[5,6]]
 *  Example 2:
 *      Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 *      Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 *  Constraints:
 *      The height of the n-ary tree is less than or equal to 1000
 *      The total number of nodes is between [0, 104]
 *
 */
public class N_AryTreeLevelOrderTraversal {

    /**
     * O(n) time complexity: O(n) space complexity
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        traverse(root, 0, result);
        return result;
    }

    private void traverse(Node node, int level, List<List<Integer>> result) {
        if(result.size() <= level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);
        for(Node childNode : node.children) {
            traverse(childNode, level + 1, result);
        }
    }

    /**
     * O(n) time complexity: O(n) space complexity
     */
    public List<List<Integer>> levelOrderBFS(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> levelList;
        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            levelList = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                levelList.add(node.val);
                if(node.children != null) {
                    queue.addAll(node.children);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
