package com.cfy.learn.algorithm.sort;

import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.SortUtil;

/**
 * @Description: 选择排序
 * @Author chenfuyuan
 * @Date 2021/3/24 14:46
 */
public class SelectionSort extends SortUtil {

    /**
     * 排序
     * 遍历数组，每次记录最小值的索引，遍历一遍后，将最小值与当前遍历位置进行替换
     *
     * @param array 数组
     */
    public static void sort(Comparable[] array) {
        sort(array, ArrayUtil.START_INDEX,array.length);
    }

    /**
     * 给数组局部排序
     * @param array 数组
     * @param startIndex 起始位置
     * @param length 结束位置
     */
    public static void sort(Comparable[] array,int startIndex,int length) {
        int endIndex = SortUtil.getEndIndex(startIndex,array.length,length);

        if (array.length <= 1) {
            return;
        }

        for (int i = startIndex; i <= endIndex; i++) {
            int minIndex = i;    //用于保持当前遍历情况，最小值索引
            for (int j = i + 1; j <= endIndex; j++) {
                if (less(array[j], array[minIndex])) {
                    minIndex = j;
                }
            }
            exch(array, i, minIndex);
        }
    }
}
