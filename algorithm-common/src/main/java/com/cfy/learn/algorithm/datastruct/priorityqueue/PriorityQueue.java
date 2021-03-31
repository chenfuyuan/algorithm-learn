package com.cfy.learn.algorithm.datastruct.priorityqueue;

import com.cfy.learn.algorithm.datastruct.common.able.DataStruct;

/**
 * @Description: 优先队列
 * @Author: chenfuyuan
 * @Date: 2021/3/31 14:13
 */
public abstract class PriorityQueue<Item extends Comparable<Item>> implements DataStruct {

    /**
     * 创建一个优先队列
     */
    public PriorityQueue() {

    }

    /**
     * 创建一个初始容量为capacity的优先队列
     * @param capacity 容量
     */
    public PriorityQueue(int capacity) {

    }

    /**
     * 用values中的元素创建一个优先队列
     * @param values 值数组
     */
    public PriorityQueue(Item[] values) {

    }

    /**heap Orderly
     * 向优先队列中插入一个元素
     * @param element 元素
     */
    public abstract void insert(Item element);

    /**
     * 返回最大元素
     * @return 最大元素
     */
    public abstract Item max();

    /**
     * 删除并返回最大元素
     * @return 最大元素
     */
    public abstract Item delMax();


}
