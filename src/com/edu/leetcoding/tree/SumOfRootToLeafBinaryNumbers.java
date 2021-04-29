package com.edu.leetcoding.tree;

/**
 *  1022. Sum of Root To Leaf Binary Numbers
 *
 *  You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path represents
 *  a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1,
 *  then this could represent 01101 in binary, which is 13.
 *
 *  For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.
 *  Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
 *
 *  Example 1:
 *      Input: root = [1,0,1,0,1,0,1]
 *      Output: 22
 *      Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
 *  Example 2:
 *      Input: root = [0]
 *      Output: 0
 *  Example 3:
 *      Input: root = [1]
 *      Output: 1
 *  Example 4:
 *      Input: root = [1,1]
 *      Output: 3
 *  Constraints:
 *      The number of nodes in the tree is in the range [1, 1000].
 *      Node.val is 0 or 1.
 *
 * */
public class SumOfRootToLeafBinaryNumbers {
    private int result = 0;

    /**
     *  O(n) - time | O(n) - space
     */
    public int sumRootToLeaf(TreeNode root) {
        if(root.left == null && root.right == null) {
            return root.val;
        }
        traverse(root, 0);
        return result;
    }

    private void traverse(TreeNode node, int sum) {
        if(node == null) {
            return;
        }
        sum = (sum << 1) | node.val;
        if(node.left == null && node.right == null) {
            result += sum;
            return;
        }
        traverse(node.left, sum);
        traverse(node.right, sum);
    }
}
