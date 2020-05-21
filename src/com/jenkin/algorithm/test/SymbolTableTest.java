package com.jenkin.algorithm.test;

import com.jenkin.algorithm.symbol.SymbolTable;

public class SymbolTableTest {

    public static void main(String[] args) {
        SymbolTable<Integer, String> st = new SymbolTable<>();
        st.put(1, "张三");
        st.put(3, "李四");
        st.put(5, "王五");
        System.out.println(st.size());
        st.put(1,"老三");
        System.out.println(st.get(1));
        System.out.println(st.size());
        st.delete(1);
        System.out.println(st.size());
    }
}
