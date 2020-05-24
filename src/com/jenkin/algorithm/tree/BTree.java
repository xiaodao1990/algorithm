package com.jenkin.algorithm.tree;

/**
 * 红黑树，一个结点最多有两个key
 * B树，一个结点允许多于两个Key的存在。
 * B树是一种树状数据结构，它能够存储数据、对其进行排序并允许以O(logn)的时间复杂度进行查找、顺序读取、
 * 插入和删除等操作。
 *
 * B树的性质
 *  B树中允许一个结点中包含多个Key，可以是3个、4个、5个甚至更多，并不确定。有M个Key就称作为M阶的B树。
 *  我们现在以M阶的B树为例：
 *      每个结点最多有M-1个Key，并且按照升序排列。
 *      每个结点最多能有M个子结点。
 *      根结点至少有两个子结点。
 * 在实际应用中B树的阶数一半都比较大(通常大于100)，所以，即使存储大量的数据，B树的高度仍然比较小，这样在
 * 某些应用场景下，就可以体现出它的优势
 *
 * B+树与B树的区别在于：
 *  1、非叶结点仅具有索引作用，也就是说，非叶子结点只存储key，不存储value。
 *  2、树的所有叶子结点构成一个有序链表，可以按照key的排序次序遍历全部数据。
 *
 * B+树的优点在于：
 *  1、由于B+树在非叶结点上不包含真正的数据，只当作索引使用，因此在内存相同的情况下，能够存放更多的Key。
 *  2、B+树的叶子结点都是相连的，因此对整棵树的遍历只需要线性遍历叶子结点即可。而且由于数据顺序排列并且相连，
 *  所以便于查找和搜索。而B树需要进行每一层的递归遍历。
 */
public class BTree {
}
