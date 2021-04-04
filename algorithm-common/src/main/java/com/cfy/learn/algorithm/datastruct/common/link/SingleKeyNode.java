package com.cfy.learn.algorithm.datastruct.common.link;

import com.uptool.core.able.EmptyAble;
import com.uptool.core.util.EmptyUtil;
import lombok.Data;

/**
 * @Description: 单节点Key节点
 * @Author: chenfuyuan
 * @Date: 2021/4/3 14:59
 */
@Data
public class SingleKeyNode<Key,Value> extends KeyNode<Key,Value> {

    /**
     * 下一个节点
     */
    private SingleKeyNode<Key,Value> next;


    /**
     * 构造一个节点
     * @param key 键
     * @param value 值
     * @param next 下一个节点
     */
    public SingleKeyNode(Key key,Value value,SingleKeyNode<Key,Value> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    /**
     * 构造一个节点
     * @param key 键
     * @param value 值
     */
    public SingleKeyNode(Key key,Value value) {
        this(key,value,null);
    }

    /**
     * 构造一个空节点
     */
    public SingleKeyNode() {

    }

    /**
     * 根据数据生成一个节点，并插入下一个位置
     * @param key 键
     * @param value 值
     */
    public void insertNext(Key key,Value value) {
        SingleKeyNode<Key,Value> nextNode = new SingleKeyNode<>(key,value);
        insertNext(nextNode);
    }

    /**
     * 插入一个节点
     * @param node 节点
     */
    public void insertNext(SingleKeyNode<Key,Value> node) {
        node.next = this.next;
        this.next = node;
    }

    /**
     * 删除当前节点的下一个节点
     */
    public void deleteNext() {
        if (EmptyUtil.isEmpty(next)) {
            next = next.next;
        }
    }
}
