package com.jenkin.algorithm.linear;

import java.util.Iterator;

public class LinkList<T> implements Iterable<T> {


    private Node head;
    private int N;

    public LinkList() {
        this.head = new Node(null, null);
        this.N = 0;
    }

    /**
     * 空置线性表
     */
    public void clear() {
        this.head = null;
        this.N = 0;
    }

    /**
     * 判断线性表是否为空，如果是空，则返回true；否则返回false
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 返回链表的长度
     * @return
     */
    public int length() {
        return N;
    }

    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }

        Node n = head.next;
        for (int j = 0; j < i; j++) {
            n = n.next;
        }
        return n.item;
    }

    public void insert(T t) {
        if (t == null) {
            throw new RuntimeException("数据异常");
        }

        // 获取链表最后一个元素
        Node pre = head;
        for (int index = 0; index < N; index++) {
            pre = pre.next;
        }

        // 插入新结点，链表长度+1
        Node newNode = new Node(t, null);
        pre.next = newNode;
        N++;
    }

    public void insert(int i, T t) {
        if (i < 0 || i > N) {
            throw new RuntimeException("位置不合法");
        }

        // 获取i的前驱结点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }

        Node curNode = pre.next;
        Node newNode = new Node(t, curNode);
        pre.next = newNode;
        N++;
    }

    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }

        // 获取i的前驱结点
        Node pre = head;
        for (int index = 0; index < i; index++) {
            pre = pre.next;
        }

        Node curNode = pre.next;
        pre.next = curNode.next;
        N--;

        return curNode.item;
    }

    public int indexOf(T t) {
        if (t == null) {
            throw new RuntimeException("数据异常");
        }

        Node n = head;
        for (int index = 0; index < N; index++) {
            n = n.next;
            if (n.item.equals(t)) {
                return index;
            }
        }
        return -1;
    }



    private class Node {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    @Override
    public Iterator iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator<T> {

        private Node cursor;

        public LIterator() {
            this.cursor = head;
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
