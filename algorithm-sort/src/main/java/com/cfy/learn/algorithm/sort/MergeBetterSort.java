package com.cfy.learn.algorithm.sort;

import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.SortUtil;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description: 归并排序优化版
 * @Author: chenfuyuan
 * @Date: 2021/3/27 21:29
 */
public class MergeBetterSort {


    /**
     * 使用归并算法给数组局部排序
     * @param array
     */
    public static void sort(Comparable[] array) {
        sort(array,0,array.length);
    }

    /**
     * 给数组局部排序
     * @param array 数组
     * @param startIndex 起始位置
     * @param length 长度
     */
    public static void sort(Comparable[] array,int startIndex,int length) {
        int endIndex = SortUtil.getEndIndex(startIndex, array.length, length);
        Comparable[] aux = new Comparable[length];
        sort(array,aux,startIndex,endIndex);
    }


    /**
     * 排序
     * @param array 排序数组
     * @param aux 辅助数组
     * @param low 低索引
     * @param hight 高索引
     */
    private static void sort(Comparable[] array, Comparable[] aux, int low, int hight) {
        if (hight <= low) {
            return;
        }

        int mid = low + (hight - low) / 2;

        if (hight - low <= 15) {
            InsertionBetterSort.sort(array, low, hight-low+1);
            return;
        }else{
            //排序左半部分
            sort(array, aux, low, mid);
            check(array,low,mid);
            //排序右半部分
            sort(array,aux,mid+1,hight);
            check(array,mid+1,hight);
            //进行归并
            merge(array,aux,low,mid,hight);
            check(array,low,hight);
        }

    }

    private static void check(Comparable[] array,int low,int hight) {
        int length = hight - low+1;
        boolean result = SortUtil.isSorted(array, low, length);
        if (!result) {
            System.out.printf("子数组{%d->%d}排序错误:",low,hight);
            SortUtil.show(array, low, length);
            Comparable[] clone = new Comparable[length];
            ArrayUtil.copy(array,clone,low,hight-low+1,ArrayUtil.START_INDEX);
            Arrays.sort(clone);
            System.out.print("数组应该为:");
            SortUtil.show(clone);
            throw new RuntimeException("校验错误");
        }
    }



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
    private static void merge(Comparable[] array, Comparable[] aux,int low, int mid, int hight) {

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
