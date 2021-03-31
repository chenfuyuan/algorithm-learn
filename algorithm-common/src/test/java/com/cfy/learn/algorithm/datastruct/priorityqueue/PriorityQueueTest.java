package com.cfy.learn.algorithm.datastruct.priorityqueue;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import com.cfy.learn.algorithm.datastruct.priorityqueue.maxpq.OrderlyHeapMaxPriorityQueue;
import com.uptool.core.util.RandomUtil;
import com.uptool.core.util.SortUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: 优先队列测试
 * @Author: chenfuyuan
 * @Date: 2021/3/31 15:42
 */
public class PriorityQueueTest {

    private Comparable[] input;

    private static final int capacity = 30;

    private static final int MAX_SIZE = 5;
    @BeforeEach
    public void init() {
        input = RandomUtil.generateCapitalLetterArray(capacity);
        System.out.print("输入为:");
        SortUtil.show(input);
    }

    @Test
    public void testOrderlyHeapMaxPriorityQueue() {
        OrderlyHeapMaxPriorityQueue priorityQueue = new OrderlyHeapMaxPriorityQueue(input);
        System.out.print("输出为:");

        for (int i = 0; i < MAX_SIZE; i++) {
            Comparable comparable = priorityQueue.delMax();
            System.out.print(comparable.toString()+ GlobalConstant.SPACE_SPLIT);
        }
    }

    @Test
    public void testOrderlyHeapMaxPriorityQueueInsert() {
        OrderlyHeapMaxPriorityQueue priorityQueue = new OrderlyHeapMaxPriorityQueue();
        for (int i = 0; i < capacity; i++) {
            priorityQueue.insert(input[i]);
        }

        System.out.print("输出为:");

        for (int i = 0; i < MAX_SIZE; i++) {
            Comparable comparable = priorityQueue.delMax();
            System.out.print(comparable.toString()+ GlobalConstant.SPACE_SPLIT);
        }
    }

}