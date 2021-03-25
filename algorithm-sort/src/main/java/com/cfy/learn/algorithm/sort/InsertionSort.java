package com.cfy.learn.algorithm.sort;


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
     * @param array
     * @author chenfuyuan
     * @date 2021/3/25 14:48
     */
    public static void sort(Comparable[] array) {
        for (int i = 1, length = array.length; i < length; i++) {
            //保证第i位前有序，将第i位插入到合适的位置，并右移其他元素
            for (int j = i; j > 0 && less(array[j], array[j-1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }
}
