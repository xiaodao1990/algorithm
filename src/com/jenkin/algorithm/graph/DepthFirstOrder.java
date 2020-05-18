package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Stack;

/**
 * 基于深度优先的顶点排序
 * 在API设计中，我们添加了一个栈reversePost用来存储顶点，当我们深度搜索图时，每搜索完毕一个顶点，把
 * 该顶点放入到reversePost中，这样就可以实现顶点排序
 */
public class DepthFirstOrder {

    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 使用栈，存储顶点序列
    private Stack reversePost;

    public DepthFirstOrder(Digraph G) {
        this.marked = new boolean[G.V()];
        reversePost = new Stack();
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        // 当前顶点搜索完毕，让当前顶点如栈
        reversePost.push(v);
    }

    /**
     * 获取顶点线性序列
     * @return
     */
    public Stack reversePost() {
        return reversePost;
    }
}
