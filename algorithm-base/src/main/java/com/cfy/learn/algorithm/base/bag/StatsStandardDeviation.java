package com.cfy.learn.algorithm.base.bag;

import com.cfy.learn.algorithm.datastruct.link.LinkedBag;
import com.uptool.core.util.CalculateUtil;
import com.uptool.core.util.NumberUtil;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

/**
 * @Description: 算法 P77 背包的典型用例
 * 计算标准输入中所有double值的平均值和样本标准差，如果标准输入中有N个数字，那么平均值为它们的和除以N,样本标准差为每个值和平均值之差的平方之和除以N-1之后的平方根
 * @Author chenfuyuan
 * @Date 2021/3/18 18:47
 */
public class StatsStandardDeviation {

    public static void main(String[] args) {
        LinkedBag<Double> numberBag = new LinkedBag<>();

        //读取输入
        while (!StdIn.isEmpty()) {
            numberBag.add(StdIn.readDouble());
        }

        double sum = 0d;
        Iterator<Double> iterator = numberBag.iterator();
        while (iterator.hasNext()) {
            double value = iterator.next();
            sum = CalculateUtil.add(sum, value);
        }

        //平均值
        double average = CalculateUtil.divide(sum, numberBag.size());
        StdOut.println("平均值为:" + NumberUtil.fixScale(average));
        //样本标准差为每个值和平均值之差的平方之和除以N-1之后的平方根
        double standardDeviationSum = NumberUtil.DOUBLE_ZERO;
        iterator = numberBag.iterator();
        while (iterator.hasNext()) {
            double value = iterator.next();
            /*每个值和平均值之差的平方之和*/
            standardDeviationSum = CalculateUtil.add(
                    /*每个值和平均值之差的平方*/
                    Math.pow(CalculateUtil.subtract(value,average),2)
                    ,standardDeviationSum);
        }
        StdOut.println("每个值和平均值之差的平方之和:" + NumberUtil.fixScale(standardDeviationSum));
        double standardDeviation = Math.sqrt(standardDeviationSum/ (numberBag.size() - 1));
        StdOut.println("标准差:" + NumberUtil.fixScale(standardDeviation));

    }
}
