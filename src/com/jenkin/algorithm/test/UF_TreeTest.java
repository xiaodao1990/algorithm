package com.jenkin.algorithm.test;

import com.jenkin.algorithm.uf.UF_Tree;

public class UF_TreeTest {

    public static void main(String[] args) {
        UF_Tree ufTree = new UF_Tree(10);
        ufTree.printUF();

        System.out.println("连接了5，6");
        ufTree.union(5, 6);
        ufTree.printUF();

        System.out.println("连接了1，2");
        ufTree.union(1, 2);
        ufTree.printUF();

        System.out.println("连接了2，3");
        ufTree.union(2, 3);
        ufTree.printUF();

        System.out.println("连接了1，4");
        ufTree.union(1, 4);
        ufTree.printUF();

        System.out.println("连接了1，5");
        ufTree.union(1, 5);
        ufTree.printUF();

        System.out.println("1  6 是否连接：" + ufTree.connected(1, 6));
        System.out.println("1  8 是否连接：" + ufTree.connected(1, 8));
    }
}
