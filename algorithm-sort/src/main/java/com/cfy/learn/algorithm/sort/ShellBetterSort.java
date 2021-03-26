package com.cfy.learn.algorithm.sort;

import com.uptool.core.util.SortUtil;

/**
 * @Description: 优化后的希尔排序
 * @Author: chenfuyuan
 * @Date: 2021/3/26 19:13
 */
public class ShellBetterSort {
    public static void sort(Comparable[] array) {
        int length = array.length;
        //根据递增序列生成h
        //h = length/3
        int h = 0;
        while (h < length / 3) {
            h = 3 * h + 1;
        }

        //数组中，每间隔h个索引归为同一个子序列，针对各个子序列进行排序。保证子序列局部有序
        //每次循环逐渐缩每个子序列的大小。直到1
        while (h > 0) {
            //i初始值取h,跳过第一个子序列第一个元素
            for (int i = h; i < length; i++) {
                //j>=h 保证数组不会越界
                Comparable temp = array[i];
                int j = i;
                for (; j >=h && SortUtil.less(temp, array[j - h]); j -= h) {
                    array[j] = array[j-h];
                }
                array[j] = temp;

            }
            h /= 3;
        }
    }
}
