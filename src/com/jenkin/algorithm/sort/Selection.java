package com.jenkin.algorithm.sort;

/**
 * 1、每一次遍历的过程中，都假定第一个索引处的元素是最小值，和其他索引处的元素进行比较，
 * 如果当前元素的值大于其他某个索引处的值，则假定其他某个索引处的值为最小值，最后找到最
 * 小值所在的索引处。
 * 2、交换第一个索引处和最小值所在的索引处的值。
 *
 * 翻译：将数组分为已排序区和待排序区，假定待排序区第一个值为最小值，跟待排序区其他值进行比较
 * 发现更小的则记录其索引，最后遍历完成交换到第一个位置。变成已排序区。
 * (4, 6, 8, 7, 9, 2, 10, 1)
 */
public class Selection {

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length-1; i++) {
            // 假定本次遍历，最小值所在的索引是i
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (greater(a[i], a[j])) {
                    // 替换最小值所在索引
                    minIndex = j;
                }
            }
            // 交换i索引处和minIndex索引所在的值
            exch(a, i, minIndex);
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
     * 交换数组a中索引i和索引j的值
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
