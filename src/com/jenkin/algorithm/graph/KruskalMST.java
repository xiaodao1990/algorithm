package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Queue;
import com.jenkin.algorithm.priority.MinPriorityQueue;
import com.jenkin.algorithm.uf.UF_Tree_Height;

/**
 * Kruskal算法思想是按照边的权重(从小到大)处理它们，将边加入最小生成树中，加入的边不会与已经加入最小
 * 生成树的边构成环，直到树中含有V-1条边为止
 */
public class KruskalMST {

    // 保存最小生成树的所有边
    private Queue<Edge> mst;
    // 索引代表顶点，使用uf.connect(v,w)可以判断顶点v和顶点w是否在同一颗树中，使用uf.union(v,w)可以
    // 把顶点v所在的树和顶点w所在的树合并
    private UF_Tree_Height uf;
    // 存储图中所有的边，使用最小优先队列，对边按照权重进行排序
    private MinPriorityQueue<Edge> pq;

    public KruskalMST(EdgeWeightedGraph G) {
        this.mst = new Queue<>();
        this.uf = new UF_Tree_Height(G.V());
        // 最小优先队列中存储的是图中的边，而最小优先队列是基于堆实现的，实现堆的时候将0索引处废弃了，所以此处的需要+1才能存储所有的边
        this.pq = new MinPriorityQueue<>(G.E()+1);
        for (Edge e : G.edges()) {
            pq.insert(e);
        }

        // 遍历pq队列，拿到最小权重的边，进行处理
        while (!pq.isEmpty() && mst.size()<G.V()-1) {
            // 获取最小权重的边
            Edge e = pq.delMin();
            // 获取边的两个顶点
            int v = e.either();
            int w = e.other(v);

            // 判断两个顶点是否连通
            // 如果连通，则证明这两个顶点在同一颗树中，那么就不能再把这条边添加到最小生成树中，因为一棵树的任意两个顶点上添加一条边，都会形成环
            // 而最小生成树又不能有环的存在。
            // 如果不连通，则通过uf.connect(v, w)把顶点v所在的树和顶点w所在的树合并成一棵树，并把这条边加入到mst队列中
            if (uf.connected(v, w)) {
                continue;
            }

            uf.union(v, w);
            mst.enqueue(e);
        }
    }

    /**
     * 获取最小生成树的所有边
     * @return
     */
    public Queue<Edge> edges() {
        return mst;
    }
}
