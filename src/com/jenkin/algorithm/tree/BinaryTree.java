package com.jenkin.algorithm.tree;

/**
 * 二叉树就是度不超过2的树
 * 满二叉树：一个二叉树，如果每一层的结点数都达到最大值，则这个二叉树就是满二叉树。
 * 完全二叉树：叶结点只能出现在最下层和次下层，并且最下一层的结点都集中在该层最左边的若干位置的二叉树。
 * 二叉查找树代码实现如下：
 */
public class BinaryTree<Key extends Comparable, Value> {

    // 记录根结点
    private Node root;
    // 记录树中元素的个数
    private int N;

    public BinaryTree() {
        this.N = 0;
    }

    /**
     * 获取树中元素的个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 向树中插入一个键值对
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    /**
     * 给指定树x上，添加一个键值对，并返回添加后的新树
     * @param x
     * @param key
     * @param value
     * @return
     */
    private Node put(Node x, Key key, Value value) {
        // 1、如果当前树中没有任何一个结点，则直接把新结点当作根结点使用
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }

        // 2、如果当前树不为空，则从根结点开始。
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // 2.1 如果新结点的key小于当前结点的key，则继续找当前结点的左子结点
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            // 2.2 如果新结点的key大于当前结点的key，则继续找当前结点的右子结点
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        // 2.3 如果新结点的key等于当前结点的key，则树中已经存在这样的结点，替换该结点的value值即可
        return x;
    }

    /**
     * 根据Key从树中查找对应的值
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
        // 从根结点开始
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // 1、如果要查询的key小于当前结点的key，则继续找当前结点的左子结点
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
            // 2、如果要查询的key大于当前结点的key，则继续找当前结点的右子结点
        } else {
            // 3、如果要查询的key等于当前结点的key，则树中返回当前结点的value
            return x.value;
        }
    }

    /**
     * 根据Key，删除树中对应的键值对
     * @param key
     */
    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * 删除指定树x上的键为Key的键值对，并返回删除后的新树
     * @param x
     * @param key
     */
    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0 ) {
            // 待删除结点的key小于当前结点的key，继续找当前结点的左子结点
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            // 待删除结点的key大于当前结点的key，继续找当前结点的右子结点
            x.right = delete(x.right, key);
        } else {
            // 找到被删除的结点
            // 1. 如果当前结点的右子树不存在，则直接返回当前结点的左子结点
            if (x.right == null) {
                N--;
                return x.left;
            }

            // 2. 如果当前结点的左子树不存在,则直接返回当前结点的右子结点
            if (x.left == null) {
                N--;
                return x.right;
            }

            // 3. 当前结点的左右子树都存在
            // 3.1 找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null) {
                minNode = minNode.left;
            }
            // 3.2 删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null) {
                if (n.left.left == null) {
                    n.left = null;
                } else {
                    n = n.left;
                }
            }
            // 3.3 让被删除结点的左子树成为最小结点的左子树，让被删除结点的右子树成为最小结点的右子树，让被删除结点的父结点指向最小结点
            minNode.left = x.left;
            minNode.right = x.right;
            x = minNode;

            // 3.4 查找树的长度-1
            N--;

        }
        return x;
    }


    private class Node {
        // 存储健
        public Key key;
        // 存储值
        private Value value;
        // 记录左子结点
        public Node left;
        // 记录右子结点
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
