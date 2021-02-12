package com.cfy.learn.algorithm.base.link;


import lombok.Data;

/**
 * @Description: 节点
 * @Author chenfuyuan
 * @Date 2021/2/12 10:49
 */
@Data
public abstract class Node<T> {

    /**
     * 值
     */
    protected T value;

}
