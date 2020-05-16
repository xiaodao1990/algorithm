package com.jenkin.algorithm.uf;

/**
 * 并查集最好的理解：https://www.cnblogs.com/noKing/p/8018609.html
 * 并查集是一种数据结构，常用于描述集合。
 * 经常用于解决此类问题：某个元素是否属于某个集合，或者某个元素和另一个元素
 * 是否属于同一个集合。
 *
 */
public class UF_Tree {

    private int[] eleAndGroup;

    private int count;

    /**
     * 先初始化一个数组。初始化数组内的值和数组的下标一致。即每个数字都自成一个小组。
     * 0属于第0个小组(集合)，1属于第1个小组(集合)，2属于第2个小组(集合)，
     *
     * @param N
     */
    public UF_Tree(int N) {
        this.count = N;
        eleAndGroup = new int[N];
        // 此处数组内存放的是自己大哥，如果需要直到自己的小组号(集合)，需要不断的往上找
        for (int i = 0; i < eleAndGroup.length; i++) {
            eleAndGroup[i] = i;
        }
    }

    /**
     * 获取当前并查集中的数据有多少个分组
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * 判断元素p和元素q是否在同一个集合中
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    /**
     * 查找元素属于哪个集合
     * 由于现在数组中存放的是自己"大哥"的编号，所以为了找到最终的大哥要不停
     * 的往上找，直到找到哪个自己是自己的大哥的元素，即为最终的大哥
     * @param p
     * @return
     */
    public int find(int p) {
        while (p != eleAndGroup[p]) {
            p = eleAndGroup[p];
        }
        return p;
    }

    /**
     * 合并两个元素所在的集合，也就是连接两个元素
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        int pGroup = find(p);
        int qGroup = find(q);

        // 如果p和q已经在同一个分组中，则无需合并
        if (pGroup == qGroup) {
            return;
        }

        eleAndGroup[pGroup] = qGroup;
        count--;
    }

    public void printUF() {
        for (int i = 0; i < eleAndGroup.length; i++) {
            System.out.print(eleAndGroup[i] + " ");
        }
        System.out.println();
    }
}
