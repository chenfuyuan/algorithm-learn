package com.cfy.learn.algorithm.base.stack;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import com.cfy.learn.algorithm.datastruct.stack.array.FixCapacityStack;
import com.cfy.learn.algorithm.datastruct.stack.array.FlexibleCapacityStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Description: 定容栈测试
 * @Author chenfuyuan
 * @Date 2021/3/20 14:35
 */
public class StackTest {

    private String input;

    private static final String SPLIT = GlobalConstant.SPACE_SPLIT;

    private static final String POP_FLAG = "-";

    @BeforeEach
    public void getData() {
        input = "to be or not to - be - - that - - - is";
    }

    @Test
    public void testFixedCapacityStack() {
        FixCapacityStack<String> stack = new FixCapacityStack<>();
        String[] splitStr = input.split(SPLIT);
        StringBuilder outputCache = new StringBuilder();
        for (String item : splitStr) {
            if (!POP_FLAG.equals(item)) {
                stack.push(item);
                continue;
            }

            if (!stack.isEmpty()) {
                outputCache.append(stack.pop() + SPLIT);
            }
        }

        System.out.println(outputCache);
        System.out.println("栈内剩余元素个数:"+ stack.size());
    }


    @Test
    public void testFlexiableCapacityStack() {
        FlexibleCapacityStack<String> stack = new FlexibleCapacityStack<>(2);
        String[] splitStr = input.split(SPLIT);
        StringBuilder outputCache = new StringBuilder();
        for (String item : splitStr) {
            if (!POP_FLAG.equals(item)) {
                stack.push(item);
                continue;
            }

            if (!stack.isEmpty()) {
                outputCache.append(stack.pop() + SPLIT);
            }
        }

        System.out.println(outputCache);
        System.out.println("栈内剩余元素个数:"+ stack.size());
        System.out.println("当前栈的容量为:"+stack.getCapacity());
    }
}
