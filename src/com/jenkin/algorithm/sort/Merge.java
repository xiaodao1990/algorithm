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
 *  {8, 4, 5, 7, 1, 3, 6, 2}
 */
public class Merge {

    private static Comparable[] assist;// 完成归并排序操作需要的辅助数组

    /**
     * 对数组内元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        assist = new Comparable[a.length];
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }

    /**
     * 对数组a中从索引lo到索引hi之间的元素进行排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) /2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
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
        //  定义3个指针
        int assistIndex = lo;// 指向assit数组中开始填充数据的索引
        int loIndex = lo;// 指向第一组数据中的第一个元素
        int hiIndex = mid + 1;// 指向第二组数据中的第一个元素

        // 比较左边组和右边组的元素，哪个小就将哪个数据插入到assist数组中
        while (loIndex <= mid && hiIndex <= hi) {
            if (less(a[loIndex], a[hiIndex])) {
                assist[assistIndex++] = a[loIndex++];
            } else {
                assist[assistIndex++] = a[hiIndex++];
            }
        }

        // 上面循环结束，表示有一边的数据已经全部填充到assist数组中，将剩下的另一组的数据依次填充到assist数组中
        while (loIndex <= mid) {
            assist[assistIndex++] = a[loIndex++];
        }
        while (hiIndex <= hi) {
            assist[assistIndex++] = a[hiIndex++];
        }

        // 到目前为止，assist数组中，从lo到hi的元素是有序的，再把数据拷贝到a数组中对应的索引中
        for (int i = lo; i <= hi; i++) {
            a[i] = assist[i];
        }

    }

    /**
     * 判断v是否小于w
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        if (v.compareTo(w) < 0) {
            return true;
        }
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
