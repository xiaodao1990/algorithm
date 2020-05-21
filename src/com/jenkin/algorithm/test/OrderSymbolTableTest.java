package com.jenkin.algorithm.test;

import com.jenkin.algorithm.symbol.OrderSymbolTable;

public class OrderSymbolTableTest {

    public static void main(String[] args) {
        OrderSymbolTable<Integer, String> bt = new OrderSymbolTable<>();
        bt.put(4, "二哈");
        bt.put(3, "张三");
        bt.put(1, "李四");
        bt.put(1, "aa");
        bt.put(5, "王五");
    }
}
