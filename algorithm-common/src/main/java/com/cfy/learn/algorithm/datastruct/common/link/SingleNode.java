package com.cfy.learn.algorithm.datastruct.common.link;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: 单链表节点
 * @Author Vito.Chen
 * @Date 2021/2/12 10:53
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SingleNode<T> extends Node<T> {

    /**
     * 下一个节点
     */
    private SingleNode<T> next;

    public SingleNode(T value) {
        this.value = value;
    }

    public SingleNode() {
    }

    /**
     * 根据数据生成一个节点，并插入下一个位置
     * @param data 数据
     */
    public void insertNext(T data) {
        SingleNode<T> nextNode = new SingleNode<>(data);
        insertNext(nextNode);
    }

    /**
     * 插入一个节点
     * @param node 节点
     */
    public void insertNext(SingleNode<T> node) {
        node.next = this.next;
        this.next = node;
    }

}
