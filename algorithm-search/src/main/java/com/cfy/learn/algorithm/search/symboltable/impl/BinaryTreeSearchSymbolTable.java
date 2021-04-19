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
        if (root != null) {
            return minNode(root).getKey();
        }
        return null;
    }


    /**
     * 返回最小节点
     * @param node 根节点
     * @return 最小节点
     */
    private BinaryTreeKeyNode<Key,Value> minNode(BinaryTreeKeyNode<Key,Value> node) {
        if (node.getLeft() == null) {
            return node;
        }

        return minNode(node.getLeft());
    }

    @Override
    public Key max() {
        if (root != null) {
            return maxNode(root).getKey();
        }
        return null;
    }

    /**
     * 返回最大节点
     * @param node 节点
     * @return 最大节点
     */
    private BinaryTreeKeyNode<Key, Value> maxNode(BinaryTreeKeyNode<Key, Value> node) {
        if (node.getRight() == null) {
            return node;
        }

        return maxNode(node.getRight());
    }

    @Override
    public Key floor(Key key) {
        return getKey(floorNode(root, key));
    }

    private Key getKey(BinaryTreeKeyNode<Key,Value> node) {
        if (node == null) {
            return null;
        }
        return node.getKey();
    }

    /**
     * 小于等于key的最大键
     * 当key小于根节点时，一定出现在左子树上
     * 当key大于根节点时，一定出现在右子树或根上
     * @param node 根节点
     * @param key 键
     * @return 小于等于key的最大键
     */
    private BinaryTreeKeyNode<Key,Value> floorNode(BinaryTreeKeyNode<Key,Value> node,Key key) {
        if (node == null) {
            return null;
        }

        if (CompareUtil.equal(node.getKey(), key)) {
            return node;
        }

        if (CompareUtil.less(key, node.getKey())) {
            return floorNode(node.getLeft(), key);
        } else {
            BinaryTreeKeyNode<Key, Value> result = floorNode(node.getRight(), key);
            if (result == null) {
                return node;
            }
            return CompareUtil.less(result.getKey(), key) ? result : node;
        }
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
            root = new BinaryTreeKeyNode<>(key, value);
        } else {
            insertNode(root,key,value);
        }
    }

    /**
     * 插入节点
     * 当值存在时，替换value
     * 当值不存在时，找到最符合的点，小于插入左子树，大于插入右子树
     * @param node 节点
     * @param key 键
     * @param value 值
     */
    private void insertNode(BinaryTreeKeyNode<Key,Value> node,Key key,Value value) {
        insertNode(node,new BinaryTreeKeyNode<>(key,value));
    }

    /**
     * 插入节点
     * @param node 节点
     * @param insertNode 插入节点
     */
    private void insertNode(BinaryTreeKeyNode<Key, Value> node, BinaryTreeKeyNode<Key, Value> insertNode) {
        int compareResult = insertNode.getKey().compareTo(node.getKey());

        if (compareResult < 0) {
            if (node.getLeft() == null) {
                node.insertLeft(insertNode);
                return;
            }
            insertNode(node.getLeft(),insertNode);
        } else if (compareResult > 0) {
            if (node.getRight() == null) {
                node.insertRight(insertNode);
                return;
            }
            insertNode(node.getRight(),insertNode);
        } else {
            node.setValue(insertNode.getValue());
            return;
        }

        node.reCaculateSize();
    }
    /**
     * 根据key查找节点
     * @param node 当前节点 
     * @param key 值
     * @return 查找结果
     */
    public BinaryTreeKeyNode<Key, Value> findNode(BinaryTreeKeyNode<Key, Value> node, Key key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.getKey());

        if (compareResult < 0) {
            return findNode(node.getLeft(), key);
        } else if (compareResult > 0) {
            return findNode(node.getRight(), key);
        } else {
            return node;
        }
    }
    
    @Override
    public Value get(Key key) {
        BinaryTreeKeyNode<Key, Value> node = findNode(root, key);
        return node == null ? null : node.getValue();
    }

    @Override
    public void delete(Key key) {
        if (root == null || key == null) {
            return;
        }

        if (CompareUtil.equal(key, root.getKey())) {
            root = null;
        } else {
            deleteNode(root,key);
        }
        
    }

    /**
     * 删除节点
     * @param node 节点 
     * @param key 值
     */
    private void deleteNode(BinaryTreeKeyNode<Key, Value> node, Key key) {
        if (node == null) {
            return;
        }

        int comapreResult = node.getKey().compareTo(key);

        if (comapreResult > 0) {
            deleteNode(node.getLeft(),key);
        } else if (comapreResult < 0) {
            deleteNode(node.getRight(), key);
        } else {
            BinaryTreeKeyNode<Key, Value> adjustNode = adjustDeleteNode(node);
            node.setLeft(adjustNode.getLeft());
            node.setRight(adjustNode.getRight());
            node.setValue(adjustNode.getValue());
            node.setKey(adjustNode.getKey());
        }

        node.reCaculateSize();
    }

    /**
     * 调整删除节点
     * @param node 删除节点
     */
    private BinaryTreeKeyNode<Key,Value> adjustDeleteNode(BinaryTreeKeyNode<Key, Value> node) {
        //当左子树为空时，直接右子树替代根节点
        if (node.getLeft() == null) {
            return node.getRight();
        }
        //当右子树为空时，直接左子树替代根节点
        if (node.getRight() == null) {
            return node.getLeft();
        }

        //当左右子树都非空时，拿右子树替换根节点，并进行调整
        insertNode(node.getRight(), node.getLeft());
        return node.getRight();
    }

    @Override
    public boolean contains(Key key) {
        return findNode(root, key) != null;
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

    /**
     * 测试顺序
     */
    public void check() {
        check(root);
    }

    public void check(BinaryTreeKeyNode<Key, Value> node) {
        if (node == null) {
            return;
        }

        BinaryTreeKeyNode<Key, Value> left = node.getLeft();
        BinaryTreeKeyNode<Key, Value> right = node.getRight();

        int totalSize = 1;

        if (left != null) {
            assert CompareUtil.less(left.getKey(), node.getKey());
            totalSize += left.getSize();
            check(node.getLeft());
        }

        if (right != null) {
            assert CompareUtil.more(right.getKey(), node.getKey());
            check(node.getRight());
            totalSize += right.getSize();
        }

        assert node.getSize() == totalSize;
    }
}
