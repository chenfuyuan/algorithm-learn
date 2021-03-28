package com.cfy.learn.algorithm.sort;

import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.SortUtil;

/**
 * @Description: 归并排序
 * @Author: chenfuyuan
 * @Date: 2021/3/26 20:00
 */
public class MergeSort extends MergeAbstractSort {

    /**
     * 使用归并算法给数组局部排序
     * @param array 数组
     */
    public static void sort(Comparable<?>[] array) {
        sort(array,0,array.length);
    }

    /**
     * 给数组局部排序
     * @param array 数组
     * @param startIndex 起始位置
     * @param length 长度
     */
    public static void sort(Comparable<?>[] array,int startIndex,int length) {
        int endIndex = SortUtil.getEndIndex(startIndex, array.length, length);
        Comparable<?>[] aux = new Comparable[length];
        sort(array,aux,startIndex,endIndex);
    }


    /**
     * 排序
     * @param array 排序数组
     * @param aux 辅助数组
     * @param low 低索引
     * @param hight 高索引
     */
    private static void sort(Comparable<?>[] array, Comparable<?>[] aux, int low, int hight) {
        if (hight <= low) {
            return;
        }

        int mid = low + (hight - low) / 2;

        //排序左半部分
        sort(array, aux, low, mid);

        //排序右半部分
        sort(array,aux,mid+1,hight);

        //进行归并
        merge(array,aux,low,mid,hight);
    }




}
