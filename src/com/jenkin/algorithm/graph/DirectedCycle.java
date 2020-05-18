package com.jenkin.algorithm.graph;

/**
 * 拓扑排序：给定一幅有向图，将所有的顶点排序，使得所有的有向边均从排在前面的元素指向排在后面的元素，此时
 * 就可以明确的表示出每个顶点的优先级。
 *
 * 检测有向图中的环
 *
 * 如果我们要使用拓扑排序解决优先级的问题，首先得保证图中没有环的存在
 *
 * 在API中添加onStack[]数组，索引为图的顶点，在我们深度搜索时，
 * 1、如果当前顶点正在搜索，则把对应的onStack数组的值改为true，标识进栈。
 * 2、如果当前顶点搜索完毕，则把对应的onStack数组中的值修改为false，标识出栈
 * 3、如果即将要搜索某个顶点，但该顶点已经在栈中，则图中有环
 */
public class DirectedCycle {

    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 记录图中是否有环
    private boolean hasCycle;
    // 索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在搜索的有向路径上
    private boolean[] onStack;


    public DirectedCycle(Digraph G) {
        this.marked = new boolean[G.V()];
        this.onStack = new boolean[G.V()];
        this.hasCycle = false;

        // 由于无法清楚G图是否是连通图，所以需要遍历每个顶点进行深度搜索来判断G图是否有环
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
    }

    /**
     * 基于深度优先搜索，检测图G中是否有环
     * @param G
     * @param v
     *
     *
     */
    private void dfs(Digraph G, int v) {
        // 将当前顶点标记为已搜索
        marked[v] = true;
        // 让当前顶点进栈
        onStack[v] = true;
        // 遍历v顶点的邻接表，得到每一个顶点w
        for (Integer w : G.adj(v)) {
            // 如果当顶点w没有被搜索过，则递归搜索与w顶点相通的其他顶点
            if (!marked[w]) {
                dfs(G, w);
            }
            // 如果顶点w已经被搜索过，则查看顶点w是否在栈中，如果在，则证明图中有环，修改hasCycle标记，结束循环
            if (onStack[w]) {
                hasCycle = true;
                break;
            }
        }
        // 当前顶点已经搜索完毕，让当前顶点出栈
        onStack[v] = false;
    }

    /**
     * 判断图中是否又换
     * @return
     */
    public boolean hasCycle() {
        return hasCycle;
    }
}
