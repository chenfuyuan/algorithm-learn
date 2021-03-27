package com.cfy.learn.algorithm.datastruct.stack.array;

import com.cfy.learn.algorithm.datastruct.stack.Stack;

/**
 * @Description: 定容栈
 * @Author chenfuyuan
 * @Date 2021/3/20 14:12
 */
public class FixCapacityStack<T> implements Stack<T> {

    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 存储内容
     */
    private T[] array;

    /**
     * 大小
     */
    private int size;

    /**
     * 容量
     */
    private final int capacity;

    public FixCapacityStack(int capacity) {
        this.capacity = capacity;
        newInstance();
    }

    public FixCapacityStack() {
        capacity = DEFAULT_CAPACITY;
        newInstance();
    }

    @SuppressWarnings("unchecked")
    private void newInstance() {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void push(T element) {
        if (size >= capacity) {
            throw new RuntimeException("超过栈容量;");
        }
        array[size++] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈中无元素;");
        }
        T result = array[size - 1];
        array[--size] = null;
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }
}
