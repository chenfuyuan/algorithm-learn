package com.cfy.learn.algorithm.sort;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import com.uptool.core.util.SortUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: 排序测试类
 * @Author chenfuyuan
 * @Date 2021/3/24 15:03
 */
class SortTest {

    private String[] sortArray;

    @BeforeEach
    public void setUp() {
        String input = "S O R T E X A M P L E";
        sortArray = input.split(GlobalConstant.SPACE_SPLIT);
    }

    @Test
    public void testSelectionSort() {
        System.out.print("未排序前:");
        SortUtil.show(sortArray);
        SelectionSort.sort(sortArray);
        System.out.print("排序后:");
        SortUtil.show(sortArray);
    }
}