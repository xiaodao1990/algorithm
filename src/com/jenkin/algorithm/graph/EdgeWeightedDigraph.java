package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Queue;

/**
 * 加权有向图
 */
public class EdgeWeightedDigraph {

    // 记录顶点的数量
    private final int V;

    private int E;

    private Queue<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        // 初始化邻接表
        this.adj = new Queue[V];
        // 初始化邻接表的空队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<DirectedEdge>();
        }
    }

    /**
     * 获取图中顶点的数量
     * @return
     */
    public int V() {
        return V;
    }

    /**
     * 获取图中边的数量
     * @return
     */
    public int E() {
        return E;
    }

    /**
     * 向加权有向图中添加一条边
     * @param e
     */
    public void addEdge(DirectedEdge e) {
        // 由于边是有向的，因此只会添加到起点的邻接表
        int v = e.from();
        adj[v].enqueue(e);
        E++;
    }

    /**
     * 获取由顶点v指出的所有边
     * @param v
     * @return
     */
    public Queue<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /**
     * 获取加权有向图的所有边
     * @return
     */
    public Queue edges() {
        Queue<DirectedEdge> allEdge = new Queue<>();
        // 遍历顶点，拿到每个顶点的邻接表
        for (int i = 0; i < adj.length; i++) {
            // 遍历邻接表，拿到邻接表中的每条边存储到队列中
            for (DirectedEdge e : adj[i]) {
                allEdge.enqueue(e);
            }
        }
        return allEdge;
    }
}
