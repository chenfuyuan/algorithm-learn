package com.cfy.learn.algorithm.sort;

import com.uptool.core.stdlib.StdOut;
import com.uptool.core.stdlib.StdRandom;
import com.uptool.core.util.SortUtil;

/**
 * @Description: 快速排序
 * @Author: chenfuyuan
 * @Date: 2021/3/29 15:20
 */
public class QuickSort extends SortUtil {

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
    private static void sortCore(Comparable<?>[] array, int low, int hight) {
        if (low >= hight) {
            return;
        }

        //切片 array[low ... partiton-1]<=array[partition]<=array[partition+1 ... hight]
        int partition = partition(array, low, hight);
        sortCore(array,low,partition-1);
        sortCore(array,partition+1, hight);
    }


    /**
     * 对数据进行切片
     * 保证 返回的索引 左部分小于它，右部分大于它
     * @param array 数组
     * @param low 低索引
     * @param hight 高索引
     * @return 居中部分
     */
    public static int partition(Comparable<?>[] array, int low, int hight) {
        int left = low, right = hight + 1;
        Comparable<?> temp;
        while (true) {
            //array[low]代表比较对象
            //左索引从左开始移动，移动到值不比array[low]索引小的位置
            while (less(array[++left], array[low])) {
                if (left >= hight) {
                    break;
                }
            }

            while (less(array[low], array[--right])) {
                if (right <= low) {
                    break;
                }
            }

            if (left >= right) {
                break;
            }

            temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }

        temp = array[low];
        array[low] = array[right];
        array[right] = temp;
        return right;
    }


}
