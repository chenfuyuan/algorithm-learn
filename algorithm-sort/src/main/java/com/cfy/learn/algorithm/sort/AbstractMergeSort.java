package com.cfy.learn.algorithm.sort;

import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.SortUtil;

/**
 * @Description:
 * @Author: chenfuyuan
 * @Date: 2021/3/28 15:05
 */
public abstract class AbstractMergeSort extends SortUtil {
    /**
     * 对数组进行归并
     * 将数组 low->hight位置的数据，以mid为界，划分左右两边，对左右两个子数组进行合并
     * 前提: 左右两个子数组有序。
     * @param array 数组
     * @param aux 辅助数组
     * @param low 低
     * @param mid 中间
     * @param hight 高
     */
    protected static void merge(Comparable<?>[] array, Comparable<?>[] aux,int low, int mid, int hight) {

        int i = low;    //左边数组的索引
        int j = mid+1;   //右边数组的索引

        //拷贝数组[low->hight]位置的数据到辅助数组中
        ArrayUtil.copy(array,aux,low,hight-low+1);

        for (int k = low; k <= hight; k++) {
            //左数组用完
            if (i > mid) {
                array[k] = aux[j++];
                continue;
            }

            //右数组用完
            if (j > hight) {
                array[k] = aux[i++];
                continue;
            }

            if (SortUtil.less(aux[i], aux[j])) {
                array[k] = aux[i++];
            } else {
                array[k] = aux[j++];
            }
        }

    }
}
