package com.cfy.learn.algorithm.datastruct.priorityqueue.indexminpq;

import com.cfy.learn.algorithm.datastruct.common.able.DataStruct;

/**
 * @Description: 索引优先队列API
 * @Author: chenfuyuan
 * @Date: 2021/3/31 22:34
 */
public interface IndexMinPriorityQueue<Item extends Comparable<Item>> extends DataStruct {


    /**
     * 插入一个元素，将它和索引keyIndex相关联
     * @param keyIndex 索引
     * @param item 元素
     */
    void insert(int keyIndex, Item item);

    /**
     * 将索引为keyIndex的元素设为item
     * @param keyIndex 索引
     * @param item 元素
     */
    void change(int keyIndex, Item item);

    /**
     * 是否存在索引为keyIndex的元素
     * @param keyIndex 索引
     * @return 是否存在
     */
    boolean contains(int keyIndex);

    /**
     * 删去索引keyIndex及其相关联元素
     * @param keyIndex 索引
     */
    void delete(int keyIndex);

    /**
     * 返回最小元素
     * @return 最小元素
     */
    Item min();

    /**
     * 返回最小元素的索引
     * @return 最小元素的索引
     */
    int minIndex();

    /**
     * 删除最小元素并返回它的索引
     * @return 最小元素索引
     */
    int delMin();

}
