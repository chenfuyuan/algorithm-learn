package com.cfy.learn.algorithm.datastruct.queue;

import com.cfy.learn.algorithm.datastruct.common.able.DataStruct;

/**
 * @Description: 队列API
 * @Author chenfuyuan
 * @Date 2021/3/23 15:37
 */
public interface Queue<Item> extends DataStruct {

    /**
     * 入队
     * @param element 元素
     */
    void enqueue(Item element);


    /**
     * 出队
     * @return 出队元素
     */
    Item dequeue();
}

