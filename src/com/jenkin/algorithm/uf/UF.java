package com.jenkin.algorithm.uf;

/**
 * 并查集是一种树型的数据结构，并查集可以高效地进行如下操作：
 * 1、查询元素p和元素q是否属于同一组
 * 2、合并元素p和元素q所在的组
 *
 * 并查集的结构：
 * 1、每个元素都唯一的对应一个结点
 * 2、每一组数据中的多个元素都在同一颗树中
 * 3、一个组中的数据对应的树和另一个组中的数据对应的树之间没有任何联系
 * 4、元素在树中并没有子父级关系的硬性要求
 */
public class UF {

    // 记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    // 记录并查集中数据的分组个数
    private int count;

    /**
     * 1、初始情况下，每个元素都在一个独立的分组中，所以，在初始情况下，并查集默认分为N个组
     * 2、初始化数组eleAndGroup
     * 3、把eleAndGroup数组的索引看做是每个结点存储的元素，把eleAndGroup数组每个索引处的值
     * 看做是该结点所在的分组，，那么初始化情况下，i索引存储的值就是i
     * @param N
     */
    public UF(int N) {
        this.count = N;
        // 索引看做是每个结点存储的元素，索引处的值看做是该结点所在的分组
        this.eleAndGroup = new int[N];
        // 此处数组内存放的是自己所在的小组号(集合)
        for (int i = 0; i < N; i++) {
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
     * 判断并查集中元素p和元素q是否在同一分组中
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 元素p所在分组的标识符号
     * @param p
     * @return
     */
    public int find(int p) {
        return eleAndGroup[p];
    }

    /**
     * 把p元素所在分组和q元素所在分组合并
     * @param p
     * @param q
     */
    public void union(int p, int q) {
        // 如果p和q不在同一个分组，则只需要将p元素所在分组的所有元素的标识符修改为元素q所在组的标识符即可
        int pGroup = find(p);
        int qGroup = find(q);

        // 如果p和q已经在同一个分组中，则无需合并
        if (pGroup == qGroup) {
            return;
        }

        for (int i = 0; i < eleAndGroup.length; i++) {
            if (eleAndGroup[i] == pGroup) {
                eleAndGroup[i] = qGroup;
            }
        }
        count--;
    }

    public void printUF() {
        for (int i = 0; i < eleAndGroup.length; i++) {
            System.out.print(eleAndGroup[i] + " ");
        }
        System.out.println();
    }
}
