package com.jenkin.algorithm.symbol;

public class SymbolTable<Key, Value> {

    // 记录首结点
    private Node head;
    // 记录符号表中元素的个数
    private int N;

    public SymbolTable() {
          this.head = new Node(null, null, null);
          this.N = 0;
    }

    public int size() {
        return N;
    }

    public void put(Key key, Value value) {
        // 1. 符号表中已经存在Key的键值
        Node n = head;
        while (n.next!= null) {
            n = n.next;
            if (n.key.equals(key)) {
                n.value = value;
                return;
            }
        }
        // 2. 符号表中不存在Key的键值,则将Key对应的键值插入到head结点之后
        Node oldFirst = head.next;
        Node newNode = new Node(key, value, oldFirst);
        head.next = newNode;
        N++;
    }

    /**
     * 从符号表中获取key对应的键
     * @param key
     * @return
     */
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

    /**
     * 删除符号表中键为key的键值对
     * @param key
     */
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
        // 下一个结点
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
