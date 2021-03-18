package com.cfy.learn.algorithm.datastruct.link;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Description: 链式迭代器
 * @Author chenfuyuan
 * @Date 2021/3/18 16:58
 */
public class LinkedIterator<Item> implements Iterator<Item> {
    /**
     * 当前节点
     */
    private SingleNode<Item> current;

    public LinkedIterator(SingleNode first) {
        this.current = first;
    }

    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    @Override
    public Item next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Item item = current.getValue();
        current = current.getNext();
        return item;
    }

}
