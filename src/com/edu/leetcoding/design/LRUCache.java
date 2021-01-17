package com.edu.leetcoding.design;

import java.util.HashMap;
import java.util.Map;

/*
    146. LRU Cache

    Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

    Implement the LRUCache class:
        LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
        int get(int key) Return the value of the key if the key exists, otherwise return -1.
        void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
    Follow up:
        Could you do get and put in O(1) time complexity?
    Example 1:
        Input
            ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
            [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
        Output
            [null, null, null, 1, null, -1, null, -1, 3, 4]
        Explanation
            LRUCache lRUCache = new LRUCache(2);
            lRUCache.put(1, 1); // cache is {1=1}
            lRUCache.put(2, 2); // cache is {1=1, 2=2}
            lRUCache.get(1);    // return 1
            lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
            lRUCache.get(2);    // returns -1 (not found)
            lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
            lRUCache.get(1);    // return -1 (not found)
            lRUCache.get(3);    // return 3
            lRUCache.get(4);    // return 4
        Constraints:
            1 <= capacity <= 3000
            0 <= key <= 3000
            0 <= value <= 104
            At most 3 * 104 calls will be made to get and put.

 */
public class LRUCache {

    private Map<Integer, Node> cache;
    private DoubleLinkedList mostRecentlyUsed;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.mostRecentlyUsed = new DoubleLinkedList();
    }

    public int get(int key) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            mostRecentlyUsed.setHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            mostRecentlyUsed.setHead(node);
        } else {
            if(cache.size() == capacity) {
                cache.remove(mostRecentlyUsed.tail.key);
                mostRecentlyUsed.deleteTail();
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            mostRecentlyUsed.setHead(node);
        }
    }

    static class DoubleLinkedList{
        private Node head;
        private Node tail;

        public void setHead(Node node) {
            if (head == node) {
                return;
            } else if(head == null) {
                head = node;
                tail = node;
            }	else if(head == tail) {
                node.next = head;
                head.prev = node;
                head = node;
            } else {
                if(tail == node) {
                    deleteTail();
                }
                node.removeBindings();
                head.prev = node;
                node.next = head;
                head = node;
            }
        }

        public void deleteTail() {
            if(tail == null){
                return;
            } else if (tail == head) {
                tail = null;
                head = null;
            } else {
                tail.prev.next = null;
                tail = tail.prev;
            }
        }
    }

    static class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public void removeBindings() {
            if(next != null) {
                next.prev = prev;
            }
            if(prev != null) {
                prev.next = next;
            }
            next = null;
            prev = null;
        }
    }
}
