package com.jenkin.algorithm.test;

import com.jenkin.algorithm.sort.Selection;

import java.util.Arrays;

public class SelectionTest {

    public static void main(String[] args) {
        Comparable[] a = {4, 6, 8, 7, 9, 2, 10, 1};
        Selection.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
