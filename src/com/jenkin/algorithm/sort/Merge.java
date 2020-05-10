package com.jenkin.algorithm.sort;

/**
 * 归并排序是建立在归并操作上的一种有效排序算法，该算法是采用分治法的一个非常典型的应用。将已有序的子序列
 * 合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称
 * 为二路归并。
 *
 * 排序原理：
 *  1、尽可能的一组数据拆分成两个元素相等的子组，并对每一个子组继续拆分，直到拆分后的每个子组元素个数
 *  是1为止。
 *  2、将相邻的两个子组进行合并成一个有序的大组。
 *  3、不断的重复步骤2，直到最终只有一个组为止。
 */
public class Merge {

    private static Comparable[] assist;// 完成归并排序操作需要的辅助数组

    /**
     * 对数组内元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {

    }

    /**
     * 对数组a中从索引lo到索引hi之间的元素进行排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {

    }

    /**
     * 从索引lo到索引mid为一个子组，从索引mid+1到索引hi为另一个子组，把数组a中的这两个子组
     * 合并成一个有序的大组(从索引lo到索引hi)
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(Comparable[] a, int lo, int mid, int hi) {

    }

    /**
     * 判断v是否小于w
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return false;
    }

    /**
     * 交换数组a中索引为i和索引为j的值
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
