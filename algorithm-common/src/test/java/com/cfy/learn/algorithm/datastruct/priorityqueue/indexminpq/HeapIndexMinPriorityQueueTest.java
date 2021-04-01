package com.cfy.learn.algorithm.datastruct.priorityqueue.indexminpq;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author: chenfuyuan
 * @Date: 2021/4/1 16:15
 */
public class HeapIndexMinPriorityQueueTest {

    private String[] inputArray;

    @BeforeEach
    public void init() {
        String input = "A B C F G I I Z B D H P Q Q A B E F J N";
        inputArray = input.split(GlobalConstant.SPACE_SPLIT);
    }


    @Test
    public void test() {
        IndexMinPriorityQueue<String> priorityQueue = new HeapIndexMinPriorityQueue<>();
        for (int i = 0; i < inputArray.length; i++) {
            priorityQueue.insert(i,inputArray[i]);
        }

        for (int i = 0; i < inputArray.length; i++) {
            String min = priorityQueue.min();
            System.out.printf("%s(%d) ",min,priorityQueue.delMin());
        }
    }

}