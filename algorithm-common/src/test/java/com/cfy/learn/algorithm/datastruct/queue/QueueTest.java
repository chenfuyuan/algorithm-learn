package com.cfy.learn.algorithm.datastruct.queue;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import com.cfy.learn.algorithm.datastruct.queue.linked.LinkedQueue;
import com.cfy.learn.algorithm.datastruct.stack.array.FixCapacityStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: 队列测试类
 * @Author chenfuyuan
 * @Date 2021/3/23 16:09
 */
public class QueueTest {

    private String input;

    private static final String SPLIT = GlobalConstant.SPACE_SPLIT;

    private static final String POP_FLAG = "-";


    @BeforeEach
    void setInput() {
        input = "to be or not to - be - - that - - - is";
    }

    @Test
    public void testLinkedQueue() {
        Queue<String> queue = new LinkedQueue<>();
        String[] splitStr = input.split(SPLIT);
        StringBuilder outputCache = new StringBuilder();
        for (String item : splitStr) {
            if (!POP_FLAG.equals(item)) {
                queue.enqueue(item);
                continue;
            }

            if (!queue.isEmpty()) {
                outputCache.append(queue.dequeue() + SPLIT);
            }
        }

        System.out.println(outputCache);
        System.out.println("队列剩余元素个数:"+ queue.size());
    }
}