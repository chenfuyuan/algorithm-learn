package com.cfy.learn.algorithm.datastruct.priorityqueue;

import com.cfy.learn.algorithm.datastruct.common.able.DataStruct;

/**
 * @Description: 优先队列
 * @Author: chenfuyuan
 * @Date: 2021/3/31 14:13
 */
public interface PriorityQueue<Item extends Comparable<Item>> extends DataStruct {



    /**heap Orderly
     * 向优先队列中插入一个元素
     * @param element 元素
     */
    void insert(Item element);

    /**
     * 返回最大元素
     * @return 最大元素
     */
    Item max();

    /**
     * 删除并返回最大元素
     * @return 最大元素
     */
    Item delMax();


}
