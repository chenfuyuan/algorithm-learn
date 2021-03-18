package com.cfy.learn.algorithm.base;

import com.cfy.learn.algorithm.datastruct.link.BilateralLinkList;
import com.cfy.learn.algorithm.base.link.ReversalUtil;
import com.cfy.learn.algorithm.datastruct.link.SingleLinkList;
import com.uptool.core.util.GenerateArrayUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Description: 测试翻转工具类
 * @Author Vito.Chen
 * @Date 2021/2/12 21:09
 */
@DisplayName("测试翻转工具类")
public class ReversalUtilTest {

    @Test
    public void testSingleLinkList() {
        String[] strArray = new String[]{"1","2","3","4","5"};
        SingleLinkList.Builder builder = new SingleLinkList.Builder();
        SingleLinkList linkList = builder.setValues(strArray).build();
        System.out.print("linkList 未翻转前->");
        linkList.forEach(item-> System.out.print(item+","));
        System.out.println("");

        ReversalUtil.reversal(linkList);
        System.out.print("linkList 翻转后->");
        linkList.forEach(item-> System.out.print(item+","));
    }

    @Test
    public void testBilateralLinkList() {
        String[] values = GenerateArrayUtil.generateRandomStringArray(10);
        BilateralLinkList.Builder builder = new BilateralLinkList.Builder();
        BilateralLinkList list = builder.setValues(values).build();
        System.out.print("头遍历开始");
        list.forEachToHead();
        System.out.println("头遍历结束");

        System.out.print("尾遍历开始");
        list.forEachToLast();
        System.out.println("尾遍历结束");

        ReversalUtil.reversal(list);

        System.out.println("翻转后");
        System.out.print("头遍历开始");
        list.forEachToHead();
        System.out.println("头遍历结束");

        System.out.print("尾遍历开始");
        list.forEachToLast();
        System.out.println("尾遍历结束");


    }
}
