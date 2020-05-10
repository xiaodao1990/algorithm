package com.jenkin.algorithm.sort;

/**
 * 希尔排序是插入排序的一种，被称为"缩小增量排序"，是插入排序算法中一种比较高效的改进版本。
 * 原理：
 *  1、选定一个增长量，按照增长量h作为数据分组的依据，对数据进行分组。
 *  2、对分好组的每一组数据完成插入排序
 *  3、减小增长量，最小减为1，重复第二步操作
 *
 *  增长量h的确定：增长量h的值有一个固定的规则，我们采用一下规则：
 *  int h = 1；
 *  while(h < 5) {
 *      h = 2h + 1;//3 7
 *  }
 *  循环结束后我们就可以确定h的最大值
 *  h减小的规则是：
 *      h=h/2；
 *
 *  {9, 1, 2, 5, 7, 4, 8, 6, 3, 5}
 */
public class Shell {

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        // 1.确定增长量h的最大值
        int N = a.length;
        int h = 1;
        while (h < N/2) {
            h = h*2 + 1;// 3、7...
        }

        // 当增长量h小于1，排序结束
        while (h >= 1) {
            for (int i = h; i < N; i++) {
                // 将a[i]插入到a[i-h],a[i-2h],a[i-3h]的序列中
                for (int j = i; j > 0 ; j-=h) {
                    if (greater(a[j - h], a[j])) {
                        exch(a, j - h, j);
                    } else {
                        break;
                    }
                }
            }
            h = h / 2;
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
     * 交换数组a中索引为i和索引为j处的值
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
