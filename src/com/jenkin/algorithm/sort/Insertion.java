package com.jenkin.algorithm.sort;


/**
 * 1、把所有的元素分为两组，已排序和未排序的
 * 2、找到未排序的组中的第一个元素，向已经排序的组中进行插入
 * 3、倒叙遍历已经排序的元素，依次与待插入的元素进行比较，直到找到一个元素等于待插入
 * 元素，那么就把待插入元素放到那个位置，其他元素向后移动一位。
 * {4, 3, 2, 10, 12, 1, 5, 6}
 */
public class Insertion {

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        // 1、遍历数length-1，是因为最开始以第一位为已排序数组
        for (int i = 1; i < a.length; i++) {
            // 2、当前元素a[i]的值，依次与i之前的元素进行比较，直到找到一个小于a[i]的值
            for (int j = i; j > 0 ; j--) {
                if (greater(a[j - 1], a[j])) {
                    exch(a, j - 1, j);
                } else {
                    break;
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
     * 交换数组a中元素i和元素j处的值
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
