package com.jenkin.algorithm.graph;

/**
 * 加权有向图边
 */
public class DirectedEdge {

    // 起点
    private final int v;
    // 终点
    private final int w;
    // 当前边的权重
    private final double weight;

    /**
     * 通过顶点v和w，以及权重weight值构造一个边对象
     * @param v
     * @param w
     * @param weight
     */
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边的权重值
     * @return
     */
    public double weight() {
        return weight;
    }

    /**
     * 获取有向边的起点
     * @return
     */
    public int from() {
        return v;
    }

    /**
     * 获取有向边的终点
     * @return
     */
    public int to() {
        return w;
    }
}
