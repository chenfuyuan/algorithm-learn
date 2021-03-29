package com.cfy.learn.algorithm.sort;

import com.cfy.learn.algorithm.util.Stopwatch;
import com.uptool.core.stdlib.StdOut;
import com.uptool.core.util.RandomUtil;
import com.uptool.core.util.SortUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @Description: 排序性能测试
 * @Author: chenfuyuan
 * @Date: 2021/3/25 15:10
 */
public class SortPerformanceTest {

    /**
     * 排序类1
     */
    private Class<?> class01;

    /**
     * 排序类2
     */
    private Class<?> class02;

    /**
     * 排序的数组
     */
    private Double[] sortArray;

    /**
     * 生成数组大小
     *
     * @author chenfuyuan
     * @date 2021/3/25 16:01
     */
    public int generateSize =100000;

    /**
     * 循环次数
     *
     * @author chenfuyuan
     * @date 2021/3/25 16:01
     */
    public int cycleSize = 300;

    @BeforeEach
    public void init() {
        class01 = MergeBetterSort.class;
        class02 = QuickSort.class;
    }

    @Test
    public void test() {
        StdOut.printf("For %s random Doubles\n", generateSize);
        double timeTotal01 = 0.0;
        double timeTotal02 = 0.0;

        for (int i = 0; i < cycleSize; i++) {
            sortArray = RandomUtil.generateDoubleArray(generateSize);
            timeTotal01 += sortTime(class01);
            timeTotal02 += sortTime(class02);

        }

        StdOut.printf("算法1:%s is %.1f times;\n", class01.getSimpleName(), timeTotal01);
        StdOut.printf("算法2:%s is %.1f times;\n", class02.getSimpleName(), timeTotal02);
        Class<?> fastSortClass = SortUtil.less(timeTotal01, timeTotal02) ? class01 : class02;
        StdOut.printf("算法:%s 较快;", fastSortClass.getSimpleName());

    }

    /**
     * 排序并计算花费多少秒
     *
     * @param sortClass
     * @return double
     * @author chenfuyuan
     * @date 2021/3/25 15:55
     */
    private double sortTime(Class<?> sortClass) {
        if (sortClass == null) {
            return 0d;
        }
        Double[] cloneArray = sortArray.clone();
        Stopwatch timer = new Stopwatch();
        SortFactory.sort(sortClass, cloneArray);
        return timer.elapsedTime();
    }


}
