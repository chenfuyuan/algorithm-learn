package com.cfy.learn.algorithm.search.symboltable.impl;

import com.cfy.learn.algorithm.datastruct.common.link.BinaryTreeKeyNode;
import com.cfy.learn.algorithm.search.symboltable.OrderlySymbolTable;
import com.uptool.core.util.CompareUtil;
import com.uptool.core.util.EmptyUtil;

/**
 * @Description: 二叉查找树实现的符号表
 * @Author: chenfuyuan
 * @Date: 2021/4/18 11:35
 */
public class BinaryTreeSearchSymbolTable<Key extends Comparable<Key>,Value> implements OrderlySymbolTable<Key,Value> {

    /**
     * 根节点
     */
    private BinaryTreeKeyNode<Key,Value> root;


    @Override
    public Iterable<Key> keys(Key low, Key hight) {
        return null;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int sortIndex) {
        return null;
    }

    @Override
    public void put(Key key, Value value) {
        assert key != null;
        if (root == null) {
            root = new BinaryTreeKeyNode<>(key,value);
            return;
        }


    }

    /**
     * 插入节点
     * @param node 节点
     * @param key 键
     * @param value 值
     */
    private void insertNode(BinaryTreeKeyNode<Key,Value> node,Key key,Value value) {

    }



    /**
     * 查找对应节点
     * 如果未找到，返回最接近的根节点
     * @param key 键
     * @return 节点对象
     */
    public BinaryTreeKeyNode<Key,Value> findNode(Key key) {
        return null;
    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public int size() {
        if (EmptyUtil.isEmpty(root)) {
            return 0;
        } else {
            return size(root);
        }
    }

    /**
     * 返回以该节点作为根的子树中节点的总数
     * @param node 节点
     * @return 总数
     */
    private int size(BinaryTreeKeyNode<Key, Value> node) {
        return node.getSize();
    }
}
