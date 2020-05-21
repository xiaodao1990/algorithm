package com.jenkin.algorithm.heap;

public class Heap<T extends Comparable<T>> {

    // 存储堆中的元素
    private T[] items;
    // 记录堆中元素的个数
    private int N;

    public Heap(int capacity) {
        // 由于需要将0舍弃
        items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    public T delMax() {
        T max = items[1];
        exch(1, N);
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1) {
            if (less(k / 2, k)) {
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2*k <= N) {
            int maxIndex = 2*k;
            if (2*k+1 <= N && less(2*k, 2*k+1)) {
                maxIndex = 2*k+1;
            }

            if (!less(k, maxIndex)) {
                break;
            }

            exch(k, maxIndex);
            k = maxIndex;
        }
    }
}
