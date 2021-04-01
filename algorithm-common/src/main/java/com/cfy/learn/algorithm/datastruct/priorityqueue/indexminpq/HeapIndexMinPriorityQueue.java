package com.cfy.learn.algorithm.datastruct.priorityqueue.indexminpq;

import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.SortUtil;

import static com.uptool.core.util.ArrayUtil.INT_EMPTY_VALUE;
import static com.uptool.core.util.ArrayUtil.SHRINK_SIZE_FACTOR;

/**
 * @Description: 堆实现的 索引优先队列
 * @Author: chenfuyuan
 * @Date: 2021/4/1 15:06
 */
public class HeapIndexMinPriorityQueue<Item extends Comparable<Item>> implements IndexMinPriorityQueue<Item> {

    /**
     * 堆
     */
    private int[] heap;

    /**
     * 索引数组
     */
    private int[] reverseHeap;

    /**
     * 值数组
     */
    private Item[] keyArray;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 容量
     */
    private int capacity;

    /**
     * 默认的堆容量
     */
    private static final int DEFAULT_CAPACITY = 16;


    /**
     * 根节点开始位置
     */
    private static final int ROOT_NODE_INDEX = 1;


    public HeapIndexMinPriorityQueue() {
        this(DEFAULT_CAPACITY);
    }

    public HeapIndexMinPriorityQueue(int capacity) {
        keyArray = (Item[]) ArrayUtil.newArray(capacity + ROOT_NODE_INDEX, Comparable.class);
        heap = new int[capacity + ROOT_NODE_INDEX];
        reverseHeap = new int[capacity + ROOT_NODE_INDEX];
        ArrayUtil.initArray(reverseHeap, ArrayUtil.INT_EMPTY_VALUE);
        ArrayUtil.initArray(heap, ArrayUtil.INT_EMPTY_VALUE);
        size = 0;
        this.capacity = capacity;
    }


    /**
     * 上浮元素
     * 使heap[index]的元素，上浮到相应位置
     * 保证heap[index/2] < heap[index]
     *
     * @param index 上浮元素索引
     */
    public void swim(int index) {
        while (index > 1 && less(index, index >> 1)) {
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
            if (j < size() && less(j + 1, j)) {
                j++;
            }
            if (!less(j, index)) {
                break;
            }
            exch(index, j);
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
        return SortUtil.less(keyArray[heap[i]], keyArray[heap[j]]);
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

    /**
     * 将新增元素插入堆中，并进行排序
     *
     * @param keyIndex 索引
     * @param item     元素
     */
    @Override
    public void insert(int keyIndex, Item item) {
        //进行扩容
        while (keyIndex > capacity || size >= capacity) {
            int oldCapacity = capacity;
            resize(capacity << 1);
            ArrayUtil.initArray(reverseHeap,INT_EMPTY_VALUE,oldCapacity+1,capacity-oldCapacity);
            ArrayUtil.initArray(heap,INT_EMPTY_VALUE,oldCapacity+1,capacity-oldCapacity);
        }
        //将元素插入到末尾
        heap[++size] = keyIndex;
        //将堆中索引放入对应的索引中
        reverseHeap[keyIndex] = size;
        keyArray[keyIndex] = item;
        swim(size);
    }


    /**
     * 改变对应索引的值
     * @param keyIndex 索引
     * @param item 元素
     */
    @Override
    public void change(int keyIndex, Item item) {
        keyArray[keyIndex] = item;
        swim(reverseHeap[keyIndex]);
        sink(reverseHeap[keyIndex]);
    }

    /**
     * 判断是否包含着队列中
     * @param keyIndex 索引
     * @return
     */
    @Override
    public boolean contains(int keyIndex) {
        //只需判断是否在逆转队列中即可
        return reverseHeap[keyIndex] != ArrayUtil.INT_EMPTY_VALUE;
    }

    /**
     * 删除值索引为keyIndex的元素
     * @param keyIndex 索引
     */
    @Override
    public void delete(int keyIndex) {
        int index = reverseHeap[keyIndex];
        //移动到最后
        exch(index, size--);
        setEmpty(keyIndex);
        swim(index);
        sink(index);
    }

    /**
     * 将值数组和逆向堆 对应索引的值设置为空
     * @param keyIndex 值的索引
     */
    private void setEmpty(int keyIndex) {
        keyArray[keyIndex] = null;
        reverseHeap[keyIndex] = ArrayUtil.INT_EMPTY_VALUE;
    }

    @Override
    public Item min() {
        return keyArray[heap[ROOT_NODE_INDEX]];
    }

    @Override
    public int minIndex() {
        return heap[ROOT_NODE_INDEX];
    }

    @Override
    public int delMin() {
        //最低索引
        int result = heap[ROOT_NODE_INDEX];
        //出队操作
        exch(ROOT_NODE_INDEX,size--);
        heap[size+1] = INT_EMPTY_VALUE;
        setEmpty(result);
        sink(ROOT_NODE_INDEX);
        //当数组元素个数 小于 容量乘以缩小比例时，进行缩容
        /*if (size <= capacity * SHRINK_SIZE_FACTOR) {
            resize(capacity>>1);
        }*/

        return result;
    }

    @Override
    public int size() {
        return size;
    }


    /**
     * 对队列进行扩容
     *
     * @param newCapacity 新容量
     */
    private void resize(int newCapacity) {
        heap = ArrayUtil.resize(heap, newCapacity + ROOT_NODE_INDEX);
        reverseHeap = ArrayUtil.resize(reverseHeap, newCapacity + ROOT_NODE_INDEX);
        keyArray = ArrayUtil.resize(keyArray, newCapacity + ROOT_NODE_INDEX);
        capacity = newCapacity;
    }
}
