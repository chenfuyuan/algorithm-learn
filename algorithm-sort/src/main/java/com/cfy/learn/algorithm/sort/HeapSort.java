package com.cfy.learn.algorithm.sort;

import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.SortUtil;

/**
 * @Description: 堆排序
 * @Author: chenfuyuan
 * @Date: 2021/4/1 18:03
 */
public class HeapSort extends SortUtil {

    public static void sort(Comparable<?>[] array) {
        sort(array, ArrayUtil.START_INDEX, array.length);
    }

    public static void sort(Comparable<?>[] array, int startIndex, int length) {
        int size = length;
        int endIndex = getEndIndex(startIndex, array.length, length);
        //只扫描一半，跳过大小为1的堆
        //循环结果，堆有序
        for (int k = startIndex + size / 2 - 1; k >= startIndex; k--) {
            sink(array, k, endIndex, startIndex);
        }


        while (endIndex >= startIndex && !less(array[startIndex], array[endIndex])) {
            exch(array, startIndex, endIndex--);
            sink(array, startIndex, endIndex, startIndex);
        }
    }

    /**
     * 获取父节点索引
     *
     * @param index 索引
     * @return 父节点索引
     */
    public static int getParentIndex(int index, int startIndex) {
        return (index << 1) + (1 - startIndex);
    }

    /**
     * 下层操作
     *
     * @param array 操作数组
     * @param index 操作元素位置，索引+1
     * @param endIndex  最后位置
     */
    public static void sink(Comparable<?>[] array, int index, int endIndex, int startIndex) {
        while (getParentIndex(index, startIndex) <= endIndex) {
            int j = getParentIndex(index, startIndex);
            if (j < endIndex && SortUtil.less(array[j], array[j + 1])) {
                j++;
            }
            if (less(array[j], array[index])) {
                break;
            }
            exch(array, index, j);
            index = j;
        }
    }


}
