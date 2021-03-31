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

    /**
     * 创建一个初始容量为capacity的优先队列
     * @param capacity 容量
     */
    public OrderlyHeapMaxPriorityQueue(int capacity) {
        //空出一个索引，方便后续父节点及子节点查找
        this.capacity = capacity;
        heap = (Item[]) ArrayUtil.newArray(capacity + ROOT_NODE_INDEX, Comparable.class);
        size = 0;
    }

    /**
     * 将数组对象转化为优先队列
     * @param elementArray 元素数组
     */
    public OrderlyHeapMaxPriorityQueue(Item[] elementArray) {
        this(elementArray.length);
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
}
