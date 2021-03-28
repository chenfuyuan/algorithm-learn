package com.cfy.learn.algorithm.sort;

import com.uptool.core.util.SortUtil;

/**
 * @Description: 自顶向上的归并排序
 * @Author: chenfuyuan
 * @Date: 2021/3/28 14:47
 */
public class MergeUpSort extends MergeAbstractSort {

    /**
     * 使用归并算法给数组局部排序
     * @param array 数组
     */
    public static<T> void sort(Comparable<T>[] array) {
        sort(array,0,array.length);
    }

    /**
     * 给数组局部排序
     * @param array 数组
     * @param startIndex 起始位置
     * @param length 长度
     */
    public static<T> void sort(Comparable<T>[] array,int startIndex,int length) {
        int endIndex = SortUtil.getEndIndex(startIndex, array.length, length);
        Comparable<T>[] aux = new Comparable[array.length];
        for (int sz = 1; sz < length; sz <<= 1) {
            for (int lo = startIndex; lo <= endIndex - sz; lo += sz << 1) {
                merge(array, aux, lo, lo + sz - 1, Math.min(lo + (sz << 1) - 1, endIndex));
            }
        }
    }
}
