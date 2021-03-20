package com.cfy.learn.algorithm.datastruct.bag;

/**
 * @Description: 背包API
 * 背包是一种不支持从中删除元素的集合数据类型
 * @Author chenfuyuan
 * @Date 2021/3/18 16:15
 */
public interface Bag<Item> extends Iterable<Item> {

    /**
     * 添加元素
     * @param item 元素
     */
    void add(Item item);


    /**
     * 判断背包是否为空
     * @return true 背包为空
     */
    boolean isEmpty();

    /**
     * 背包中的元素数量
     * @return 背包中的元素数量
     */
    int size();

}
