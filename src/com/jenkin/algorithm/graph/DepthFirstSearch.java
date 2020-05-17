package com.jenkin.algorithm.graph;

/**
 * 有关图的搜索，最经典的算法有深度优先搜索和广度优先搜索
 * 所谓深度优先搜索，指的是在搜索时，如果遇到一个结点既有子结点，又有兄弟结点，那么先找子结点，然后找兄弟结点。
 */
public class DepthFirstSearch {

    // 索引代表顶点，值表示当前顶点是否被搜索过
    private boolean[] marked;
    // 记录有多少顶点与s顶点相通
    private int count;

    /**
     * 构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相通顶点
     * @param G
     * @param s
     */
    public DepthFirstSearch(Graph G, int s) {
        // 创建一个和图的顶点数大小一样的布尔数组
        this.marked = new boolean[G.V()];
        // 搜索G图中与顶点s相通的所有顶点
        dfs(G, s);
    }

    /**
     * 使用深度优先搜索找出G图中v顶点的所有相通的顶点
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        // 1、将当前结点标记为已搜索(已相通)
        marked[v] = true;
        // 2、遍历v顶点的邻接表，得到每一个顶点
        for (Integer w : G.adj(v)) {
            // 3、如果当前顶点没有被搜索过，则递归搜索与w顶点相通的其他顶点
            if (!marked[w]) {
                // System.out.print(w+" ");
                dfs(G, w);
            }
        }
        // 4、相通的顶点数量+1
        count++;
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
