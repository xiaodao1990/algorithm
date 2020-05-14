package com.jenkin.algorithm.test;

import com.jenkin.algorithm.priority.MaxPriorityQueue;

public class MaxPriorityQueueTest {

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MaxPriorityQueue<String> maxpq = new MaxPriorityQueue<>(20);
        for (String s : arr) {
            maxpq.insert(s);
        }

        System.out.println("------"+maxpq.size());
        String del;
        while (!maxpq.isEmpty()) {
            del = maxpq.delMax();
            System.out.print(del+" ");
        }
    }
}
