package com.cfy.learn.algorithm.util;

import java.util.Random;

/**
 * @Description: 生成工具类
 * @Author chenfuyuan
 * @Date 2021/2/12 21:33
 */
public class GenerateArrayUtil {

    private static int DEFAULT_RANGE = 10;

    /**
     * 随机生成整型数组
     * @param size 数量
     * @return 生成结果
     */
    public static int[] generateRandomIntArray(int size) {
        return generateRandomIntArray(size, DEFAULT_RANGE);
    }

    /**
     * 随机生成整型数组
     * 范围 为  -range ~ +range
     * @param size 数量
     * @param range 数值范围
     * @return 生成结果
     */
    public static int[] generateRandomIntArray(int size,int range) {
        Random random = new Random();
        return random.ints(size,-range,range).toArray();
    }

    /**
     * 随机生成整型数组
     * @param size 数量
     * @return 生成结果
     */
    public static String[] generateRandomStringArray(int size) {
        return generateRandomStringArray(size, DEFAULT_RANGE);
    }

    /**
     * 随机生成整型数组
     * 范围 为  -range ~ +range
     * @param size 数量
     * @param range 数值范围
     * @return 生成结果
     */
    public static String[] generateRandomStringArray(int size,int range) {
        Random random = new Random();
        return random.ints(size, -range, range).mapToObj(item -> item + "").toArray(String[]::new);
    }
}
