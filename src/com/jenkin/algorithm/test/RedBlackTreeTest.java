package com.jenkin.algorithm.test;

import com.jenkin.algorithm.tree.RedBlackTree;

public class RedBlackTreeTest {

    public static void main(String[] args) {
        RedBlackTree<Integer, String> bt = new RedBlackTree<>();
        bt.put(4, "二哈");
        bt.put(1, "张三");
        bt.put(3, "李四");
        bt.put(5, "王五");
        System.out.println(bt.size());
        bt.put(1,"老三");
        System.out.println(bt.get(1));
        System.out.println(bt.size());
    }
}
