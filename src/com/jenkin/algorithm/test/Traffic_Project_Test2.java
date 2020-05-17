package com.jenkin.algorithm.test;

import com.jenkin.algorithm.graph.BreadthFirstSearch;
import com.jenkin.algorithm.graph.DepthFirstSearch;
import com.jenkin.algorithm.graph.Graph;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1、创建一个图Graph对象，表示城市。
 * 2、分别调用addEdge(0,1),addEdge(6,9),addEdge(3,8),addEdge(5,11),addEdge(2,12),addEdge(6,10),addEdge(4,8)，表示已
 * 经修建好的道路把对应的城市连接起来；
 * 3、通过Graph对象和顶点9，构建BreadthFirstSearch或者DepthFirstSearch对象
 * 4、调用搜索对象的marked(10)方法和marked(8)方法，即可得到9和城市与10号城市以及9号城市与8号城市是否相
 * 通。
 */
public class Traffic_Project_Test2 {

    public static void main(String[] args) throws IOException {
        //创建输入流
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(new FileInputStream("traffic_project.txt")));
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

//        BreadthFirstSearch search = new BreadthFirstSearch(G, 9);
        DepthFirstSearch search = new DepthFirstSearch(G, 9);
        System.out.println("9号城市和10号城市是否已相通：" + search.marked(10));
        System.out.println("9号城市和8号城市是否已相通：" + search.marked(8));
    }
}
