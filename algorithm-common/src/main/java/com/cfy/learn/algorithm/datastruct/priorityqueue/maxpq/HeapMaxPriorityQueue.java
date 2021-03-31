package com.cfy.learn.algorithm.datastruct.priorityqueue.maxpq;

import com.cfy.learn.algorithm.datastruct.priorityqueue.PriorityQueue;
import com.uptool.core.util.SortUtil;

/**
 * @Description: 堆实现的优先队列
 * @Author: chenfuyuan
 * @Date: 2021/3/31 14:51
 */
public abstract class HeapMaxPriorityQueue<Item extends Comparable<Item>> implements PriorityQueue<Item> {

    protected Item[] heap;

    /**
     * 上浮元素
     * 使heap[index]的元素，上浮到相应位置
     * 保证heap[index/2] > heap[index]
     *
     * @param index 上浮元素索引
     */
    public void swim(int index) {
        while (index > 1 && less(index >> 1, index)) {
            exch(index >> 1, index);
            //寻找父节点
            index >>= 1;
        }
    }

    /**
     * 下沉元素
     * 使heap[index]元素，下层到相应位置
     * 保证heap[index] > heap[index*2]和heap[index*2+1]
     *
     * @param index 下浮元素索引
     */
    public void sink(int index) {
        while (index << 1 <= size()) {
            //与子节点进行比较，与较大的子节点交换位置
            int j = 2 * index;
            if (j < size() && less(j, j + 1)) {
                j++;
            }
            if (!less(index, j)) {
                break;
            }
            exch(index,j);
            index = j;
        }
    }

    /**
     * 比较是否小于
     * heap[i] < heap[j]
     *
     * @param i 索引i
     * @param j 索引j
     */
    public boolean less(int i, int j) {
        return SortUtil.less(heap[i], heap[j]);
    }

    /**
     * 交换两个元素位置
     *
     * @param i 索引i
     * @param j 索引j
     */
    public void exch(int i, int j) {
        SortUtil.exch(heap, i, j);
    }

}
