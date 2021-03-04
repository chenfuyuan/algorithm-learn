package com.cfy.learn.test;

import com.cfy.learn.algorithm.base.link.SingleLinkList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Vito.Chen
 * @Date 2021/2/12 13:03
 */
@DisplayName("单链表测试")
public class SingleLinkListTest {

    @Test
    public void testBuild() {
        String[] strArray = new String[]{"1","2","3"};
        SingleLinkList.Builder builder = new SingleLinkList.Builder();
        SingleLinkList linkList = builder.setValues(strArray).build();
        linkList.forEach();
    }

    @Test
    public void testReversal() {



    }
}
