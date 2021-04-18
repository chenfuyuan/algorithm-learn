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
        node.left = left;
        left = node;
        this.size++;
        if (node.left != null) {
            node.size = node.left.size + 1;
        } else {
            node.size = 0;
        }
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
        node.right = right;
        right = node;
        this.size++;
        if (node.right != null) {
            node.size = node.right.size + 1;
        }
    }

    /**
     * size递增
     */
    public void increaseSize() {
        size++;
    }


}
