package com.cfy.learn.algorithm.datastruct.stack;

import com.cfy.learn.algorithm.datastruct.common.able.DataStruct;

/**
 * @Description: 栈api
 * @Author chenfuyuan
 * @Date 2021/3/20 14:18
 */
public interface Stack<T> extends DataStruct {

    /**
     * 添加元素
     * @param element 元素
     */
    void push(T element);


    /**
     * 删除最近添加的元素，并返回
     * @return 栈顶元素
     */
    T pop();

}
