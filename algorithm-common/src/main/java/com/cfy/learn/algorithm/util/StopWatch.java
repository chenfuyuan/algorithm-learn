package com.cfy.learn.algorithm.util;

/**
 * @Description: 计时器
 * @Author chenfuyuan
 * @Date 2021/1/18 1:28
 */
public class StopWatch {

    /**
     * 记录开始时间
     */
    private long start;


    /**
     * 构造器
     */
    public StopWatch() {
        init();
    }

    /**
     * 返回经过时间
     * @return 经过时间
     */
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start)/1000.0;
    }

    /**
     * 初始化开始时间
     */
    public void init() {
        start = System.currentTimeMillis();
    }

}
