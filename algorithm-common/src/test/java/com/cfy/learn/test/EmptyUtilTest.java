package com.cfy.learn.test;

import com.cfy.learn.algorithm.datastruct.common.link.SingleNode;
import com.uptool.core.util.EmptyUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 判空工具类测试
 * @Author Vito.Chen
 * @Date 2021/2/12 11:23
 */
@DisplayName("测试判空工具类")
public class EmptyUtilTest {

    @Test
    public void test01() {
        int[] intArray = new int[10];
        double[] doubleArray = new double[10];
        long[] longArray = new long[10];
        System.out.println("intArry is Empty = "+ EmptyUtil.isNotEmpty(intArray));
        System.out.println("longArry is Empty = " +EmptyUtil.isNotEmpty(longArray));
        System.out.println("doubleArry is Empty = " +EmptyUtil.isNotEmpty(doubleArray));

        String[] stringArray = new String[10];
        stringArray[0] = "1";
        System.out.println("stringArry is Empty = "+EmptyUtil.isEmpty(stringArray));

        SingleNode[] nodes = new SingleNode[10];

        System.out.println(EmptyUtil.isNotEmpty(nodes));

    }

    @Test
    public void testCollection() {
        List<Integer> intList = new ArrayList<>();
        System.out.println("intList is Empty " + EmptyUtil.isNotEmpty(intList));
    }
}
