package com.cfy.learn.algorithm.search.symboltable;

/**
 * @Description: 有序符号表
 * @Author: chenfuyuan
 * @Date: 2021/4/3 14:08
 */
public interface OrderlySymbolTable<Key extends Comparable<Key>, Value> extends SymbolTable<Key, Value> {

    /**
     * 表中的所有键的集合 已排序
     * @return 键的集合迭代器
     */
    @Override
    Iterable<Key> keys();

    /**
     * [low..hight]之间的所有键，已排序
     * @param low low索引
     * @param hight hight索引
     * @return 键的集合迭代器
     */
    Iterable<Key> keys(Key low,Key hight);


    /**
     * [low..hight]之间键的数量
     * @param low
     * @param hight
     * @return
     */
    int size(Key low,Key hight);

    /**
     * 最小的键
     * @return 最小的键
     */
    Key min();

    /**
     * 最大的键
     * @return 最大的键
     */
    Key max();

    /**
     * 小于等于key的最大键
     * @param key 键
     * @return 小于等于key的最大键
     */
    Key floor(Key key);


    /**
     * 大于等于key的最小键
     * @param key 键
     * @return 大于等于key的最小键
     */
    Key ceiling(Key key);

    /**
     * 小于key的键的数量
     * @param key 键
     * @return 小于key的键的数量
     */
    int rank(Key key);

    /**
     * 排名为sortIndex的键
     * @param sortIndex 排名
     * @return 返回指定排名的键
     */
    Key select(int sortIndex);

    /**
     * 删除最小的键
     */
    void deleteMin();

    /**
     * 删除最大的键
     */
    void deleteMax();
}
