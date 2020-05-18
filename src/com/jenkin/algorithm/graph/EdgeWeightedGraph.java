package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Queue;

public class EdgeWeightedGraph {

    private final int V;

    private int E;

    private Queue[] adj;

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Edge>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(Edge e) {
        int v = e.either();
        int w = e.other(v);

        adj[v].enqueue(e);
        adj[w].enqueue(e);

        E++;
    }

    public Queue<Edge> adj(int v) {
        return adj[v];
    }

    public Queue<Edge> edges() {
        Queue<Edge> edges = new Queue<>();

        for (int v = 0; v < adj.length; v++) {
            for (Edge edge : adj(v)) {
                // 由于无向图中，每条边对象都会在两个邻接表中各出现一次，为了不重复获取，暂定一条规则，如果
                // w<v才添加，这样就保证同一条边只会被添加一次。
                int w = edge.other(v);
                if (w < v) {
                    edges.enqueue(edge);
                }
            }
        }
        return edges;
    }
}
