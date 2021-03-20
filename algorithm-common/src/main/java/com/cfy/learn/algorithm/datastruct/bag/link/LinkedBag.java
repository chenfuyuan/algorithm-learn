package com.cfy.learn.algorithm.datastruct.bag.link;

import com.cfy.learn.algorithm.datastruct.bag.Bag;
import com.cfy.learn.algorithm.datastruct.common.link.LinkedIterator;
import com.cfy.learn.algorithm.datastruct.common.link.SingleNode;

import java.util.Iterator;

/**
 * @Description: 链表实现背包
 * @Author chenfuyuan
 * @Date 2021/3/18 16:48
 */
public class LinkedBag<Item> implements Bag<Item> {

    /**
     * 首节点
     */
    private SingleNode<Item> first = null;

    /**
     * 元素个数
     */
    private int size;


    @Override
    public void add(Item item) {
        //头插法，插入元素
        SingleNode<Item> node = new SingleNode<>(item);
        node.setNext(first);
        first = node;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator<>(first);
    }

}
