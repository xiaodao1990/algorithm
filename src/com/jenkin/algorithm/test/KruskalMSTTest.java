package com.jenkin.algorithm.test;

import com.jenkin.algorithm.graph.Edge;
import com.jenkin.algorithm.graph.EdgeWeightedGraph;
import com.jenkin.algorithm.graph.KruskalMST;
import com.jenkin.algorithm.linear.Queue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class KruskalMSTTest {

    public static void main(String[] args) throws IOException {
        //创建输入流
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(new FileInputStream("min_create_tree_test.txt")));
        //读取城市数目，初始化Graph图
        int number = Integer.parseInt(reader.readLine());
        EdgeWeightedGraph G = new EdgeWeightedGraph(number);
        //读取已经修建好的道路数目
        int roadNumber = Integer.parseInt(reader.readLine());
        //循环读取已经修建好的道路，并调用addEdge方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int v = Integer.parseInt(line.split(" ")[0]);
            int w = Integer.parseInt(line.split(" ")[1]);
            double weight = Double.parseDouble(line.split(" ")[2]);
            G.addEdge(new Edge(v, w, weight));
        }

        KruskalMST mst = new KruskalMST(G);
        // 获取最小生成树的所有边
        Queue<Edge> edges = mst.edges();
        for (Edge edge : edges) {
            if (edge != null) {
                System.out.println(edge.either() + "-"+edge.other(edge.either())+"::"+edge.weight());
            }
        }
    }
}
