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

    private String[] sortArray;

    private Class SortClass;

    private Integer low;

    private Integer length;

    private static int sortArraySize = 1000;

    @BeforeEach
    public void setUp() {
        //String input = "S O R T E X A M P L E";
        /*String input = "T R L R B Y S F Q Z T R R K X J";
        sortArray = input.split(GlobalConstant.SPACE_SPLIT);*/

        sortArray = RandomUtil.generateCapitalLetterArray(sortArraySize);

        low = 0;
        length = sortArray.length;

        //SortClass = SelectionSort.class;    //选择排序
        //SortClass = InsertionSort.class;    //插入排序
        //SortClass = InsertionBetterSort.class;    //优化后的插入排序
        //SortClass = ShellSort.class;    //希尔排序
        //SortClass = ShellBetterSort.class;    //优化后的希尔排序
        //SortClass = MergeSort.class;    //归并排序
        SortClass = MergeBetterSort.class;

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

    private boolean sortByAll() {
        String[] cloneArray = new String[sortArray.length];
        ArrayUtil.copy(sortArray,cloneArray);
        SortFactory.sort(SortClass,cloneArray);
        System.out.print("排序后:");
        SortUtil.show(cloneArray);

        boolean result = SortUtil.isSorted(cloneArray);
        System.out.println("排序结果是否正确:"+(result?"正确":"错误"));
        return result;
    }

    private boolean sortByIndex() {
        String[] cloneArray = new String[sortArray.length];
        ArrayUtil.copy(sortArray,cloneArray);
        SortFactory.sort(SortClass,cloneArray,low,length);
        System.out.print("排序后:");
        SortUtil.show(cloneArray);

        boolean result = SortUtil.isSorted(cloneArray,low,length);
        System.out.println("排序结果是否正确:"+(result?"正确":"错误"));
        return result;
    }



}