package com.cfy.learn.algorithm.search.symboltable;

import com.cfy.learn.algorithm.datastruct.common.able.DataStruct;

/**
 * @Description: 符号表API
 * @Author: chenfuyuan
 * @Date: 2021/4/2 16:50
 */
public interface SymbolTable<Key, Value> extends DataStruct {

    /**
     * 将键值对存入表中(若值为空则将键key从表中删除)
     * @param key 键
     * @param value 值
     */
    void put(Key key, Value value);

    /**
     * 获取键key对应的值(若键key不存在则返回null)
     * @param key 键
     * @return 键对应的值
     */
    Value get(Key key);

    /**
     * 从表中删除键key(及其对应的值)
     * @param key 键
     */
    void delete(Key key);

    /**
     * 键key在表中是否有对应的值
     * @param key 键
     * @return 是否存在
     */
    boolean contains(Key key);


    /**
     * 表中所有键的集合
     * @return 所有键的集合
     */
    Iterable<Key> keys();
}
