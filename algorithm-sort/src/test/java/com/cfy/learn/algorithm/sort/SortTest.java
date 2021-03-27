package com.cfy.learn.algorithm.sort;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import com.uptool.core.util.SortUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @Description: 排序测试类
 * @Author chenfuyuan
 * @Date 2021/3/24 15:03
 */
class SortTest {

    private String[] sortArray;

    private Class SortClass;

    private Integer low;

    private Integer length;

    @BeforeEach
    public void setUp() {
        //String input = "S O R T E X A M P L E";
        String input = "M E R G E S O R T E X A M P L E";
        sortArray = input.split(GlobalConstant.SPACE_SPLIT);
        low = 0;
        length = 3;

        //SortClass = SelectionSort.class;    //选择排序
        //SortClass = InsertionSort.class;    //插入排序
        //SortClass = InsertionBetterSort.class;    //优化后的插入排序
        //SortClass = ShellSort.class;    //希尔排序
        //SortClass = ShellBetterSort.class;    //优化后的希尔排序
        //SortClass = MergeSort.class;    //归并排序
        SortClass = ShellSort.class;

    }

    @Test
    public void testMain() {
        System.out.print("未排序前:");
        SortUtil.show(sortArray);
        SortFactory.sort(SortClass,sortArray,low,length);
        System.out.print("排序后:");
        SortUtil.show(sortArray);

        boolean result = SortUtil.isSorted(sortArray,low,length);
        System.out.println("排序结果是否正确:"+(result?"正确":"错误"));


        setUp();
        System.out.print("未排序前:");
        SortUtil.show(sortArray);
        SortFactory.sort(SortClass,sortArray);
        System.out.print("排序后:");
        SortUtil.show(sortArray);

        result = SortUtil.isSorted(sortArray);
        System.out.println("排序结果是否正确:"+(result?"正确":"错误"));
    }




}