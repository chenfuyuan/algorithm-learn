package com.cfy.learn.algorithm.datastruct.common.able;

import com.uptool.core.util.NumberUtil;

/**
 * @Description: 数组数据结构接口
 * @Author: chenfuyuan
 * @Date: 2021/4/10 16:21
 */
public interface ArrayDataStruct extends DataStruct {

    /**
     * 数组默认大小
     */
    int DEFAULT_CAPACITY = 16;

    /**
     * 整型数组空值
     */
    int INT_EMPTY_VALUE = 0;

    /**
     * 扩容倍数
     */
    int CAPACITY_EXPANSION_MULTIPLE = 2;


    /**
     * 缩容倍数
     */
    double CAPACITY_SHRINK_COEFFICIENT = 0.25;

    /**
     * 缩小容量倍数
     */
    int CAPACITY_SHRINK_MULTIPLE = 2;

    int capacity();

    /**
     * 是否扩容
     *
     * @return 是否扩容
     */
    default boolean isExpansion() {
        return size() >= capacity();
    }

    /**
     * 是否缩小容量
     *
     * @return 是否缩小容量
     */
    default boolean isShrink() {
        return (int) (capacity() * CAPACITY_SHRINK_COEFFICIENT) >= size();
    }

    /**
     * 计算缩小后的容量
     *
     * @return 缩小后的容量
     */
    default int shrinkCapacity() {
        int twoMultiple = NumberUtil.calculateTwoMultiples(CAPACITY_SHRINK_MULTIPLE);
        if (twoMultiple != -1) {
            return capacity() >> twoMultiple;
        }
        return capacity() / CAPACITY_SHRINK_MULTIPLE;
    }

    /**
     * 计算扩容后的容量
     *
     * @return 扩容后的容量
     */
    default int expansionCapacity() {
        int twoMultiple = NumberUtil.calculateTwoMultiples(CAPACITY_EXPANSION_MULTIPLE);
        if (twoMultiple != -1) {
            return capacity() << twoMultiple;
        }
        return capacity() * CAPACITY_EXPANSION_MULTIPLE;
    }
}
