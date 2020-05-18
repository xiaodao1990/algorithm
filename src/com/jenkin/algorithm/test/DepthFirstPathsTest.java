package com.jenkin.algorithm.test;

import com.jenkin.algorithm.graph.DepthFirstPaths;
import com.jenkin.algorithm.graph.Graph;
import com.jenkin.algorithm.linear.Stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepthFirstPathsTest {

    public static void main(String[] args) throws IOException {
        //创建输入流
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(new FileInputStream("road_find.txt")));
        //读取城市数目，初始化Graph图
        int number = Integer.parseInt(reader.readLine());
        Graph G = new Graph(number);
        //读取已经修建好的道路数目
        int roadNumber = Integer.parseInt(reader.readLine());
        //循环读取已经修建好的道路，并调用addEdge方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            G.addEdge(p, q);
        }

        // 根据图G和顶点0路径查找对象
        DepthFirstPaths paths = new DepthFirstPaths(G, 0);//

        Stack path = paths.pathTo(4);
        StringBuilder sb = new StringBuilder();
        while (!path.isEmpty()) {
            sb.append(path.pop()+"-");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
