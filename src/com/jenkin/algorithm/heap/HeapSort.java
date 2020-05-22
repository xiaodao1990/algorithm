package com.jenkin.algorithm.heap;

/**
 * String[] arr = {"S","O","R","T","E","X","A","M","P","L","E"}
 * 1、构造堆
 * 2、得到堆顶元素，这个值就是最大值
 * 3、交换堆顶元素和数组中最后一个元素，此时所有元素的最大元素已经放到合适的位置
 * 4、对堆进行调整，重新让除了最后一个元素的剩余元素中的最大值放到堆顶
 * 5、重复2～4步骤，直到堆中剩一个元素为止
 */
public class HeapSort {

    public static void sort(Comparable[] source) {
        // 1、构造堆
        Comparable[] heap = new Comparable[source.length + 1];
        createHeap(source, heap);
        // 2、2，3，4步骤
        int N = heap.length - 1;
        while (N != 1) {
            exch(heap, 1, N);
            sink(heap, 1, --N);
        }
        // 5、将heap中的已排好序的元素复制回source中
        System.arraycopy(heap, 1, source, 0, source.length);
    }

    private static void createHeap(Comparable[] source, Comparable[] heap) {
        // 1、将source元素copy到堆中
        System.arraycopy(source, 0, heap, 1, source.length);

        // 2、对堆进行排序，由于堆的父结点要大于两个子结点，下层是跟2*k和2*k+1中的较大者进行比较，所以从
        // 数组的一半开始倒序遍历，对每一个元素进行下层操作
        for (int i = (heap.length-1) / 2; i > 0; i--) {
            sink(heap, i, heap.length - 1);
        }
    }

    private static void sink(Comparable[] heap, int target, int range) {
        while (2 * target <= range) {
            int maxIndex = 2 * target;
            if (2 * target + 1 <= range && less(heap, 2 * target, 2 * target + 1)) {
                maxIndex = 2 * target + 1;
            }

            if (less(heap, maxIndex, target)) {
                break;
            }

            exch(heap, target, maxIndex);
            target = maxIndex;
        }
    }

    private static boolean less(Comparable[] heap, int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private static void exch(Comparable[] heap, int i, int j) {
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
