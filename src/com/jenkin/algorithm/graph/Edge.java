package com.jenkin.algorithm.graph;

/**
 * 加权无向图是一种为每条边关联一个权重值或是成本的图模型。
 */
public class Edge implements Comparable<Edge> {

    private final int v;//顶点1
    private final int w;//顶点2
    private final double weight;//当前边的权重

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边的权重
     * @return
     */
    public double weight() {
        return weight;
    }

    /**
     * 获取边上的一个点
     * @return
     */
    public int either() {
        return v;
    }

    /**
     * 获取边上除了顶点vertex之外的另外一个顶点
     * @param vertex
     * @return
     */
    public int other(int vertex) {
        // 如果传入的顶点vertex是v，则返回另外一个顶点w
        if (vertex == v) {
            return w;
            // 如果传入的顶点vertex不是v，则返回v即可
        } else {
            return v;
        }
    }



    /**
     * 比较当前边和参数
     * @param e
     * @return
     */
    @Override
    public int compareTo(Edge e) {
        int cmp;
        if (this.weight > e.weight) {
            cmp = 1;
        } else if (this.weight < e.weight) {
            cmp = -1;
        } else {
            cmp = 0;
        }
        return cmp;
    }
}
