package com.jenkin.algorithm.test;

import com.jenkin.algorithm.priority.IndexMinPriorityQueue;

public class IndexMinPriorityQueueTest {

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        IndexMinPriorityQueue<String> indexMinPQ = new IndexMinPriorityQueue<>(20);
        // 插入
        for (int i = 0; i < arr.length; i++) {
            indexMinPQ.insert(i, arr[i]);
        }
        System.out.println(indexMinPQ.size());
        // 获取最小值的索引
        System.out.println(indexMinPQ.minIndex());

        //测试修改
        indexMinPQ.changeItem(0,"Z");
        int minIndex=-1;
        while(!indexMinPQ.isEmpty()){
            minIndex = indexMinPQ.delMin();
            System.out.print(minIndex+" ");
        }
    }
}
