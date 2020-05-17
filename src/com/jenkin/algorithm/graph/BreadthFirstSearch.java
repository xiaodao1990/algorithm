package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Queue;

/**
 * 所谓广度优先搜索，指的是在搜索时，如果遇到一个结点既有子结点，又有兄弟结点，那么先找兄弟结点，
 * 然后再找子结点
 */
public class BreadthFirstSearch {

    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 记录有多少个顶点与s顶点相通
    private int count;
    // 用来存储带搜索邻接表的点
    private Queue waitSearch;

    public BreadthFirstSearch(Graph G, int s) {
        // 创建一个和图的顶点数大小一样的布尔数组
        marked = new boolean[G.V()];
        // 初始化待搜索顶点的队列
        waitSearch = new Queue<Integer>();
        // 搜索G图中与顶点s相通的所有顶点
        bfs(G, s);
    }

    /**
     * 使用广度优先搜索找出G图中v顶点的所有相邻顶点
     * @param G
     * @param v
     */
    private void bfs(Graph G, int v) {
        // 1、将当前结点标记为已搜索(已相通)
        marked[v] = true;
        // 2、将当前顶点v放入待搜索邻接表的点
        waitSearch.enqueue(v);// 0
        // 相通顶点数+1
        count++;
        // System.out.print(v+" ");
        while (!waitSearch.isEmpty()) {
            Integer wait = (Integer) waitSearch.dequeue();// 0
            for (Integer w : G.adj(wait)) {// 5 1 2 6
                if (!marked[w]) {
                    marked[w] = true;
                    waitSearch.enqueue(w);
                    count++;
                    // System.out.print(w+" ");
                }
            }
        }

    }

    /**
     * 判断w顶点与s顶点是否相通
     * @param w
     * @return
     */
    public boolean marked(int w) {
        return marked[w];
    }

    /**
     * 获取与顶点s相通的所有顶点的总数
     * @return
     */
    public int count() {
        return count;
    }

}
