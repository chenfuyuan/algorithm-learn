package com.cfy.learn.algorithm.datastruct.common.link;


import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 双链表节点
 * @Author Vito.Chen
 * @Date 2021/2/12 10:50
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BilateralNode<T> extends Node<T> {

    /**
     * 下一节点
     */
    private BilateralNode<T> next;

    /**
     * 前一节点
     */
    private BilateralNode<T> pre;

    public BilateralNode(T value) {
        this.value = value;
    }

    public BilateralNode() {

    }

}
