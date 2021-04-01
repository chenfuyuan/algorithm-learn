package com.cfy.learn.algorithm.sort;

import com.uptool.core.util.SortUtil;

/**
 * @Description: 堆排序
 * @Author: chenfuyuan
 * @Date: 2021/4/1 18:03
 */
public class HeapSort extends SortUtil {

    public static void sort(Comparable<?>[] array) {
        int size = array.length;
        //只扫描一半，跳过大小为1的堆
        //循环结果，堆有序
        for (int k = size / 2 - 1; k >= 0; k--) {
            sink(array, k, size);
        }


        while (--size > 0 && !less(array[0],array[size])) {
            exch(array,0,size);
            sink(array,0,size);
        }

    }

    /**
     * 获取父节点索引
     * @param index 索引
     * @return 父节点索引
     */
    public static int getParentIndex(int index) {
        return (index << 1) + 1;
    }

    /**
     * 下层操作
     *
     * @param array 操作数组
     * @param index 操作元素位置，索引+1
     * @param size 大小
     */
    public static void sink(Comparable<?>[] array, int index, int size) {
        while (getParentIndex(index) < size) {
            int j = getParentIndex(index);
            if (j < size - 1 && SortUtil.less(array[j], array[j+1])) {
                j++;
            }
            if (less(array[j],array[index])) {
                break;
            }
            exch(array, index, j);
            index = j;
        }
    }



}
