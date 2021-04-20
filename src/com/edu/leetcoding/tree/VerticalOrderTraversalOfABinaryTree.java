package com.edu.leetcoding.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<Point> cache = new ArrayList<>();
        dfs(root, new Point(0, 0, root.val), cache);
        Comparator<Point> comparator = new Comparator<Point>() {
            public int compare(Point cur, Point other) {
                if(cur.getX() == other.getX()) {
                    if(cur.getY() == other.getY()) {
                        return cur.getValue() - other.getValue();
                    } else {
                        return cur.getY() - other.getY();
                    }
                } else {
                    return cur.getX() - other.getX();
                }
            }
        };

        Collections.sort(cache, comparator);
        List<List<Integer>> result = new ArrayList<>();
        Point prev = null;
        List<Integer> curList = null;
        for(Point point : cache) {
            if(prev == null || prev.getX() != point.getX()) {
                curList = new ArrayList<>();
                result.add(curList);
            }
            curList.add(point.getValue());
            prev = point;
        }
        return result;
    }

    private void dfs(TreeNode node, Point point, List<Point> cache) {
        cache.add(point);
        if(node.left != null) {
            dfs(node.left, new Point(point.getX() - 1, point.getY() + 1, node.left.val), cache);
        }
        if(node.right != null) {
            dfs(node.right, new Point(point.getX() + 1, point.getY() + 1, node.right.val), cache);
        }
    }

    class Point {

        private int x;
        private int y;
        private int value;

        Point(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getValue() {
            return value;
        }

        public String toString() {
            return "x = " + x + ", y = " + y + ", value = " + value + ";";
        }
    }
}
