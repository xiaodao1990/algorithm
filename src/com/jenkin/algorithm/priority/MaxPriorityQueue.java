package com.jenkin.algorithm.priority;

public class MaxPriorityQueue<T extends Comparable<T>> {

    // 用于存储元素的数组
    private T[] items;
    // 记录堆中元素的个数
    private int N;

    public MaxPriorityQueue(int capacity) {
        items = (T[]) new Comparable[capacity];
        this.N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 往队列中插入一个元素
     */
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    public T delMax() {
        // 1、删除最大结点
        T max = items[1];
        exch(1, N);
        items[N] = null;
        N--;

        // 2、对索引1处通过下沉算法
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1) {// 新加入结点存放在数组末尾，然后与其父结点比较，如果大于父结点就往上浮
            if (less(k/2, k)) {
                exch(k/2, k);
            }
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {// 只有K<=N/2才能进行下沉比较
            // 获取2k和2k+1中较大值的索引
            int max = 2 * k;
            if (2 * k + 1 <= N) {// 存在右子结点
                if (less(2*k, 2*k+1)) {
                    max = 2 * k + 1;
                }
            }

            if (!less(k, max)) {
                break;
            }

            exch(k, max);
            k = max;
        }
    }
}
