package com.cfy.learn.algorithm.search.symboltable.impl;

import com.cfy.learn.algorithm.datastruct.common.able.ArrayDataStruct;
import com.cfy.learn.algorithm.datastruct.queue.Queue;
import com.cfy.learn.algorithm.datastruct.queue.linked.LinkedQueue;
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
        Queue<Key> queue = new LinkedQueue<>();

        int endFlag = rank(hight);
        for (int i = rank(low); i < rank(hight); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hight)) {
            queue.enqueue(keys[endFlag]);
        }

        return queue;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[size-1];
    }

    @Override
    public Key floor(Key key) {
        return keys[rank(key) - 1];
    }

    @Override
    public Key ceiling(Key key) {
        return keys[rank(key)];
    }

    /**
     * 使用二分查找法进行查询
     * @param key 键
     * @return 符合索引
     */
    @Override
    public int rank(Key key) {
        int low = 0, hight = size - 1;
        while (low <= hight) {
            int mid = low + (hight - low) / 2;
            int cmp = keys[mid].compareTo(key);
            if (cmp > 0) {
                hight = mid - 1;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    @Override
    public Key select(int sortIndex) {
        return keys[sortIndex-1];
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
        ArrayUtil.offset(keys, rank, OFFSET_ONE,size-1);
        keys[rank] = key;
        ArrayUtil.offset(vals, rank, OFFSET_ONE,size-1);
        vals[rank] = value;
        size++;
    }


    /**
     * 调整数组大小
     */
    private void resize() {
        System.out.println("扩容容量->"+capacity);
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

        ArrayUtil.offset(keys, rank - 1, -OFFSET_ONE,size-1);
        //初始化末尾元素
        keys[size - 1] = null;
        ArrayUtil.offset(vals, rank - 1, -OFFSET_ONE,size-1);
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
