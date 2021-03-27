package com.cfy.learn.algorithm.sort;

import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.SortUtil;

/**
 * @Description: 优化后的希尔排序
 * @Author: chenfuyuan
 * @Date: 2021/3/26 19:13
 */
public class ShellBetterSort {


    /**
     * 希尔排序
     * @param array 数组
     */
    public static void sort(Comparable[] array) {
        sort(array, ArrayUtil.START_INDEX,array.length);
    }

    /**
     * 希尔排序(局部排序,从startIndex开始，排序length个)
     * @param array 数组
     * @param startIndex 开始索引
     * @param length 排序长度
     */
    public static void sort(Comparable[] array,int startIndex,int length) {
        int endIndex = SortUtil.getEndIndex(startIndex, array.length, length);

        //根据递增序列生成h
        //h = length/3
        int h = 1; //初始值修改为1,防止当数组长度为2时，不进行 递增序列的生成，直接结束
        while (h < length / 3) {
            h = 3 * h + 1;
        }

        //数组中，每间隔h个索引归为同一个子序列，针对各个子序列进行排序。保证子序列局部有序
        //每次循环逐渐缩每个子序列的大小。直到1
        while (h > 0) {
            //i初始值取h,跳过第一个子序列第一个元素
            for (int i = startIndex+h; i <= endIndex; i++) {
                //j>=h 保证数组不会越界
                Comparable temp = array[i];
                int j = i;
                for (; j >=startIndex+h && SortUtil.less(temp, array[j - h]); j -= h) {
                    array[j] = array[j-h];
                }
                array[j] = temp;

            }
            h /= 3;
        }
    }
}
