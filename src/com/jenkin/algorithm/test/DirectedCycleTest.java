package com.jenkin.algorithm.test;

import com.jenkin.algorithm.graph.Digraph;
import com.jenkin.algorithm.graph.DirectedCycle;
import com.jenkin.algorithm.graph.Graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class DirectedCycleTest {

    public static void main(String[] args) throws Exception {
        //创建输入流
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(new FileInputStream("cycle_test.txt")));
        //读取城市数目，初始化Graph图
        int number = Integer.parseInt(reader.readLine());
        Digraph G = new Digraph(number);
        //读取已经修建好的道路数目
        int roadNumber = Integer.parseInt(reader.readLine());
        //循环读取已经修建好的道路，并调用addEdge方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            G.addEdge(p, q);
        }

        DirectedCycle cycle = new DirectedCycle(G);
        System.out.println(cycle.hasCycle());
    }
}
