package com.jenkin.algorithm.test;

import com.jenkin.algorithm.uf.UF_Tree_Height;

public class UF_Tree_HeightTest {

    public static void main(String[] args) {
        UF_Tree_Height union = new UF_Tree_Height(10);

        System.out.println("初始eleAndGroup：");
        union.printArr(union.eleAndGroup);
        System.out.println("初始height：");
        union.printArr(union.height);

        System.out.println("连接了5 6 之后的eleAndGroup：");
        union.union(5, 6);
        union.printArr(union.eleAndGroup);
        System.out.println("连接了5 6 之后的height：");
        union.printArr(union.height);

        System.out.println("连接了1 2 之后的eleAndGroup：");
        union.union(1, 2);
        union.printArr(union.eleAndGroup);
        System.out.println("连接了1 2 之后的height：");
        union.printArr(union.height);

        System.out.println("连接了2 3 之后的eleAndGroup：");
        union.union(2, 3);
        union.printArr(union.eleAndGroup);
        System.out.println("连接了2 3 之后的height：");
        union.printArr(union.height);

        System.out.println("连接了1 4 之后的eleAndGroup：");
        union.union(1, 4);
        union.printArr(union.eleAndGroup);
        System.out.println("连接了1 4 之后的height：");
        union.printArr(union.height);

        System.out.println("连接了1 5 之后的eleAndGroup：");
        union.union(1, 5);
        union.printArr(union.eleAndGroup);
        System.out.println("连接了1 5 之后的height：");
        union.printArr(union.height);

        System.out.println("1  6 是否连接：" + union.connected(1, 6));

        System.out.println("1  8 是否连接：" + union.connected(1, 8));
    }
}
