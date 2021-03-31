package com.cfy.learn.algorithm.datastruct.priorityqueue.maxpq;

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
     * 创建空的优先队列
     */
    public OrderlyHeapMaxPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public OrderlyHeapMaxPriorityQueue(int capacity) {
        //空出一个索引，方便后续父节点及子节点查找
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
        //将新插入的元素，插入到堆的末尾，执行上浮操作
        heap[++size] = element;
        swim(size);
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
        return result;
    }

    @Override
    public int size() {
        return size;
    }
}
