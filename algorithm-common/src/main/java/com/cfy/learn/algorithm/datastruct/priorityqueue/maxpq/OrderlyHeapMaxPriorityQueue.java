package com.cfy.learn.algorithm.datastruct.priorityqueue.maxpq;

import com.uptool.core.util.ArrayUtil;

/**
 * @Description: 有序堆的优先队列
 * @Author: chenfuyuan
 * @Date: 2021/3/31 14:49
 */
public class OrderlyHeapMaxPriorityQueue<Item extends Comparable<Item>> extends HeapMaxPriorityQueue<Item> {

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
     * 缩小系数(个数) 数组个数<数组长度*缩小系数(个数)时进行缩小数组
     */
    private static final double SHRINK_SIZE_FACTOR = 0.25;

    /**
     * 创建空的优先队列
     */
    public OrderlyHeapMaxPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public OrderlyHeapMaxPriorityQueue(int capacity) {
        //空出一个索引，方便后续父节点及子节点查找
        this.capacity = capacity;
        heap = (Item[]) new Comparable[capacity + ROOT_NODE_INDEX];
        size = 0;
    }

    public OrderlyHeapMaxPriorityQueue(Item[] elementArray) {
        this(elementArray.length);
        for (Item element : elementArray) {
            insert(element);
        }
    }

    @Override
    public void insert(Item element) {
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
        System.out.printf("进行容量调整,原容量{%d}->现容量{%d}\n",capacity,newCapacity);
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
        Item result = max();
        exch(ROOT_NODE_INDEX,size);
        heap[size--] = null;
        sink(ROOT_NODE_INDEX);
        if (size <= capacity * SHRINK_SIZE_FACTOR) {
            resize(capacity>>1);
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }
}
