package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Stack;


public class DepthFirstPaths {


    private boolean[] marked;

    private int s;

    private int[] edgeTo;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    /**
     * 使用深度优先搜索找出G图中v顶点的所有相邻顶点
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * 判断v顶点和s顶点是否存在路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 找出从起点s到顶点v的路径(就是该路径经过的顶点)
     * @param v
     * @return
     */
    public Stack pathTo(int v) {
        // 如果v顶点与s顶点不连通，则返回null，没有路径
        if (!hasPathTo(v)) {
            return null;
        }
        // 1、倒序获取顶点，添加到Stack中
        Stack<Integer> paths = new Stack<>();

        for (int w = v; w != s; w=edgeTo[w]) {
            paths.push(w);
        }

        paths.push(s);
        return paths;
    }
}
