package com.jenkin.algorithm.test;

import com.jenkin.algorithm.graph.BreadthFirstSearch;
import com.jenkin.algorithm.graph.Graph;

public class BreadthFirstSearchTest {

    public static void main(String[] args) {
        Graph graph = new Graph(13);

        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);

        graph.addEdge(5, 3);

        graph.addEdge(5, 4);

        graph.addEdge(3, 4);

        graph.addEdge(4, 6);

        graph.addEdge(7, 8);

        graph.addEdge(9, 11);
        graph.addEdge(9, 10);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);
        System.out.println("--------构造图完成-------");

        BreadthFirstSearch search = new BreadthFirstSearch(graph, 0);// 0 5 3 4 6 1 2

        //测试与某个顶点相通的顶点数量
        int count = search.count();
        System.out.println("与起点0相通的顶点的数量为:"+count);


        //测试某个顶点与起点是否相同
        boolean marked1 = search.marked(5);
        System.out.println("顶点5和顶点0是否相通："+marked1);


        boolean marked2 = search.marked(7);
        System.out.println("顶点7和顶点0是否相通："+marked2);

    }
}
