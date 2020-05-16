package com.jenkin.algorithm.tree;

/**
 * 红黑树主要是对2-3树进行编码，红黑树背后的基本思想是用标准的二叉查找树（完全由2-结点构成）和一些额外的信息（替换3-结点）来
 * 表示2-3结点，我们将树中的链接分为两种类型：
 *  红链接：将两个2-结点连接起来构成3-结点
 *  黑链接：则是2-3树中的普通链接
 *
 * 确切的说，我们将3-结点表示为由一条左斜的红色链接（两个2-结点其中之一是另一个的左子结点）相连的两个2-结点。这种表示法的一个
 * 优点是，我们无需修改就可以直接使用标准的二叉查找树的get方法。
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {
    // 根结点
    private Node root;
    // 记录树中元素的个数
    private int N;
    // 红色链接
    private static final boolean RED = true;
    // 黑色链接
    private static final boolean BLACK = false;

    /**
     * 判断当前结点的父指向链接是否为红色
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * 左旋调整
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        // 1、获取h结点的右子结点，表示为x

        // 2、让x结点左子结点变成h的右子结点

        // 3、让h成为x的左子结点

        // 4、让x结点的color属性等于h结点的color属性

        // 5、让h结点的color属性变成红色

        // 6、返回旋转后的x结点
        return null;
    }

    /**
     * 右旋调整
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        // 1、获取h结点的左子结点，表示为x

        // 2、让x结点的右子结点变成h的左子结点

        // 3、让h变成x的右子结点

        // 4、让x结点的color属性等于h结点的color属性

        // 5、让h结点的color属性变成红色

        // 6、返回旋转后的x结点
        return null;
    }

    /**
     * 颜色反转，相当于完成拆分4-结点
     * @param h
     */
    private void filpColors(Node h) {
        // 当前结点变成红色

        // 左子结点和右子结点变成黑色
        return;
    }

    /**
     * 在整个树上完成插入操作
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        put(root, key, value);
        // 根节点的颜色总是黑色
        root.color = RED;
    }

    /**
     * 在指定的树中，完成插入操作，并返回添加元素后的新树
     * @param h
     * @param key
     * @param value
     * @return
     */
    private Node put(Node h, Key key, Value value) {
        // 1、判断h是否为空，如果为空，则直接返回一个红色结点就可以了

        // 2、比较h结点的键和当前key的大小
        // 2.1、小于当前结点，则继续往左
        // 2.2、大于当前结点，则继续往右
        // 2.3、等于当前结点，则替换当前value值

        // 进行左旋：当前结点h的左子结点为黑色，右子结点为红色，需要左旋
        // 进行右旋：当前结点h的左子结点为红色，左子结点的左子结点也为红色，需要右旋
        // 颜色反转：当前结点的左子结点和右子结点都为红色，需要颜色反转
        return null;
    }

    /**
     * 根据key，从树中找出对应的值
     * @param key
     * @return
     */
    public Value get(Key key) {
        return null;
    }

    /**
     * 从指定的树x中，找出key对应的值
     * @param x
     * @param key
     * @return
     */
    private Value get(Node x, Key key) {
        return null;
    }

    /**
     * 获取树中元素的个数
     * @return
     */
    public int size() {
        return N;
    }


    // 结点类
    private class Node {
        // 存储键
        public Key key;
        // 存储值
        public Value value;
        // 存储左子结点
        public Node left;
        // 存储右子结点
        public Node right;
        // 由其父结点指向它的链接的颜色
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
}
