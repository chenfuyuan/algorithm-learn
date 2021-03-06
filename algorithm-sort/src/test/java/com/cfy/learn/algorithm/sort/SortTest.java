package com.cfy.learn.algorithm.sort;


import com.cfy.learn.algorithm.constant.GlobalConstant;
import com.uptool.core.util.ArrayUtil;
import com.uptool.core.util.RandomUtil;
import com.uptool.core.util.SortUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Description: 排序测试类
 * @Author chenfuyuan
 * @Date 2021/3/24 15:03
 */
class SortTest {

    /**
     * 排序数组
     */
    private String[] sortArray;

    /**
     * 排序类
     */
    private Class<?> SortClass;


    /**
     * 排序开始位置
     */
    private Integer startIndex;

    /**
     * 操作排序长度
     */
    private Integer length;

    /**
     * 排序数组大小
     */
    private static int sortArraySize = 12;

    @BeforeEach
    public void setUp() {

        /*String input = "H A B C D E F G";
        sortArray = input.split(GlobalConstant.SPACE_SPLIT);*/
        sortArray = RandomUtil.generateCapitalLetterArray(sortArraySize);

        startIndex = 4;
        length = sortArray.length-startIndex;

        //SortClass = SelectionSort.class;    //选择排序
        //SortClass = InsertionSort.class;    //插入排序
        //SortClass = InsertionBetterSort.class;    //优化后的插入排序
        //SortClass = ShellSort.class;    //希尔排序
        //SortClass = ShellBetterSort.class;    //优化后的希尔排序
        //SortClass = MergeSort.class;    //归并排序
        //SortClass = MergeBetterSort.class;    //优化后的归并排序
        //SortClass = MergeUpSort.class;    //自顶向上的归并排序
        //SortClass = QuickSort.class;    //快速排序
        //SortClass = QuickBetterSort.class;    //取样快速排序
        //SortClass = QuickThreeWaySort.class;    //三向快速排序
        SortClass = HeapSort.class;    //堆排序
    }

    @Test
    public void testMain() {
        System.out.print("需要排序的数组:");
        SortUtil.show(sortArray);
        boolean resultIndex = sortByIndex();
        System.out.println("====================================");
        boolean resultAll = sortByAll();
        if (!resultIndex || !resultAll) {
            Arrays.sort(sortArray);
            System.out.print("排序正确的数组:");
            SortUtil.show(sortArray);
        }
    }

    /**
     * 调用方法，针对整个数组进行排序
     * @return 排序结果
     */
    private boolean sortByAll() {
        String[] cloneArray = new String[sortArray.length];
        ArrayUtil.copy(sortArray,cloneArray);
        SortFactory.sort(SortClass,cloneArray);
        System.out.print("排序后:");
        SortUtil.show(cloneArray);

        boolean result = SortUtil.isSorted(cloneArray);
        System.out.println("排序结果是否正确:"+(result?"正确":"错误"));
        if (!result) {
            Arrays.sort(sortArray);
            System.out.print("排序正确的数组:");
            SortUtil.show(sortArray);
        }
        return result;
    }

    /**
     * 调用方法，针对 startIndex开始length长度的数组进行排序
     * @return 排序结果
     */
    private boolean sortByIndex() {
        String[] cloneArray = new String[sortArray.length];
        ArrayUtil.copy(sortArray,cloneArray);
        SortFactory.sort(SortClass,cloneArray, startIndex,length);
        System.out.print("排序后:");
        SortUtil.show(cloneArray);
        //ABFHHIMUVV
        //BFMHAVIVHU
        boolean result = SortUtil.isSorted(cloneArray, startIndex,length);
        System.out.println("排序结果是否正确:"+(result?"正确":"错误"));
        if (!result) {
            String[] cloneRightArray = new String[length];
            ArrayUtil.copy(sortArray,cloneRightArray,startIndex,length,ArrayUtil.START_INDEX);
            Arrays.sort(cloneRightArray);
            System.out.print("排序正确的数组:");
            SortUtil.show(cloneRightArray);
        }
        return result;
    }



}