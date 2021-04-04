package com.cfy.learn.algorithm.datastruct.common.link;

import lombok.Data;

/**
 * @Description: 键值对节点
 * @Author: chenfuyuan
 * @Date: 2021/4/3 14:58
 */
@Data
public abstract class KeyNode<Key,Value> {

    /**
     * 键
     */
    protected Key key;

    /**
     * 值
     */
    protected Value value;
}
