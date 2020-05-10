package com.jenkin.algorithm.test;

import com.jenkin.algorithm.sort.Insertion;
import com.jenkin.algorithm.sort.Shell;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SortCompare {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        // 读取reverse_arr.txt文件
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("reverse_arr.txt")));
        String line = null;
        while((line = reader.readLine()) != null) {
            list.add(Integer.valueOf(line));
        }
        reader.close();

        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
//        testInsertion(arr);// 34944ms
        testShell(arr);// 49ms

    }

    private static void testInsertion(Integer[] arr) {
        long start = System.currentTimeMillis();
        Insertion.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("使用插入排序耗时："+(end - start));
    }

    private static void testShell(Integer[] arr) {
        long start = System.currentTimeMillis();
        Shell.sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("使用希尔排序耗时："+(end - start));
    }
}
