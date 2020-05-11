package com.jenkin.algorithm.sort;

/**
 * 快速排序是对冒泡排序的一种改进。
 * 基本思想：
 *      通过一趟排序将要排序的数据分割成独立的两部分，其中一部分的所有数据都比另外一部分的所有数据要小。
 *      然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序
 *      序列。
 * 排序原理：
 *      1、首先设定一个分界值，通过该分界值将数组分为左右两部分；
 *      2、将大于或等于分界值的数据放到数组右边，小于分界值的数据放到数组左边。此时左边部分中各元素都小于或
 *      等于分界值，而右边部分中各元素都大于或等于分界值。
 *      3、然后，左边和右边的数据可以独立排序。对于左边的数组数据，又可以取一个分界值，将该部分数据分成左右
 *      两部分，同样在左边放置较小值，右边放置较大值，右侧的数组数据也可以做类似处理。
 *      4、重复上述过程。
 *
 * 白话理解：通过递归将左侧部分排好序后，再递归将右侧部分排好序。当左侧和右侧两部分的数据都排好序后，整个数组
 *          的排序就完成了。
 *
 * 把一个数组切分为两个数组的基本思想：
 *      1、找一个基准值，用两个指针分别指向数组的头部和尾部
 *      2、先从尾部向头部开始搜索一个比基准值小的元素，搜索到即停止，并记录指针的位置
 *      3、再从头部向尾部开始搜索一个比基准值大的元素，搜索到即停止，并记录指针的位置
 *      4、交换当前左边指针位置和右边指针位置的元素
 *      5、重复2，3，4步骤，直到左边指针的值大于右边指针的值停止。
 *
 * {6, 1, 2, 7, 9, 3, 4, 5, 8}
 *
 */
public class Quick {

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a) {
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

        // 在数组a，对从lo到hi的元素进行切分
        int partition = partition(a, lo, hi);
        // 递归方式，先对左边分组中的元素进行排序
        sort(a, lo, partition - 1);
        // 递归方式，对右边分组中的元素进行排序
        sort(a, partition + 1, hi);
    }

    /**
     * 对数组a中，从索引lo到索引hi之间的元素进行分组，并返回分组界限对应的索引。
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a, int lo, int hi) {
        // 1、获取基准值
        Comparable key = a[lo];
        // 2、定义两个指针,左侧指针，初始指向最左边的元素；右侧指针，初始指向右侧元素的下一个位置
        int left = lo;
        int right = hi + 1;

        // 3、循环切分
        while (true) {

            // 3.1 先从右往左扫描，找到一个比基准值小的元素
            while (less(key, a[--right])) {// 循环停止，说明找到一个比基准值小的元素
                if (right == lo) {// 已经扫描到最左边了，无法继续扫描了
                    break;
                }
            }

            // 3.2 再从左往右扫描，找到一个比基准值大的元素
            while (less(a[++left], key)) {// 循环停止，说明找到一个比基准值大的元素
                if (left == hi) {// 已经扫描到最右边了，无法继续扫描了
                    break;
                }
            }

            if (left >= right) {
                break;
            } else {
                exch(a, left, right);
            }
        }
        exch(a, lo, right);
        return right;
    }

    /**
     * 判断v是否小于w
     * @param v
     * @param w
     * @return
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * 交换a数组中，索引i和索引j处的值
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
