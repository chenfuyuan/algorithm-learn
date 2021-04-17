package com.cfy.learn.algorithm.search.symboltable.impl;

import com.cfy.learn.algorithm.datastruct.common.able.ArrayDataStruct;
import com.cfy.learn.algorithm.search.symboltable.OrderlySymbolTable;
import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.CompareUtil;

/**
 * @Description: 二分查找(基于有序数组)
 * @Author: chenfuyuan
 * @Date: 2021/4/7 22:02
 */
public class BinarySearchSymbolTable<Key extends Comparable<Key>, Value> implements OrderlySymbolTable<Key, Value>, ArrayDataStruct {

    /**
     * 偏移量
     */
    private static final int OFFSET_ONE = 1;
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

    /**
     * 容量
     */
    private int capacity;

    /**
     * 根据初始容量构建符号表
     */
    public BinarySearchSymbolTable() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 根据传入的容量，构建符号表
     *
     * @param capacity 容量
     */
    public BinarySearchSymbolTable(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Comparable[capacity];
        this.capacity = capacity;
    }

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

    /**
     * 插入元素
     * 1.当插入元素存在时，替换Value值
     * 2.当插入元素不存在时，找到合适位置进行插入，保持符号表有序，当元素个数大于容量时，对数组进行扩容，扩容为原来的一倍
     *
     * @param key   键
     * @param value 值
     */
    @Override
    public void put(Key key, Value value) {
        int rank = rank(key);
        //当插入元素已存在时,替换Value值
        if (isKeyEquals(rank, key)) {
            vals[rank] = value;
            return;
        }

        //判断是否需要扩容，进行扩容
        if (isExpansion()) {
            capacity = expansionCapacity();
            resize();
        }

        //找到合适的位置进行插入
        //array[rank]的数组向后移动一格
        ArrayUtil.offset(keys, rank, OFFSET_ONE);
        keys[rank] = key;
        ArrayUtil.offset(vals, rank, OFFSET_ONE);
        vals[rank] = value;
    }


    /**
     * 调整数组大小
     */
    private void resize() {
        keys = ArrayUtil.resize(keys, capacity);
        vals = ArrayUtil.resize(vals, capacity);
    }


    /**
     * key[index] ?= key
     *
     * @param index 索引
     * @param key   key值
     * @return 比较结果
     */
    private boolean isKeyEquals(int index, Key key) {
        return index < size && CompareUtil.equal(keys[index], key);
    }

    @Override
    public Value get(Key key) {
        //如果符号表为空，返回null
        if (isEmpty()) {
            return null;
        }

        //rank 获取符号表中小于key的个数
        int rank = rank(key);

        //当rank小于size 且 keys[rank] == key 时
        if (isKeyEquals(rank, key)) {
            return vals[rank];
        }

        return null;
    }

    /**
     * 删除元素
     * 1.查看元素是否存在
     * 元素前移
     *
     * @param key 键
     */
    @Override
    public void delete(Key key) {
        int rank = rank(key);

        //key不存在,直接返回
        if (!isKeyEquals(rank, key)) {
            return;
        }

        ArrayUtil.offset(keys, rank - 1, -OFFSET_ONE);
        //初始化末尾元素
        keys[size - 1] = null;
        ArrayUtil.offset(vals, rank - 1, -OFFSET_ONE);
        //初始化末尾元素
        vals[size--] = null;

        //判断是否需要缩容
        if (isShrink()) {
            capacity = shrinkCapacity();
            resize();
        }
    }

    @Override
    public boolean contains(Key key) {
        int rank = rank(key);
        return isKeyEquals(rank, key);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return capacity;
    }
}
