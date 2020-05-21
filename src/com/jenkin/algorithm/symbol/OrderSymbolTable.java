package com.jenkin.algorithm.symbol;

public class OrderSymbolTable<Key extends Comparable<Key>,Value> {

    // 头结点
    private Node head;
    // 记录符号表中元素的个数
    private int N;

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        Node pre = head;
        Node cur = head.next;

        while (pre.next != null && key.compareTo(pre.next.key) > 0) {
            pre = cur;
            cur = cur.next;
        }

        // 1、当前符号表中已保存有Key信息
        if (cur != null && key.compareTo(cur.key) == 0) {
            cur.value = value;
            return;
        }

        // 2、当前符号表中未保存有Key信息，也需要遍历比较
        Node newNode = new Node(key, value, cur);
        pre.next = newNode;
        N++;
    }

    public Value get(Key key) {
        if (key == null) {
            return null;
        }
        Node n = head;
        while (n.next != null) {
            n = n.next;
            if (n.key.equals(key)) {
                return n.value;
            }
        }

        return null;
    }

    public void delete(Key key) {
        Node pre = head;
        while (pre.next != null) {
            if (pre.next.key.equals(key)) {
                pre.next = pre.next.next;
                N--;
                return;
            }
            pre = pre.next;
        }
    }

    private class Node {
        // 键
        public Key key;
        // 值
        public Value value;
        // 下一个键
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
