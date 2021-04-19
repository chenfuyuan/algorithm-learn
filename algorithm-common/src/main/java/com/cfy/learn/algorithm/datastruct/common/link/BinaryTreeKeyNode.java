package com.cfy.learn.algorithm.datastruct.common.link;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

/**
 * @Description: 二叉树节点(键值对)
 * @Author: chenfuyuan
 * @Date: 2021/4/18 10:49
 */
@Data
public class BinaryTreeKeyNode<Key,Value> extends KeyNode<Key,Value>{
    /**
     * 左子树
     */
    private BinaryTreeKeyNode<Key,Value> left;
    /**
     * 右子树
     */
    private BinaryTreeKeyNode<Key,Value> right;
    /**
     * 以该节点作为根的子树中节点的总数
     */
    @Setter(AccessLevel.NONE)
    private int size;

    public BinaryTreeKeyNode(Key key,Value value) {
        this.key = key;
        this.value = value;
        size = 1;
    }

    public BinaryTreeKeyNode() {

    }
    /**
     * 插入左节点
     * @param key 键
     * @param value 值
     */
    public void insertLeft(Key key,Value value) {
        BinaryTreeKeyNode<Key, Value> node = new BinaryTreeKeyNode<>(key,value);
        insertLeft(node);
    }

    /**
     * 插入左节点
     * @param node 插入节点
     */
    public void insertLeft(BinaryTreeKeyNode<Key, Value> node) {
        assert left == null;
        left = node;
        this.size+=node.size;
    }

    /**
     * 插入右节点
     * @param key 键
     * @param value 值
     */
    public void insertRight(Key key,Value value) {
        BinaryTreeKeyNode<Key, Value> node = new BinaryTreeKeyNode<>(key,value);
        insertRight(node);
    }

    /**
     * 插入右节点
     * @param node 插入节点
     */
    public void insertRight(BinaryTreeKeyNode<Key, Value> node) {
        assert right == null;
        right = node;
        this.size+=node.size;
    }

    /**
     * size递增
     */
    public void addSize() {
        size++;
    }

    /**
     * size递减
     */
    public void deleteSize() {
        size--;
    }


    /**
     * 重新计算大小
     */
    public void reCaculateSize() {
        size = 1;
        if (left != null) {
            size += left.size;
        }

        if (right != null) {
            size += right.size;
        }
    }
}
