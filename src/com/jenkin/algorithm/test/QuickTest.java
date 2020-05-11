package com.jenkin.algorithm.test;

import com.jenkin.algorithm.sort.Quick;

import java.util.Arrays;

public class QuickTest {

    public static void main(String[] args) {
        Comparable[] a = {6, 1, 2, 7, 9, 3, 4, 5, 8};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
