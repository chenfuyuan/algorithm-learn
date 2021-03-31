package com.cfy.learn.algorithm.datastruct.priorityqueue.maxpq;

import com.uptool.core.util.ArrayUtil;

/**
 * @Description: 多叉树
 * @Author: chenfuyuan
 * @Date: 2021/3/31 21:09
 */
public class MultiHeapMaxPriorityQueue<Item extends Comparable<Item>> extends HeapMaxPriorityQueue<Item> {
    /**
     * 默认容量
     */
    public final static int DEFAULT_CAPACITY = 16;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 根节点索引
     */
    private final static int ROOT_NODE_INDEX = 1;

    /**
     * 默认分支个数
     */
    private final static int DEFAULT_BRANCH_SIZE = 2;

    private final int branchSize;

    /**
     * 缩小系数(个数) 数组个数<数组长度*缩小系数(个数)时进行缩小数组
     */
    private static final double SHRINK_SIZE_FACTOR = 0.25;

    /**
     * 创建空的优先队列
     */
    public MultiHeapMaxPriorityQueue(int branchSize) {
        this(DEFAULT_CAPACITY,branchSize);
    }

    /**
     * 创建一个初始容量为capacity的优先队列
     * @param capacity 容量
     */
    public MultiHeapMaxPriorityQueue(int capacity,int branchSize) {
        //空出一个索引，方便后续父节点及子节点查找
        this.capacity = capacity;
        this.branchSize = branchSize;
        heap = (Item[]) ArrayUtil.newArray(capacity + ROOT_NODE_INDEX, Comparable.class);
        size = 0;
    }

    /**
     * 将数组对象转化为优先队列
     * @param elementArray 元素数组
     */
    public MultiHeapMaxPriorityQueue(Item[] elementArray,int branchSize) {
        this(elementArray.length,branchSize);
        for (Item element : elementArray) {
            insert(element);
        }
    }

    @Override
    public void insert(Item element) {
        //当数组元素个数大于等于容量时，进行扩容操作
        if (size >= capacity) {
            resize(capacity << 1);
        }
        //将新插入的元素，插入到堆的末尾，执行上浮操作
        heap[++size] = element;
        swim(size);
    }

    /**
     * 对队列进行扩容
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        heap = ArrayUtil.resize(heap, newCapacity+ROOT_NODE_INDEX);
        capacity = newCapacity;
    }

    @Override
    public Item max() {
        //根节点即为最大节点
        return heap[ROOT_NODE_INDEX];
    }

    @Override
    public Item delMax() {
        //获取根节点，并暂存
        Item result = max();
        //交换根节点与最后哦节点的位置
        exch(ROOT_NODE_INDEX,size);
        //释放空间
        heap[size--] = null;
        //进行下浮操作
        sink(ROOT_NODE_INDEX);
        //当数组元素个数 小于 容量乘以缩小比例时，进行缩容
        if (size <= capacity * SHRINK_SIZE_FACTOR) {
            resize(capacity>>1);
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    /**
     * 上浮元素
     * 使heap[index]的元素，上浮到相应位置
     * 保证heap[index/2] > heap[index]
     *
     * @param index 上浮元素索引
     */
    @Override
    public void swim(int index) {
        while (index > 1 && less(parentIndex(index), index)) {
            exch(parentIndex(index), index);
            //寻找父节点
            index = parentIndex(index);
        }
    }

    /**
     * 获取父节点索引
     * @param index 寻找父节点的索引
     * @return 对应的父节点索引
     */
    public int parentIndex(int index) {
        return (index+branchSize-2) /branchSize;
    }

    /**
     * 获取第一个子节点的索引
     * @param index 寻找子节点的索引
     * @return 对应的子节点索引
     */
    public int firstChildIndex(int index) {
        return index * branchSize - (branchSize - 2);
    }

    @Override
    public void sink(int index) {
        while (firstChildIndex(index) <= size()) {
            //与子节点进行比较，与较大的子节点交换位置

            int maxIndex = firstChildIndex(index);
            int j = maxIndex + 1;
            for (int i =0;i<branchSize && j<=size; i++,j++) {
                if (heap[maxIndex] == null || heap[j] == null) {
                    break;
                }
                if (less(maxIndex, j)) {
                    maxIndex = j;
                }
            }
            if (!less(index, maxIndex)) {
                break;
            }
            exch(index,maxIndex);
            index = maxIndex;
        }
    }
}
