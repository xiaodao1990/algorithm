package com.jenkin.algorithm.test;

import com.jenkin.algorithm.sort.Insertion;

import java.util.Arrays;

public class InsertionTest {

    public static void main(String[] args) {
        Comparable[] a = {4, 3, 2, 10, 12, 1, 5, 6};
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
