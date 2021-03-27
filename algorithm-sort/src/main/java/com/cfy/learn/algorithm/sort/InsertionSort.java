package com.cfy.learn.algorithm.sort;


import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.SortUtil;

/**
 * @Description: 插入排序
 * @Author: chenfuyuan
 * @Date: 2021/3/25 14:47
 */
public class InsertionSort extends SortUtil {

    /**
     * 插入排序
     *
     * @param array 数组
     * @author chenfuyuan
     * @date 2021/3/25 14:48
     */
    public static void sort(Comparable<?>[] array) {
        sort(array, ArrayUtil.START_INDEX,array.length);
    }

    /**
     * 对数组局部进行排序
     * @param array 数组
     * @param startIndex 起始位置
     * @param length 排序长度
     */
    public static void sort(Comparable<?>[] array,int startIndex ,int length) {
        int endIndex = SortUtil.getEndIndex(startIndex, array.length, length);

        for (int i = startIndex+1; i <= endIndex; i++) {
            //保证第i位前有序，将第i位插入到合适的位置，并右移其他元素
            for (int j = i; j > startIndex && less(array[j], array[j-1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }
}
