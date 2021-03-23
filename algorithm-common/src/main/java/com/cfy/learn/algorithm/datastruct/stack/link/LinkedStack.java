package com.cfy.learn.algorithm.datastruct.stack.link;

import com.cfy.learn.algorithm.datastruct.common.exception.DataStructEmptyException;
import com.cfy.learn.algorithm.datastruct.common.link.SingleNode;
import com.cfy.learn.algorithm.datastruct.stack.Stack;

/**
 * @Description: 链表实现栈
 * @Author chenfuyuan
 * @Date 2021/3/23 15:21
 */
public class LinkedStack<Item> implements Stack<Item> {


    /**
     * 栈顶指针
     */
    private SingleNode<Item> head;

    /**
     * 元素个数
     */
    private int size;


    @Override
    public void push(Item element) {
        SingleNode<Item> newHead = new SingleNode<>(element);
        newHead.setNext(head);
        head = newHead;
        size++;
    }

    @Override
    public Item pop() {
        if (isEmpty()) {
            throw new DataStructEmptyException("栈为空;");
        }

        Item result = head.getValue();

        head = head.getNext();
        size--;

        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

}
