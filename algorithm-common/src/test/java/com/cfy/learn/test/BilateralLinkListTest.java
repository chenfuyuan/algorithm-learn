package com.cfy.learn.test;

import com.cfy.learn.algorithm.datastruct.list.link.BilateralLinkList;
import com.uptool.core.util.GenerateArrayUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @Description: 测试双向链表
 * @Author Vito.Chen
 * @Date 2021/2/12 21:31
 */
@DisplayName("测试双向链表")
public class BilateralLinkListTest {

    @Test
    public void testBuild() {
        String[] values = GenerateArrayUtil.generateRandomStringArray(10);
        BilateralLinkList.Builder builder = new BilateralLinkList.Builder();
        BilateralLinkList list = builder.setValues(values).build();
        System.out.println("头遍历开始");
        list.forEachToHead();
        System.out.println("头遍历结束");

        System.out.println("尾遍历开始");
        list.forEachToLast();
        System.out.println("尾遍历结束");
    }



}
