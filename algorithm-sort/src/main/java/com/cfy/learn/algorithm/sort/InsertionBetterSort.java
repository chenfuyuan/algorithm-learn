package com.cfy.learn.algorithm.sort;

import static com.uptool.core.util.SortUtil.less;

/**
 * @Description: 优化插入排序
 * @Author: chenfuyuan
 * @Date: 2021/3/25 16:23
 */
public class InsertionBetterSort {
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
            if (less(array[i - 1], array[i])) {
                continue;
            }
            Comparable temp = array[i];
            int j = i;
            for (; j > 0 && less(temp, array[j-1]);) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }
}
