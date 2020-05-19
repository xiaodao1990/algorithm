package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Queue;
import com.jenkin.algorithm.priority.IndexMinPriorityQueue;

/**
 * Prim算法的切分规则：
 * 把最小生成树中的顶点看做是一个集合，把不在最小生成树中的顶点看做是另外一个集合。
 *
 * Prim算法将图中的顶点切分称两个集合，最小生成树顶点和非最小生成树顶点，通过不断的重复做某些操作，可以
 * 逐渐将非最小生成树中的顶点加入到最小生成树中，直到所有顶点都加入到最小生成树中。
 */
public class PrimMST {

    // 索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private Edge[] edgeTo;
    // 索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
    private double[] distTo;
    // 索引代表顶点，如果当前顶点已经在树中，则值为true，否则为false。
    private boolean[] marked;
    // 存放树中顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;

    public PrimMST(EdgeWeightedGraph G) {
        // 创建一个和图的顶点数大小一样的Edge数组，表示边
        this.edgeTo = new Edge[G.V()];
        // 创建一个和图的顶点大小一样的double数组，表示权重，并且初始化数组中内容为无穷大，无穷大即表示不存在这样的边
        this.distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        // 创建一个和图的顶点大小一样的boolean数组，表示当前顶点是否已经在树中
        this.marked = new boolean[G.V()];
        // 创建一个和图的顶点大小一样的索引优先队列，存储有效横切边
        this.pq = new IndexMinPriorityQueue(G.V());

        // 默认让顶点0进入树中，但0顶点目前没有与树中其他顶点相连接，因此初始化distTo[0]=0.0
        distTo[0] = 0.0;
        // 使用顶点0和权重0初始化pq
        pq.insert(0, 0.0);
        // 遍历有效边队列
        while (!pq.isEmpty()) {
            visit(G, pq.delMin());
        }
    }

    /**
     * 将顶点v添加到最小生成树中，并且更新数据
     * @param G
     * @param v
     */
    private void visit(EdgeWeightedGraph G, int v) {
        // 当前顶点已经在最小生成树中
        marked[v] = true;
        // 获取顶点v的邻接表，得到每一条边Edge
        for (Edge e : G.adj(v)) {
            // 获取Edge的另一条边
            int w = e.other(v);

            // 检测是否已经在树中，如果在，则继续下一个循环，如果不再，则需要修正当前顶点距离最小
            // 生成树的最小边edge[w]以及它的权重distTo[w],还有有效横切边也需要修正
            if (marked[w]) {
                continue;
            }

            // 如果当前边v-w权重比目前distTo[w]权重小(其中v属于最小生成树)，则需要修正数据。
            if (e.weight() < distTo[w]) {
                // 保存当前顶点到最小生成树的最小权重和最短边
                distTo[w] = e.weight();
                edgeTo[w] = e;

                if (pq.contains(w)) {
                    pq.changeItem(w, e.weight());
                } else {
                    pq.insert(w, e.weight());
                }
            }
        }

    }

    /**
     * 获取最小生成树的所有边
     * @return
     */
    public Queue edges() {
        // 创建队列
        Queue<Edge> edges = new Queue<>();
        // 遍历edgeTo数组，找到每一条边，添加到队列中
        for (int i = 0; i < marked.length; i++) {
            if (edgeTo[i] != null) {
                edges.enqueue(edgeTo[i]);
            }
        }
        return edges;
    }
}
