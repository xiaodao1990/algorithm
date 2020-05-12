package com.jenkin.algorithm.linear;

import java.util.Iterator;

public class TwoWayLinkList<T> implements Iterable<T> {

    private Node head;
    private Node last;
    private int N;

    public TwoWayLinkList() {
        this.head = new Node(null, null, null);
        this.last = null;
        this.N = 0;
    }

    public void clear() {
        this.last = null;
        this.head.pre = null;
        this.head.next = null;
        this.head.item = null;
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法！");
        }

        Node n = head.next;
        for (int index = 0; index < i; index++) {
            n = n.next;
        }

        return n.item;
    }

    public void insert(T t) {
        // 1、last为空，则链表中为空，直接插入head后面
        if (last == null) {
            last = new Node(t, head, null);
            head.next = last;
        } else {
            // 2、last不为空，则直接插入到last后面
            Node oldLast = last;
            last = new Node(t, oldLast, null);
            oldLast.next = last;
        }
        N++;
    }

    public void insert(int i, T t) {
        if (i < 0 || i > N) {
            throw new RuntimeException("位置不合法！");
        }

        // 找到前一个结点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }

        // 获取索引i处结点
        Node curNode = pre.next;
        if (curNode != null) {
            Node newNode = new Node(t, pre, curNode);
            pre.next = newNode;
            curNode.pre = newNode;
        } else {// 此时插入位置为链表末尾
            if (last == null) {
                last = new Node(t, head, null);
                head.next = last;
            } else {
                // 2、last不为空，则直接插入到last后面
                Node oldLast = last;
                last = new Node(t, oldLast, null);
                oldLast.next = last;
            }
        }
        N++;
    }

    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法!");
        }

        // 获取索引i结点的前驱结点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }
        // 获取索引i处的结点
        Node curNode = pre.next;
        // 获取索引i处的结点的下一个结点
        Node cur_next = curNode.next;

        if (cur_next == null) {
            pre.next = null;
            last = pre;
        } else {
            // 删除索引i的结点
            pre.next = cur_next;
            cur_next.pre = pre;
        }
        // 长度-1
        N--;

        return curNode.item;
    }

    public int indexOf(T t) {
        Node n = head;
        for (int index = 0; n.next != null; index++) {
            n = n.next;
            if (n.next.equals(t)) {
                return index;
            }
        }
        return -1;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return head.next.item;
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return last.item;
    }

    private class Node {

        T item;
        Node pre;
        Node next;

        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new TIterator();
    }

    private class TIterator implements Iterator<T> {

        private Node cursor;

        public TIterator() {
            cursor = head;
        }

        @Override
        public boolean hasNext() {
            return cursor.next != null;
        }

        @Override
        public T next() {
            cursor = cursor.next;
            return cursor.item;
        }
    }
}
