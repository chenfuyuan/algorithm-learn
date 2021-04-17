package com.cfy.learn.algorithm.datastruct.queue.linked;

import com.cfy.learn.algorithm.datastruct.common.exception.DataStructEmptyException;
import com.cfy.learn.algorithm.datastruct.common.link.LinkedIterator;
import com.cfy.learn.algorithm.datastruct.common.link.SingleNode;
import com.cfy.learn.algorithm.datastruct.queue.Queue;

import java.util.Iterator;

/**
 * @Description: 链表实现队列
 * @Author chenfuyuan
 * @Date 2021/3/23 15:55
 */
public class LinkedQueue<Item> implements Queue<Item> {

    /**
     * 元素个数
     */
    private int size;


    /**
     * 指向队头
     */
    private SingleNode<Item> first;

    /**
     * 指向队尾
     */
    private SingleNode<Item> last;

    @Override
    public void enqueue(Item element) {
        SingleNode<Item> oldLast = last;
        last = new SingleNode<>(element);
        //考虑队列为空时，last为NULL,新插入元素为队头也为队尾
        if (isEmpty()) {
            first = last;
        }else{
            //当队列不为空时，采用尾插法
            oldLast.insertNext(last);
        }
        size++;
    }

    @Override
    public Item dequeue() {
        if (isEmpty()) {
            throw new DataStructEmptyException("队列为空;");
        }

        //获取队头元素
        Item result = first.getValue();

        //进行出队操作
        first = first.getNext();

        //当队列出队后为空时，last置为空
        if (isEmpty()) {
            last = null;
        }

        size--;
        return result;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return first==null;
    }


    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator<>(first);
    }
}
