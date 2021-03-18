package com.cfy.learn.algorithm.datastruct.array;

import com.cfy.learn.algorithm.datastruct.Bag;

import java.util.Iterator;

/**
 * @Description: 数组实现背包类
 * @Author chenfuyuan
 * @Date 2021/3/18 16:18
 */
public class ArrayBag<Item> implements Bag<Item> {
    @Override
    public void add(Item item) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }
}
