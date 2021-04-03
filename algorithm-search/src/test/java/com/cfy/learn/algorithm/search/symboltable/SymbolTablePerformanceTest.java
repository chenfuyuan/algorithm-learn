package com.cfy.learn.algorithm.search.symboltable;

import com.cfy.learn.algorithm.constant.GlobalConstant;
import com.uptool.core.stdlib.StdIn;
import com.uptool.core.stdlib.StdOut;
import org.junit.jupiter.api.BeforeEach;

/**
 * @Description: 符号表性能测试用例
 * @Author: chenfuyuan
 * @Date: 2021/4/3 14:40
 */
public class SymbolTablePerformanceTest {

    /**
     * 符号表
     */
    private static SymbolTable<String,Integer> symbolTable;

    /**
     * 初始化
     */
    private static void init() {
        //初始化符号表
    }

    public static void main(String[] args) {
        int minlen = Integer.parseInt(args[0]);
        init();
        while (!StdIn.isEmpty()) {
            //构造符号表并统计频率
            String word = StdIn.readString();
            //忽略较短的单词
            if (word.length() < minlen) {
                continue;
            }

            //记录单词出现频率
            if (!symbolTable.contains(word)) {
                symbolTable.put(word, 1);
            } else {
                symbolTable.put(word,symbolTable.get(word)+1);
            }
        }

        //找出出现频率最高的单词
        String max = " ";

        symbolTable.put(max, 0);
        for (String word : symbolTable.keys()) {
            if (symbolTable.get(word) > symbolTable.get(max)) {
                max = word;
            }
        }

        StdOut.println(max + GlobalConstant.SPACE_SPLIT + symbolTable.get(max));
    }


}
