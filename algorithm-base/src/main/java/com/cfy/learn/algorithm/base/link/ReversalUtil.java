package com.cfy.learn.algorithm.base.link;

import com.cfy.learn.algorithm.util.NumberUtil;



import static com.cfy.learn.algorithm.util.EmptyUtil.isEmpty;
import static com.cfy.learn.algorithm.util.EmptyUtil.isNotEmpty;

/**
 * @Description: 翻转链表工具类
 * @Author chenfuyuan
 * @Date 2021/2/12 20:46
 */
public class ReversalUtil {

    /**
     * 翻转单链表
     * @param list 链表
     * @param <T> 数据类型
     */
    public static<T> void reversal(SingleLinkList<T> list) {
        if (isEmpty(list)) {
            return;
        }

        //当链表为0 或 1时，无需翻转
        if (list.size() == 0 || list.size() == 1) {
            return;
        }

        SingleNode<T> head = list.getHead();

        SingleNode<T> next;
        SingleNode<T> pre = null;
        while (isNotEmpty(head)) {
            next = head.getNext();
            head.setNext(pre);
            pre = head;
            head = next;
        }

        list.setHead(pre);
    }

    /**
     * 翻转双向链表
     * @param list 双向链表
     * @param <T> 数据类型
     */
    public static <T> void reversal(BilateralLinkList<T> list) {
        if (isEmpty(list)) {
            return;
        }

        if (list.size() == NumberUtil.ZERO || list.size() == NumberUtil.ONE) {
            return;
        }

        BilateralNode<T> nowNode = list.getHead();
        BilateralNode<T> head = list.getHead();


        BilateralNode<T> pre = null;
        BilateralNode<T> next = null;
        while (isNotEmpty(nowNode)) {
            pre = nowNode.getNext();
            nowNode.setNext(next);
            nowNode.setPre(pre);
            next = nowNode;
            nowNode = pre;
        }

        list.setHead(list.getLast());
        list.setLast(head);

    }
}
