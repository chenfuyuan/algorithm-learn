package com.cfy.learn.algorithm.datastruct.list.link;

import com.cfy.learn.algorithm.datastruct.common.link.BilateralNode;

import java.util.function.Consumer;

import static com.uptool.core.util.EmptyUtil.isEmpty;
import static com.uptool.core.util.EmptyUtil.isNotEmpty;


/**
 * @Description: 双向链表
 * @Author Vito.Chen
 * @Date 2021/2/12 21:19
 */
public class BilateralLinkList<T> {

    /**
     * 默认遍历操作
     */
    private Consumer<T> DEFAULT_OPERATE = item -> System.out.print(item + " ");

    private int size = 0;
    /**
     * 头节点
     */
    private BilateralNode<T> head;

    /**
     * 尾节点
     */
    private BilateralNode<T> last;

    /**
     * 返回当前数据量
     * @return 数据量
     */
    public int size() {
        return size;
    }

    public BilateralNode<T> getHead() {
        return head;
    }

    public void setHead(BilateralNode<T> head) {
        this.head = head;
    }

    public BilateralNode<T> getLast() {
        return last;
    }

    public void setLast(BilateralNode<T> last) {
        this.last = last;
    }


    public void forEachToHead(Consumer<T> operate) {
        if (operate == null) {
            throw new RuntimeException("遍历时，操作为空");
        }

        BilateralNode<T> point = head;
        while (isNotEmpty(point)) {
            operate.accept(point.getValue());
            point = point.getNext();
        }
    }

    public void forEachToHead(){
        forEachToHead(DEFAULT_OPERATE);
    }

    public void forEachToLast() {
        forEachToLast(DEFAULT_OPERATE);
    }

    public void forEachToLast(Consumer<T> operate) {
        if (operate == null) {
            throw new RuntimeException("遍历时，操作为空");
        }

        BilateralNode<T> point = last;
        while (isNotEmpty(point)) {
            operate.accept(point.getValue());
            point = point.getPre();
        }
    }

    public static class Builder<T> {
        private T[] array;

        public Builder setValues(T... array) {
            this.array = array;
            return this;
        }


        public BilateralLinkList<T> build() {
            if (isEmpty(array)) {
                buildEmptyList();
            }

            BilateralLinkList<T> result = new BilateralLinkList<>();
            result.size = array.length;

            BilateralNode<T> head = new BilateralNode<>(array[0]);
            head.setNext(null);
            head.setPre(null);

            BilateralNode<T> nowNode = head;
            for (int i = 1, length = array.length; i < length; i++) {
                BilateralNode<T> node = new BilateralNode<>(array[i]);

                node.setPre(nowNode);
                node.setNext(null);
                nowNode.setNext(node);

                nowNode = node;
            }

            result.head = head;
            result.last = nowNode;

            return result;
        }

        /**
         * 构建空List
         * @return 返回空List
         */
        private BilateralLinkList<T> buildEmptyList() {
            BilateralLinkList<T> result = new BilateralLinkList<>();
            result.size = 0;
            result.head = null;
            result.last = null;
            return result;
        }
    }
}
