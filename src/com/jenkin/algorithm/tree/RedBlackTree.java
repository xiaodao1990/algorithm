package com.jenkin.algorithm.tree;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 2-3能保证在树插入元素之后，树仍然保持平衡状态，它的最坏情况下是所有结点都是2结点，树的高度为lgN，相比于我们普通的
 * 二叉查找树，最坏的情况下树的高度为N，确实保证了最坏情况下的时间复杂度，但是2-3查找树实现起来过于复杂。所以我们介绍
 * 一种2-3查找树思想的简单实现：红黑树
 *
 * 红黑树主要是对2-3树进行编码，红黑树背后的基本思想是用标准的二叉查找树（完全由2-结点构成）和一些额外的信息（替换3-结点）来
 * 表示2-3结点，我们将树中的链接分为两种类型：
 *  红链接：将两个2-结点连接起来构成3-结点
 *  黑链接：则是2-3树中的普通链接
 *
 * 确切的说，我们将3-结点表示为由一条左斜的红色链接（两个2-结点其中之一是另一个的左子结点）相连的两个2-结点。这种表示法的一个
 * 优点是，我们无需修改就可以直接使用标准的二叉查找树的get方法。
 *
 * 红黑树的定义：
 *      红黑树是含有红黑树链接并满足下列条件的二叉查找树：
 *          1、红链接均为左链接。
 *          2、没有任何一个结点同时和两条红链接相连。
 *          3、该树是完美的黑色平衡树，即任意空链接到根结点的路径上的黑链接数量相同。
 *
 * 由于每个结点都只会有一条指向自己的链接(从它的父结点指向它)，我们可以在之前的Node结点中添加一个布尔类型的变量
 * color来表示链接的颜色。如果指向它的链接是红色的，那么该变量的值为true，如果链接是黑色的，那么该变量的值为false
 *
 * 在平衡树进行一些增删改查操作后，很有可能会出现红色的右链接或者两条连续红色的链接，而这些都不满足红黑树的定义。
 * 所以我们需要对这些情况通过旋转进行修复，让红黑树保持平衡。
 *
 * 1、左旋
 *  当某个结点的左子结点为黑色，右子结点为红色，此时需要左旋
 *  前提：当前结点为h，它的右子结点为x
 *  左旋过程：
 *  1）让x的左子结点变成h的右子结点：h.right=x.right
 *  2) 让h成为x的左子结点
 *  3）让h的color属性变成x的color属性：x.color=h.color
 *  4) 让h的color属性变成RED：h.color=RED
 * 2、右旋
 *  当某个结点的左子结点是红色，且右子结的左子结点也是红色，需要右旋
 *  前提：当前结点为h，它的左子结点为x
 *  右旋过程：
 *  1）让x的右子结点成为h的左子结点：h.left=h.right
 *  2) 让h成为x的右子结点：x.right=h;
 *  3) 让x的color变成h的color属性：x.color=h.color
 *  4) 让h的color为RED
 *
 *  https://blog.csdn.net/zjbzlc/article/details/103951223
 *  为什么插入的元素为红结点？
 *      在红黑树中新插入的节点默认为红色
 *  为什么要红链接均为左链接？
 *      1、根据红黑树的定义，红链接默认均为左链接。
 *      2、将2-3进行改造成红黑树的过程中，也是将3结点左侧小的结点改造成红结点。所以对于红黑树，2结点
 *      中插入比当前Key大的值时，需要进行左旋。
 *
 *
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
        Node x = h.right;

        // 2、让x结点左子结点变成h的右子结点
        h.right = x.left;

        // 3、让h成为x的左子结点
        x.left = h;

        // 4、让x结点的color属性等于h结点的color属性
        x.color = h.color;

        // 5、让h结点的color属性变成红色
        h.color = RED;

        // 6、返回旋转后的x结点
        return x;
    }

    /**
     * 右旋调整
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        // 1、获取h结点的左子结点，表示为x
        Node x = h.left;
        // 2、让x结点的右子结点变成h的左子结点
        h.left = x.right;
        // 3、让h变成x的右子结点
        x.right = h;
        // 4、让x结点的color属性等于h结点的color属性
        x.color = h.color;
        // 5、让h结点的color属性变成红色
        h.color = RED;
        // 6、返回旋转后的x结点
        return x;
    }

    /**
     * 颜色反转，相当于完成拆分4-结点
     * @param h
     */
    private void filpColors(Node h) {
        // 当前结点变成红色
        h.color = RED;
        // 左子结点和右子结点变成黑色
        h.left.color = BLACK;
        h.right.color =BLACK;
    }

    /**
     * 在整个树上完成插入操作
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
        // 根节点的颜色总是黑色
        root.color = BLACK;
    }

    /**
     * 在指定的树中，完成插入操作，并返回添加元素后的新树
     *
     * 1、向单个2-结点中插入新键
     *  一棵只含有一个键的红黑树只含有一个2-结点。插入另一个键后，我们马上就需要将它们旋转。
     *      如果新键小于当前结点的键，我们只需要新增一个红色结点即可，新的红黑树和单个3-结点完全等价。
     *      如果新键大于当前结点的键，那么新增的红色结点将会产生一条红色的右链接，此时我们需要左旋，把红色
     *      右链接变成左链接，插入操作才算完成，形成的新的红黑树依然和3-结点等价，其中含有两个键，一条红色链接。
     * 2、向底部的2-结点插入新键
     *  用和二叉查找树相同的方式向一棵红黑树中插入一个新键，会在树的底部新增一个结点(可以保证有序性)，
     *  唯一区别的地方是我们会用红链接将新结点和它的父结点相连。如果它的父结点是一个2-结点，那么刚才讨论的两种
     *  方式仍然适用。
     * 3、颜色反转
     *  当一个结点的左子结点和右子结点的color都是RED时，也就是出现了临时的4-结点，此时只需要把左子结点和右子结点
     *  的颜色变为BLACK，同时让当前结点的颜色变为RED即可。
     * 4、向一棵双键树(即一个3-结点)中插入新键
     *  这种情况可以分为3种子情况：
     *      1、新键大于原树中的两个键
     *          颜色反转
     *      2、新键小于原树中的两个键
     *          右旋，然后颜色反转
     *      3、新键介于原树中的两个键之间
     *          左旋、右旋，然后颜色反转
     * @param h
     * @param key
     * @param value
     * @return
     */
    private Node put(Node h, Key key, Value value) {
        // 1、判断h是否为空，如果为空，则直接返回一个红色结点就可以了
        if (h == null) {
            N++;
            return new Node(key, value, null, null, RED);
        }

        // 2、比较h结点的键和当前key的大小
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            // 2.1、小于当前结点，则继续往左
            h.left = put(h.left, key, value);
        } else if (cmp > 0) {
            // 2.2、大于当前结点，则继续往右
            h.right = put(h.right, key, value);
        } else {
            // 2.3、等于当前结点，则替换当前value值
            h.value = value;
        }

        // 进行左旋：当前结点h的左子结点为黑色，右子结点为红色，需要左旋
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        // 进行右旋：当前结点h的左子结点为红色，左子结点的左子结点也为红色，需要右旋
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        // 颜色反转：当前结点的左子结点和右子结点都为红色，需要颜色反转
        if (isRed(h.left) && isRed(h.right)) {
            filpColors(h);
        }
        // 返回当前结点
        return h;
    }

    /**
     * 根据key，从树中找出对应的值
     * @param key
     * @return
     */
    public Value get(Key key) {
        return get(root, key);
    }

    /**
     * 从指定的树x中，找出key对应的值
     * @param x
     * @param key
     * @return
     */
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // 1、如果要查找的key小于当前结点x的key，则继续找当前结点的左子结点
            return get(x.left, key);
        } else if (cmp > 0) {
            // 2、如果要查找的key大于当前结点x的key，则继续找当前结点的右子结点
            return get(x.right, key);
        } else {
            // 3、如果要查找的key等于当前结点x的key，则树中返回当前结点的value
            return x.value;
        }
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
