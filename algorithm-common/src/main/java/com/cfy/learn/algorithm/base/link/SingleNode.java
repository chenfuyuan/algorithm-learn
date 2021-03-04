package com.cfy.learn.algorithm.base.link;

import lombok.Data;

/**
 * @Description: 单链表节点
 * @Author Vito.Chen
 * @Date 2021/2/12 10:53
 */
@Data
public class SingleNode<T> extends Node<T> {

    /**
     * 下一个节点
     */
    private SingleNode<T> next;

    public SingleNode(T value) {
        this.value = value;
    }

}
