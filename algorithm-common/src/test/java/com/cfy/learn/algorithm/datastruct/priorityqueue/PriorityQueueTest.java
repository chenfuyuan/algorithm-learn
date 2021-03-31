package com.cfy.learn.algorithm.datastruct.priorityqueue;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import com.cfy.learn.algorithm.datastruct.priorityqueue.maxpq.MultiHeapMaxPriorityQueue;
import com.cfy.learn.algorithm.datastruct.priorityqueue.maxpq.OrderlyHeapMaxPriorityQueue;

import com.uptool.core.util.RandomUtil;
import com.uptool.core.util.SortUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


/**
 * @Description: 优先队列测试
 * @Author: chenfuyuan
 * @Date: 2021/3/31 15:42
 */
public class PriorityQueueTest {

    private Comparable[] input;

    private static final int capacity = 20;

    private static final int MAX_SIZE = 15;
    @BeforeEach
    public void init() {
        input = RandomUtil.generateCapitalLetterArray(capacity);
        /*String inputStr = "A B C D E F G H I J";
        input = inputStr.split(GlobalConstant.SPACE_SPLIT);*/
        System.out.print("输入为:");
        SortUtil.show(input);

    }


    @Test
    public void testOrderlyHeapMaxPriorityQueue() {
        OrderlyHeapMaxPriorityQueue priorityQueue = new OrderlyHeapMaxPriorityQueue(input);
        System.out.print("输出为:");

        Comparable[] resultList = new Comparable[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            Comparable comparable = priorityQueue.delMax();
            resultList[i] = comparable;
            System.out.print(comparable.toString()+ GlobalConstant.SPACE_SPLIT);
        }

        isRight(resultList);


    }

    private void isRight(Comparable[] resultList) {
        Arrays.sort(input);
        System.out.print("\n正确输出:");
        for (int i = 0,hight=input.length-1; i < MAX_SIZE; i++) {
            System.out.print(input[hight-i]+GlobalConstant.SPACE_SPLIT);
        }
        for (int i = 0,hight=input.length-1; i < MAX_SIZE; i++) {
            if (!SortUtil.equal(input[hight - i], resultList[i])) {
                System.out.println("\n输入错误;");
                return;
            }
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

    @Test
    public void testMultiHeapMaxPriorityQueue() {
        MultiHeapMaxPriorityQueue priorityQueue = new MultiHeapMaxPriorityQueue(input,5);
        System.out.print("输出为:");
        Comparable[] resultList = new Comparable[MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            Comparable comparable = priorityQueue.delMax();
            System.out.print(comparable.toString()+ GlobalConstant.SPACE_SPLIT);
            resultList[i] = comparable;
        }

        isRight(resultList);
    }


}