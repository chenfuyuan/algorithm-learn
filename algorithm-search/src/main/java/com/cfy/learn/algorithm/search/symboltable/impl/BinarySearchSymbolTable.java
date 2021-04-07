package com.cfy.learn.algorithm.search.symboltable.impl;

import com.cfy.learn.algorithm.search.symboltable.OrderlySymbolTable;

/**
 * @Description: 二分查找(基于有序数组)
 * @Author: chenfuyuan
 * @Date: 2021/4/7 22:02
 */
public class BinarySearchSymbolTable<Key extends Comparable<Key>,Value> implements OrderlySymbolTable<Key,Value> {

    /**
     * 键集合
     */
    private Key[] keys;

    /**
     * 值集合
     */
    private Value[] vals;

    /**
     * 元素个数
     */
    private int size;

    @Override
    public Iterable<Key> keys(Key low, Key hight) {
        return null;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int sortIndex) {
        return null;
    }

    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }
}
