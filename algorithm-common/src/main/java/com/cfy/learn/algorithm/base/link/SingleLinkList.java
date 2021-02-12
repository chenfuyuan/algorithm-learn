package com.cfy.learn.algorithm.base.link;

import java.util.function.Consumer;

import static com.uptool.core.util.EmptyUtil.isEmpty;
import static com.uptool.core.util.EmptyUtil.isNotEmpty;


/**
 * @Description: 链式存储 线性表
 * @Author chenfuyuan
 * @Date 2021/2/12 11:07
 */
public class SingleLinkList<T> {
    /**
     * 大小
     */
    private int size = 0;
    /**
     * 节点
     */
    private SingleNode<T> head;

    /**
     * 容量
     * @return 容量
     */
    public int size() {
        return this.size;
    }

    /**
     * 获取头节点
     * @return
     */
    public SingleNode<T> getHead() {
        return head;
    }

    /**
     * 设置头节点
     * @param head
     */
    public void setHead(SingleNode<T> head) {
        this.head = head;
    }

    /**
     * 遍历
     * @param operate 操作
     */
    public void forEach(Consumer<T> operate) {
        if (operate == null) {
            throw new RuntimeException("遍历时，操作为空");
        }

        SingleNode<T> point = head;
        while (isNotEmpty(point)) {
            operate.accept(point.getValue());
            point = point.getNext();
        }
    }

    /**
     * 遍历
     */
    public void forEach() {
        forEach(System.out::println);
    }




    public static class Builder<T> {

        private T[] array;

        public Builder setValues(T... array) {
            this.array = array;
            return this;
        }

        public SingleLinkList<T> build() {
            if (isEmpty(array)) {
                return buildEmptyList();
            }
            SingleLinkList<T> result = new SingleLinkList();
            result.size = array.length;

            SingleNode<T> head = new SingleNode<>(array[0]);
            result.head = head;
            SingleNode<T> now = head;
            for (int i = 1, length = array.length; i < length; i++) {
                T value = array[i];
                SingleNode<T> next = new SingleNode<>(value);
                now.setNext(next);
                now = next;
            }

            return result;
        }


        /**
         * 构建空链表
         */
        private SingleLinkList buildEmptyList() {
            SingleLinkList result = new SingleLinkList();
            result.size = 0;
            result.head = null;
            return result;
        }


    }


}
