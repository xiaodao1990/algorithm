package com.jenkin.algorithm.test;

import com.jenkin.algorithm.heap.Heap;

public class HeapTest {

    public static void main(String[] args) {
        Heap<String> heap = new Heap<String>(20);
        heap.insert("S");
        heap.insert("G");
        heap.insert("I");
        heap.insert("E");
        heap.insert("N");
        heap.insert("H");
        heap.insert("O");
        heap.insert("A");
        heap.insert("T");
        heap.insert("P");
        heap.insert("R");

        StringBuilder sb = new StringBuilder();
        String max;
        while ((max = heap.delMax()) != null) {
            sb.append(max+"-->");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
