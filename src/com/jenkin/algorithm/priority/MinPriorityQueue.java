package com.jenkin.algorithm.priority;

public class MinPriorityQueue<T extends Comparable<T>> {
    // 用来存储元素的数组
    private T[] items;
    // 记录堆中元素的个数
    private int N;

    public MinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity];
        this.N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    public void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    public T delMin() {
        T min = items[1];
        exch(1, N);
        items[N] = null;
        N--;

        sink(1);

        return min;
    }

    private void swim(int k) {
        while (k > 1) {
            if (!less(k/2, k)) {
                exch(k/2, k);
            }
            k = k/2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {// 只有K<=N/2才能进行下沉比较
            // 获取2k和2k+1中较小值的索引
            int min = 2 * k;
            if (2 * k + 1 <= N) {// 若存在右子结点
                if (less(2*k+1, 2*k)) {
                    min = 2*k+1;
                }
            }

            if (less(k, min)) {
                break;
            }

            exch(k, min);
            k = min;
        }
    }
}
