package com.cfy.learn.algorithm.sort;

import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.SortUtil;

/**
 * @Description: 堆排序
 * @Author: chenfuyuan
 * @Date: 2021/4/1 18:03
 */
public class HeapSort extends SortUtil {

    public static void sort(Comparable<?>[] array) {
        sort(array, ArrayUtil.START_INDEX, array.length);
    }

    public static void sort(Comparable<?>[] array, int startIndex, int length) {
        int size = length;
        int endIndex = getEndIndex(startIndex, array.length, length);
        //只扫描一半，跳过大小为1的堆
        //造堆
        for (int k = startIndex + size / 2 - 1; k >= startIndex; k--) {
            sink(array, k, endIndex, startIndex);
        }

        //摧毁堆
        while (endIndex >= startIndex && !less(array[startIndex], array[endIndex])) {
            //根为最大值，将最大值放到数组最后
            exch(array, startIndex, endIndex--);
            //对根节点进行下沉
            sink(array, startIndex, endIndex, startIndex);
        }
    }

    /**
     * 获取父节点索引
     * @param index 索引
     * @param offset 偏移量
     * @return 父节点索引
     */
    public static int getParentIndex(int index, int offset) {
        return (index << 1) + (1 - offset);
    }

    /**
     * 下层操作
     *
     * @param array 操作数组
     * @param index 操作元素位置，索引+1
     * @param offset 偏移量
     * @param endIndex  最后位置
     */
    public static void sink(Comparable<?>[] array, int index, int endIndex, int offset) {
        //遍历子节点
        while (getParentIndex(index, offset) <= endIndex) {
            //子节点
            int j = getParentIndex(index, offset);
            //对比2个子节点谁大
            if (j < endIndex && SortUtil.less(array[j], array[j + 1])) {
                //第二个子节点大，将索引指向第二个子节点
                j++;
            }
            //最大子节点与当前节点进行比较，小于退出循环,否则交换位置
            if (less(array[j], array[index])) {
                break;
            }
            exch(array, index, j);
            //索引移动到子节点，再次进行循环
            index = j;
        }
    }


}
