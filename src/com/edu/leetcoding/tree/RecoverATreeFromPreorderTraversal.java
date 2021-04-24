package com.edu.leetcoding.tree;

import java.util.Stack;

/**
 *  1028. Recover a Tree From Preorder Traversal
 *
 *  We run a preorder depth-first search (DFS) on the root of a binary tree.
 *
 *  At each node in this traversal, we output D dashes (where D is the depth of this node), then we output
 *  the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.
 *  The depth of the root node is 0.
 *
 *  If a node has only one child, that child is guaranteed to be the left child.
 *  Given the output S of this traversal, recover the tree and return its root.
 *
 *  Example 1:
 *      Input: S = "1-2--3--4-5--6--7"
 *      Output: [1,2,5,3,4,6,7]
 *  Example 2:
 *      Input: S = "1-2--3---4-5--6---7"
 *      Output: [1,2,5,3,null,6,null,4,null,7]
 *  Example 3:
 *      Input: S = "1-401--349---90--88"
 *      Output: [1,401,null,349,88,90]
 *  Constraints:
 *      The number of nodes in the original tree is in the range [1, 1000].
 *      1 <= Node.val <= 109
 *
 * */
public class RecoverATreeFromPreorderTraversal {

    /**
     *  O(n) - time | O(n) - space
     */
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0; i < S.length(); ) {
            int level = 0;
            while(i < S.length() && (S.charAt(i) == '-')) {
                level++;
                i++;
            }

            int number = 0;
            while(i < S.length() && (S.charAt(i) >= '0' && S.charAt(i) <= '9') ) {
                int num = S.charAt(i) - '0';
                number = number * 10 + num;
                i++;
            }

            if(stack.isEmpty()) {
                stack.push(new TreeNode(number));
                continue;
            }

            while(stack.size() > level) {
                stack.pop();
            }

            TreeNode current = new TreeNode(number);

            TreeNode node = stack.peek();
            if(node.left == null) {
                node.left = current;
            } else {
                node.right = current;
            }
            stack.push(current);
        }
        return stack.firstElement();
    }
}
