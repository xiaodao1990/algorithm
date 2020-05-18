package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Queue;

public class Digraph {

    // 记录顶点的数量
    private final int V;

    private int E;

    private Queue<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        // 初始化邻接表
        adj = new Queue[V];
        // 初始化邻接表中的空队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * 有向图
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].enqueue(w);
        E++;
    }

    public Queue<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        // 1、创建一个新的有向图
        Digraph r = new Digraph(V);
        // 2、遍历原图中的v顶点对应的邻接表，原图中的边为v->w，则反向图中的边为w->v
        for (int v = 0; v < V; v++) {
            for (Integer w : adj[v]) {
                r.addEdge(w, v);
            }
        }
        return r;
    }
}
