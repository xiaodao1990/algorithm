package com.jenkin.algorithm.test;

import com.jenkin.algorithm.graph.*;
import com.jenkin.algorithm.linear.Queue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DijstraSPTest {

    public static void main(String[] args) throws IOException {
        //创建输入流
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(new FileInputStream("min_route_test.txt")));
        //读取顶点的数目，初始化EdgeWeightDigraph图
        int number = Integer.parseInt(reader.readLine());
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(number);
        //读取边的数目
        int edgeNumber = Integer.parseInt(reader.readLine());
        //循环读取已经修建好的道路，并调用addEdge方法
        for (int i = 0; i < edgeNumber; i++) {
            String line = reader.readLine();
            int v = Integer.parseInt(line.split(" ")[0]);
            int w = Integer.parseInt(line.split(" ")[1]);
            double weight = Double.parseDouble(line.split(" ")[2]);
            G.addEdge(new DirectedEdge(v, w, weight));
        }

        DijstraSP sdp = new DijstraSP(G, 0);
        Queue<DirectedEdge> edges = sdp.pathTo(6);
        for (DirectedEdge edge : edges) {
            System.out.println(edge.from() + "->" + edge.to() + "::" + edge.weight());
        }
    }
}
