package com.jenkin.algorithm.sort;

/**
 * 1、比较相邻两个元素，如果前一个元素比后一个元素大，则交换这两个元素的位置。
 * 2、对每一个元素做同样的工作，从开始第一对元素到结尾最后一对元素，最终最后位置的元素就是最大的
 * {4, 5, 6, 3, 2, 1}
 */
public class Bubble {

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (greater(a[j], a[j+1])) {
                    exch(a, j, j+1);
                }
            }
        }
    }

    /**
     * 判断v是否大于w
     * @param v
     * @param w
     * @return
     */
    private static boolean greater(Comparable v, Comparable w) {
        if (v.compareTo(w) > 0) {
            return true;
        }
        return false;
    }

    /**
     * 交换数组a中，索引i和索引j中的值
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
