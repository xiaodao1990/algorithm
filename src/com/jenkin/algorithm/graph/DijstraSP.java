package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Queue;
import com.jenkin.algorithm.priority.IndexMinPriorityQueue;

/**
 * 最短路径：
 *      在一幅加权有向图中，从顶点s到顶点t的最短路径是所有顶点s到顶点t的路径中总权重最小的那条路径。
 *
 * 性质：
 *      1、路径具有方向性。
 *      2、权重不一定等价于距离。权重可以是距离、时间、花费等内容，权重最小指的是成本最小
 *      3、只考虑连通图。
 *      4、最短路径不一定是唯一的。
 * 最短路径树：
 *      给定一幅加权有向图和一个顶点s，以顶点s为起点的一棵最短路径树是图的一幅子图，它包含顶点s以及从s
 *      可达的所有顶点。这颗有向树的根结点为s，树的每条路径都是有向图中的一条最短路径。
 *
 * 松弛技术：(多条路径比较最短路径)
 *      松弛这个词来源于生活：一条橡皮筋沿着两个顶点的某条路径紧紧展开，如果这两个顶点之间的路径不止一条，
 *      还存在有更短的路径，那么把皮筋转移到更短的路径上，皮筋就可以放松了。(结合pdf的图理解，黄色圈为橡皮筋。)
 *
 * 松弛这种简单的原理刚好可以用来计算最短路径树。
 *      在我们的API中，需要用到两个成员变量edgeTo和distTo，分别存储边和权重。一开始给定一幅图G和顶点S，我们
 *      只知道图的边以及这些边的权重，其他的一无所知，此时初始化顶点s到顶点s的最短路径的总权重distTo[s]=0;
 *      顶点s到其他顶点的总权重默认为无穷大，随着算法的执行，不断的使用松弛技术处理图的边和顶点，并按一定的
 *      条件更新edgeTo和distTo中的数据，最终就可以得到最短路径树。
 * 边的松弛v->w意味着检查从s到w的最短路径是否先从s到v，然后从v到w？
 *      如果是，则v—>w这条边需要加入到最短路径树中，更新edgeTo和distTo中的内容，edgeTo[w]=表示v->w这条边的
 *      DirectedEdge对象，distTo[w]=distTo[v]+v->w这条边的权重
 *      如果不是，则忽略v->w这条边
 * 顶点的松弛：
 *      顶点的松弛是基于边的松弛完成的，只需要把某个顶点指出的所有边松弛，那么该顶点就松弛完毕。例如要松弛顶点v，
 *      只需要遍历v的邻接表，把每一条边都松弛，那么顶点v就松弛了
 *
 */
public class DijstraSP {

    // 索引代表顶点，值表示从顶点s到当前顶点的最短路径上的最后一条边
    private DirectedEdge[] edgeTo;
    // 索引代表顶点，值表示从顶点s到当前顶点的最短路径上的总权重
    private double[] distTo;
    // 存放树中顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;

    public DijstraSP(EdgeWeightedDigraph G, int s) {
        // 创建一个和图的顶点数大小一样的DirectedEdge数组
        this.edgeTo = new DirectedEdge[G.V()];
        // 创建一个和图的顶点数大小一样的double数组，表示权重，并且初始化数组中的内容为无穷大，无穷大
        // 表示不存在这样的边
        this.distTo = new double[G.V()];
        for (int i = 0; i < distTo.length; i++) {
            distTo[i] = Double.POSITIVE_INFINITY;
        }
        // 创建一个和图的顶点大小一样的索引优先队列，存储有效的横切边
        this.pq = new IndexMinPriorityQueue<>(G.V());
        // 默认让顶点s进入到最短路径树中，但s顶点目前没有与树中其他顶点相连接，因此初始化distTo[s]=0.0
        distTo[s] = 0.0;
        pq.insert(s, 0.0);

        // 遍历有效边队列
        while (!pq.isEmpty()) {
            // 松弛图G中的顶点
            relax(G, pq.delMin());
        }

    }

    /**
     * 松弛图G中的顶点
     * @param G
     * @param v
     */
    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;

                if (pq.contains(w)) {
                    pq.changeItem(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    /**
     * 获取从顶点s到顶点v的最短路径上的总权重
     * @param v
     * @return
     */
    public double distTo(int v) {
        return distTo[v];
    }

    /**
     * 判断从顶点s到顶点v是否可达
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    /**
     * 查找从起点s到顶点v的最短路径中所有的边
     * @param v
     * @return
     */
    public Queue pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Queue<DirectedEdge> edges = new Queue<>();

        DirectedEdge e = null;
        while (true) {
            e = edgeTo[v];
            if (e == null) {
                break;
            }
            edges.enqueue(e);
            v = e.from();
        }
        return edges;
    }
}
