package com.cfy.learn.algorithm.datastruct.common.able;

import com.uptool.core.able.EmptyAble;

/**
 * @Description: 数据结构接口
 * @Author chenfuyuan
 * @Date 2021/3/20 14:24
 */
public interface DataStruct extends EmptyAble {

    /**
     * 返回元素个数
     * @return 元素个数
     */
    int size();

    /**
     * 判空
     * @return 是否为空
     */
    @Override
    default boolean isEmpty() {
        return size() <= 0;
    }
}
