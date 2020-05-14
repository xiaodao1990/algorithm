package com.jenkin.algorithm.priority;

import java.awt.image.Kernel;

/**
 * 在之前实现的最大优先队列和最小优先队列，可以分别快速访问到队列中的最大元素和最小元素，但是他们有一个缺点
 * 就是没有办法通过索引访问已存在与队列中的对象，并更新它们。
 * 为了实现这个目的，在优先队列的基础上，学习一种新的数据结构，索引优先队列。
 *
 * 实现思路：
 * 1、存储数据时，给每一个数据元素关联一个整数，例如insert(int k, T t),我们可以看做k是t关联的整数，那么
 * 我们的实现需要通过k这个值，快速获取到队列中的这个元素，此时这个k值需要具有唯一性
 * T[] items = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"}
 * 2、步骤1完成之后，虽然我们能使用数组的索引快速获取该元素，但是，items数组中的元素顺序是随机的，并不是堆
 * 有序的，所以，为了完成这个需求，我们可以增加一个数组int[] pq，来保存每个元素在items数组中的索引，pq数组
 * 需要堆有序。
 */
public class IndexMinPriorityQueue<T extends Comparable<T>> {

    // 用来存储元素的数组
    private T[] items;
    // 堆有序的状态下，保存每个元素在items数组中的索引
    private int[] pq;
    // pq的值作为索引，pq的索引作为值
    private int[] qp;
    // 记录堆中元素的个数
    private int N;

    public IndexMinPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.pq = new int[capacity + 1];
        this.qp = new int[capacity + 1];
        this.N = 0;
        for (int i = 0; i < qp.length; i++) {
            // 默认情况下，qp逆序中不保存任何索引
            qp[i] = -1;
        }
    }

    /**
     * 获取队列中元素的个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
     * @param i
     * @param j
     * @return
     *
     */
    private boolean less(int i, int j) {
        // 先通过pq找出items中的索引，然后再找出items中元素进行对比
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    /**
     * 交换堆中i索引和j索引处的值
     * @param i
     * @param j
     */
    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;


        // 更新qp数组中的值
        // 由于pq的值作为qp的索引，pq的索引作为qp的值
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    /**
     * 往队列中插入一个元素，并关联索引i
     * @param i
     * @param t
     */
    public void insert(int i, T t) {
        if (contains(i)) {
            throw new RuntimeException("该索引已经存在");
        }
        // 个数+1
        N++;
        // 把元素存放到items数组之中
        items[i] = t;// 由于堆中插入一个元素时都是items的最后一个位置插入
        // 使用pq存放i这个索引
        pq[N] = i;
        // 在qp的i索引处存放N
        qp[i] = N;
        // 上浮items[pq[N]]，让qp堆有序
        swim(N);
    }

    /**
     * 删除队列中最小的元素，并返回该元素关联的索引
     * @return
     */
    public int delMin() {
        // 找到items最小元素的索引
        int minIndex = pq[1];
        // 交换pq中索引1处和N处的值
        exch(1, N);
        // 删除qp中索引为pq[N]处的值
        qp[pq[N]] = -1;
        // 删除pq中索引为N处的值
        pq[N] = -1;
        // 删除items中最小的元素
        items[minIndex] = null;
        // 元素个数-1
        N--;
        // 对pq[1]做下沉
        sink(1);
        return minIndex;
    }

    /**
     * 删除索引i关联的元素
     * @param i
     */
    public void delete(int i) {
        // 找出i在pq中的索引
        int k = qp[i];
        // 把pq中索引为k的值和索引为N处的值交换
        exch(k, N);
        // 删除qp中索引为pq[N]的值
        qp[pq[N]] = -1;
        // 删除pq中索引N处的值
        pq[N] = -1;
        // 删除items中索引i处的值
        items[i] = null;
        // 元素个数-1
        N--;
        // 由于不知道k索引处的值需要下沉还是上浮，所以都做
        sink(k);
        swim(k);
    }

    /**
     * 使用上浮算法，使索引k处元素能在堆中处于一个正确的位置
     * @param k
     */
    private void swim(int k) {
        while (k > 1) {
            if (less(k, k/2)) {
                exch(k, k/2);
            }
            k = k/2;
        }
    }

    /**
     * 使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
     * @param k
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int min = 2 * k;
            if (2*k + 1 <= N && less(2*k+1, 2*k)) {
                min = 2*k+1;
            }

            if (less(k, min)) {
                break;
            }

            exch(k, min);
            k= min;
        }
    }

    /**
     * 判断k对应的元素是否存在
     * @param k
     * @return
     */
    private boolean contains(int k) {
        return qp[k] != -1;
    }

    /**
     * 把与索引i关联的元素修改为t
     * @param i
     * @param t
     */
    public void changeItem(int i, T t) {
        // 修改items数组中索引i处的值为t
        items[i] = t;
        // 找到索引i在pq中的位置
        int k = qp[i];
        // 对pq[k]做下沉，让堆有序
        sink(k);
        // 堆pq[k]做上浮，让堆有序
        swim(k);
    }

    /**
     * 最小元素关联的索引
     * @return
     */
    public int minIndex() {
        return pq[1];
    }
}
