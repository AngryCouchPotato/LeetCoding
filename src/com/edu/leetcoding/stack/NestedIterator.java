package com.edu.leetcoding.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 *  341. Flatten Nested List Iterator
 *
 *  Given a nested list of integers, implement an iterator to flatten it.
 *
 *  Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 *  Example 1:
 *      Input: [[1,1],2,[1,1]]
 *      Output: [1,1,2,1,1]
 *      Explanation:    By calling next repeatedly until hasNext returns false,
 *                      the order of elements returned by next should be: [1,1,2,1,1].
 *  Example 2:
 *      Input: [1,[4,[6]]]
 *      Output: [1,4,6]
 *      Explanation:    By calling next repeatedly until hasNext returns false,
 *                      the order of elements returned by next should be: [1,4,6].
 */
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        addToStackInReverseOrder(nestedList);
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    private void moveIntegerToTop() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            NestedInteger top = stack.pop();
            addToStackInReverseOrder(top.getList());
        }
    }

    private void addToStackInReverseOrder(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return;
        }
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public boolean hasNext() {
        moveIntegerToTop();
        return !stack.isEmpty();
    }

    public interface NestedInteger {
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }
}
