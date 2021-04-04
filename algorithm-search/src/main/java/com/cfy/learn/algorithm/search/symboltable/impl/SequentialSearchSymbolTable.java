package com.cfy.learn.algorithm.search.symboltable.impl;


import com.cfy.learn.algorithm.datastruct.common.exception.DataStructEmptyException;
import com.cfy.learn.algorithm.datastruct.common.link.KeyLinkedIterator;
import com.cfy.learn.algorithm.datastruct.common.link.LinkedIterator;
import com.cfy.learn.algorithm.datastruct.common.link.SingleKeyNode;
import com.cfy.learn.algorithm.search.symboltable.SymbolTable;
import com.uptool.core.Exception.ArgumentEmptyException;
import com.uptool.core.util.EmptyUtil;

import java.util.Iterator;

/**
 * @Description: 链表实现的符号表
 * @Author: chenfuyuan
 * @Date: 2021/4/3 14:55
 */
public class SequentialSearchSymbolTable<Key,Value> implements SymbolTable<Key,Value> {

    /**
     * 头节点
     */
    private SingleKeyNode<Key, Value> first;

    /**
     * 符号表元素个数
     */
    private int size;


    @Override
    public void put(Key key, Value value) {
        if (EmptyUtil.isEmpty(key)) {
            throw new ArgumentEmptyException("传入键值为空。");
        }

        //如果值为空，进行删除
        if (EmptyUtil.isEmpty(value)) {
            delete(key);
        }

        //遍历寻找键相同的结点，并更新
        for (SingleKeyNode<Key, Value> node = first; node != null; node = node.getNext()) {
            if (key.equals(node.getKey())) {
                node.setValue(value);
                return;
            }
        }

        //未包含该键，进行头插法插入
        first = new SingleKeyNode<>(key,value,first);
        size++;
    }

    @Override
    public Value get(Key key) {
        for (SingleKeyNode<Key, Value> node = first; node != null; node = node.getNext()) {
            if (key.equals(node.getKey())) {
                return node.getValue();
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (key.equals(first.getKey())) {
            deleteFirst();
            return;
        }
        for (SingleKeyNode<Key, Value> node = first; node != null; node = node.getNext()) {
            if (key.equals(node.getNext().getKey())) {
                deleteNext(node);
                return;
            }
        }
    }

    /**
     * 校验是否可以删除
     */
    private void checkDelete() {
        if (isEmpty()) {
            throw new DataStructEmptyException();
        }
    }

    /**
     * 删除首节点
     */
    private void deleteFirst() {
        checkDelete();
        first = first.getNext();
        deleteAfter();
    }

    private void deleteAfter() {
        size--;
    }

    /**
     * 删除节点的下一个节点
     * @param node 节点
     */
    private void deleteNext(SingleKeyNode<Key, Value> node) {
        checkDelete();
        node.deleteNext();
        deleteAfter();
    }

    @Override
    public boolean contains(Key key) {
        return get(key)!=null;
    }

    @Override
    public Iterable<Key> keys() {
        return new KeyLinkedIterator(first);
    }

    @Override
    public int size() {
        return size;
    }
}
