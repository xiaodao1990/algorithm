package com.jenkin.algorithm.graph;

import com.jenkin.algorithm.linear.Stack;

/**
 * 前面我们已经实现了环的检测及顶点排序，那么拓扑排序就简单了，基于一幅图，先检测有没有环，如果没有环，则调用
 * 顶点排序即可。
 */
public class TopoLogical {

    // 顶点的拓扑排序
    private Stack<Integer> order;

    public TopoLogical(Digraph G) {
        // 创建检测环对象，检测图G中是否有环
        DirectedCycle dCycle = new DirectedCycle(G);
        if (!dCycle.hasCycle()) {
            // 如果没有环，创建顶点排序对象，进行顶点排序
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    /**
     * 判断图G中是否有环
     * @return
     */
    private boolean isCycle() {
        return order == null;
    }

    /**
     * 获取拓扑排序的所有顶点
     * @return
     */
    public Stack<Integer> order() {
        return order;
    }
}
