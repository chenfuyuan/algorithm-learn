package com.cfy.learn.algorithm.datastruct.stack.array;

import com.cfy.learn.algorithm.datastruct.stack.Stack;
import com.uptool.core.util.ArrayUtil;


/**
 * @Description:
 * @Author chenfuyuan
 * @Date 2021/3/20 15:00
 */
public class FlexibleCapacityStack<T> implements Stack<T> {
    /**
     * 默认容量
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 缩小系数(个数) 数组个数<数组长度*缩小系数(个数)时进行缩小数组
     */
    private static final double SHRINK_SIZE_FACTOR = 0.25;

    /**
     * 缩小系数(容量) 当满足数组缩小条件时，缩小的比例
     */
    private static final double SHRINK_CAPACITY_FACTOR = 0.5;


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
    private int capacity;

    public FlexibleCapacityStack(int capacity) {
        this.capacity = capacity;
        newInstance();
    }

    public FlexibleCapacityStack() {
        capacity = DEFAULT_CAPACITY;
        newInstance();
    }


    private void newInstance() {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void push(T element) {
        if (size >= capacity) {
            //进行扩容
            resize(capacity * 2);
        }
        array[size++] = element;
    }

    /**
     * 对栈进行扩容
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        array = ArrayUtil.resize(array, newCapacity);
        capacity = array.length;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈中无元素;");
        }
        T result = array[--size];
        array[size] = null;
        if (size > 0 && size == (int)(array.length * SHRINK_SIZE_FACTOR)) {
            resize((int)(array.length * SHRINK_CAPACITY_FACTOR));
        }
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

    public int getCapacity() {
        return capacity;
    }
}
