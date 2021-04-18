package com.cfy.learn.algorithm.datastruct.common.link;

import lombok.Data;

/**
 * @Description: 二叉树节点
 * @Author: chenfuyuan
 * @Date: 2021/4/18 10:47
 */
@Data
public class BinaryTreeNode<Item> extends Node<Item> {
    /**
     * 左子树
     */
    private BinaryTreeNode<Item> left;
    /**
     * 右子树
     */
    private BinaryTreeNode<Item> right;
    /**
     * 以该节点作为根的子树中节点的总数
     */
    private int size;
}
