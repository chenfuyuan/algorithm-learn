package com.cfy.learn.algorithm.sort;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import com.uptool.core.util.SortUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: 排序测试类
 * @Author chenfuyuan
 * @Date 2021/3/24 15:03
 */
class SortTest {

    private String[] sortArray;

    private String[] rightArray;

    @BeforeEach
    public void setUp() {
        String input = "S O R T E X A M P L E";
        sortArray = input.split(GlobalConstant.SPACE_SPLIT);
        rightArray = input.split(GlobalConstant.SPACE_SPLIT);
        Arrays.sort(rightArray);
    }

    @Test
    public void testMain() {
        System.out.print("未排序前:");
        SortUtil.show(sortArray);
        //testSelectionSort(); 选择排序
        testInsertionSort();
        System.out.print("排序后:");
        SortUtil.show(sortArray);

        boolean result = SortUtil.isSorted(sortArray);
        System.out.println("排序结果是否正确:"+(result?"正确":"错误"));
    }

    public void testInsertionSort() {
        InsertionSort.sort(sortArray);
    }

    /**
     * 测试选择排序
     * @author chenfuyuan
     * @date 2021/3/25 14:55
     */
    @Test
    public void testSelectionSort() {
        SelectionSort.sort(sortArray);
    }


}