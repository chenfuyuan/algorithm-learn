package com.cfy.learn.algorithm.search.symboltable;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import com.uptool.core.stdlib.StdOut;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description: 符号表测试
 * @Author: chenfuyuan
 * @Date: 2021/4/3 14:33
 */
public class SymbolTableTest {


    /**
     * 符号表
     */
    private SymbolTable<String, Integer> symbolTable;

    /**
     * 输入数组
     */
    private String[] inputArray;

    @BeforeEach
    void setUp() {
        //symbolTable = new ;
        String input = "S E A R C H E X A M P L E";
        inputArray = input.split(GlobalConstant.SPACE_SPLIT);
    }

    public void testMain() {
        //填入符号表中
        for (int i = 0; i < inputArray.length; i++) {
            symbolTable.put(inputArray[i], i);
        }

        //遍历符号表
        Iterable<String> keys = symbolTable.keys();
        for (String key : keys) {
            StdOut.println(key + GlobalConstant.SPACE_SPLIT + symbolTable.get(key));
        }
    }
}