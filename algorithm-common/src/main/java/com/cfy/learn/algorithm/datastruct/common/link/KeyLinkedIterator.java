package com.cfy.learn.algorithm.datastruct.common.link;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Description: 键值链表迭代器
 * @Author: chenfuyuan
 * @Date: 2021/4/3 15:33
 */
public class KeyLinkedIterator<Key, Value> implements Iterator<Key>,Iterable<Key> {

    /**
     * 当前节点
     */
    private SingleKeyNode<Key, Value> current;

    public KeyLinkedIterator(SingleKeyNode<Key, Value> first) {
        current = first;
    }

    @Override
    public boolean hasNext() {
        return this.current != null;
    }

    @Override
    public Key next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Key item = current.getKey();
        current = current.getNext();
        return item;
    }

    @Override
    public Iterator<Key> iterator() {
        return this;
    }
}
