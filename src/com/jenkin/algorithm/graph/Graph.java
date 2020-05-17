package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Queue;

/**
 * 图是由一组顶点和一组能够将两个顶点相连的边组成的。
 *
 * 特殊的图:
 *      1、自环：即一条连接一个顶点和其自身的边。
 *      2、平行边：连接同一对顶点的两条边
 *
 * 图的分类：
 *      按照连接两个顶点的边的不同，可以把图分为以下两种：
 *      无向图：边仅仅连接两个顶点，没有其他含义。
 *      有向图：边不仅连接两个顶点，并且具有方向。
 * 无向图:
 *      相邻顶点：
 *          当两个顶点通过一条边相连时，我们称这两个顶点是相邻的，并且称这条边依附于这两个顶点。
 *      度：
 *          某个顶点的度就是依附于该顶点的边的个数。
 *      子图：
 *          一幅图的子集组成的图(包含这些依附的顶点)
 *      路径：
 *          是由边顺序连接的一系列顶点组成。
 *      环：
 *          是一条至少有一条边且起点和终点相同的路径。
 *      连通图：
 *          如果图中任意一个顶点都存在一条路径到达另外一个顶点，那么这幅图就称之为连通图。
 *      连通子图；
 *          一个非连通图由若干连通部分组成，每一个连通的部分都可以称为该图的连通子图。
 *
 * 图的存储结构：
 *      要想清晰的表示一幅图，需要清楚的表示以下两部分：
 *      1、图中所有的顶点。
 *      2、所有连接顶点的边。
 *      常见的图的存储结构有两种：邻接矩阵和邻接表
 * 邻接矩阵：
 *      1、使用一个V*V的二维数组int[V][V] adj,把索引的值看做顶点。
 *      2、如果顶点v和顶点w相连，我们只需要将adj[v][w]和adj[w][v]的值设置为1，否则设置为0即可。
 * 邻接矩阵这种存储方式的空间复杂度是V^2的，如果我们处理的问题规模比较大的话，内存空间极有可能不够用。
 *
 * 邻接表：
 *      1、使用一个大小为V的数组Queue[V] adj，把索引看做是顶点。
 *      2、每个索引处adj[v]都存储一个队列，该队列中存储的是所有与该顶点相邻的其他顶点。
 */
public class Graph {

    // 记录顶点数量
    private final int V;
    // 记录边的数量
    private int E;
    // 邻接表
    private Queue<Integer>[] adj;

    public Graph(int V) {
        // 初始化顶点数量
        this.V = V;
        // 初始化边的数量
        this.E = 0;
        // 初始化邻接表
        adj = new Queue[V];
        // 初始化邻接表中的空队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<>();
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
     * 向图中添加一条边x-w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        // 将w添加的v的链表中
        adj[v].enqueue(w);
        // 将v添加到w的链表中
        adj[w].enqueue(v);
        E++;
    }

    /**
     * 获取和顶点v相邻的所有顶点
     * @param v
     * @return
     */
    public Queue<Integer> adj(int v) {
        return adj[v];
    }
}
