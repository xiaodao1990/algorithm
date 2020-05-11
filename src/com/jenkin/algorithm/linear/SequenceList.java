package com.jenkin.algorithm.linear;

import java.util.Iterator;

public class SequenceList<T> implements Iterable {

    // 存储元素的数组
    private T[] eles;

    // 当前线性表的长度 元素的索引为0～N-1
    private int N;

    /**
     * 创建容量为capacity的SequenceList对象
     * @param capacity
     */
    public SequenceList(int capacity) {
        this.eles = (T[]) new Object[capacity];
        this.N = 0;
    }

    /**
     * 清空线性表
     */
    public void clear() {
        this.N = 0;
    }

    /**
     * 判断线性表是否为空，是则返回true，否则返回false
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 获取线性表中元素的个数
     * @return
     */
    public int length() {
        return N;
    }

    /**
     * 获取并返回线性表中第i个元素的值
     * @param i
     * @return
     */
    public T get(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("当前元素不存在！");
        }
        return eles[i];
    }

    /**
     * 向线性表中添加一个元素t
     * @param t
     */
    public void insert(T t) {
        if (N == eles.length) {
            throw new RuntimeException("当前列表已满！");
        }
        eles[N++] = t;
    }

    /**
     * 在线性表的第i个元素之前插入一个值为t的元素
     * @param i
     * @param t
     */
    public void insert(int i, T t) {
        if (N == eles.length) {
            throw new RuntimeException("当前列表已满！");
        }

        if (i < 0 || i > N) {
            throw new RuntimeException("插入的位置不合法！");
        }
        // 将i位置空出来，i-1后面的元素都向后移动一位
        for (int index = N; index > i; index--) {
            eles[index] = eles[index - 1];
        }

        // 把t放到i处
        eles[i] = t;
        // 元素长度+1
        N++;
    }

    /**
     * 删除并返回线性表中的第i个数据元素
     * @param i
     * @return
     */
    public T remove(int i) {
        if (i < 0 || i >= N) {
            throw new RuntimeException("当前删除的元素不存在！");
        }

        T result = eles[i];

        // 把i后面的元素向前移动一位
        for (int index = i; index < N - 1; index++) {
            eles[index] = eles[index + 1];
        }
        N--;
        return result;
    }

    /**
     * 返回线性表中首次出现的指定的数据元素的索引值，若不存在，则返回-1
     * @param t
     * @return
     */
    public int indexOf(T t) {
        if (t == null) {
            throw new RuntimeException("查找的元素不合法！");
        }

        for (int i = 0; i < N; i++) {
            if (eles[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {

        private int cursor;

        public SIterator() {
            cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }
}
