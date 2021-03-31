package com.cfy.learn.algorithm.sort;

import com.uptool.core.stdlib.StdRandom;
import com.uptool.core.util.SortUtil;

import java.util.Comparator;

/**
 * @Description: 三向切片快速排序
 * @Author: chenfuyuan
 * @Date: 2021/3/31 13:43
 */
public class QuickThreeWaySort extends SortUtil {

    /**
     * 快速排序整个数组
     * @param array 数组
     */
    public static void sort(Comparable<?>[] array) {
        sort(array,0,array.length);
    }


    /**
     * 快速排序局部数组
     * @param array 数组
     * @param startIndex 开始索引
     * @param length 排序长度
     */
    public static void sort(Comparable<?>[] array, int startIndex, int length) {
        int endIndex = getEndIndex(startIndex, array.length, length);
        StdRandom.shuffle(array);
        sortCore(array, startIndex,endIndex);
    }

    /**
     * 快速排序核心
     * @param array 数组
     * @param low 低索引
     * @param hight 高索引
     */
    private static void sortCore(Comparable[] array, int low, int hight) {
        if (low >= hight) {
            return;
        }

        //三分切片方法
        //切片完后，满足
        //a[low...left-1] 都小于array[left]
        //a[left...right]=sentinel 都相等
        //a[right+1...hight] 都大于array[right]
        int left = low, right = hight;
        Comparable sentinel = array[low];
        int i = low+1;
        while (i<=right) {
            int cmp = array[i].compareTo(sentinel);
            if (cmp < 0) {
                exch(array,left++,i++);
            } else if (cmp > 0) {
                exch(array, right--, i);
            } else {
                i++;
            }
        }

        sortCore(array,low,left-1);
        sortCore(array,right+1, hight);
    }


}
