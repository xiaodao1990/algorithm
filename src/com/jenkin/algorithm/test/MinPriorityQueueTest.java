package com.jenkin.algorithm.test;

import com.jenkin.algorithm.priority.MinPriorityQueue;

public class MinPriorityQueueTest {

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MinPriorityQueue<String> minpq = new MinPriorityQueue<>(20);
        for (String s : arr) {
            minpq.insert(s);
        }
        System.out.println("------"+minpq.size());
        String del;
        while (!minpq.isEmpty()) {
            del = minpq.delMin();
            System.out.print(del + " ");
        }
    }
}
