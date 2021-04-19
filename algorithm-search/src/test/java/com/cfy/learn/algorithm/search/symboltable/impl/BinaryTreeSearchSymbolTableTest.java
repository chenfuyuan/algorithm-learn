package com.cfy.learn.algorithm.search.symboltable.impl;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Description: 测试二叉搜索树
 * @Author: chenfuyuan
 * @Date: 2021/4/19 10:50
 */
public class BinaryTreeSearchSymbolTableTest {

    /**
     * 符号表
     */
    private BinaryTreeSearchSymbolTable<String, Integer> symbolTable;

    /**
     * 输入数组
     */
    private String[] inputArray;

    @BeforeEach
    void init() {
        String input = "S E A R C H E X A M P L E";
        inputArray = input.split(GlobalConstant.SPACE_SPLIT);

        symbolTable = new BinaryTreeSearchSymbolTable<>();
    }

    @Test
    public void test() {
        //testPut
        for (int i = 0; i < inputArray.length; i++) {
            symbolTable.put(inputArray[i],i);
        }
        check(symbolTable);

        //testGet
        //testGet();


        //testDelete
        /*symbolTable.delete("E");
        check(symbolTable);*/

        //testMinAndMax
        testMinAndMax();

        testFloor();
    }

    private void testGet() {
        for (int i = 0; i < inputArray.length; i++) {
            int index = symbolTable.get(inputArray[i]);
            System.out.printf("key{%s}=%d\n",inputArray[i],index);
        }
    }

    private void testFloor() {
        System.out.println("floor(S) = "+symbolTable.floor("S"));
        System.out.println("floor(A) = "+symbolTable.floor("A"));
        System.out.println("floor(C) = "+symbolTable.floor("C"));
        System.out.println("floor(D) = "+symbolTable.floor("D"));
        System.out.println("floor(Y) = "+symbolTable.floor("Y"));
        System.out.println("floor(T) = "+symbolTable.floor("T"));
    }

    private void testMinAndMax() {
        System.out.printf("min=%s\n",symbolTable.min());
        System.out.printf("max=%s\n",symbolTable.max());
    }

    private void check(BinaryTreeSearchSymbolTable<String, Integer> symbolTable) {
        symbolTable.check();
    }

}