package date202002;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author 褚超亮
 * @date 2020/2/12 19:13
 */
public class arithmetic10 {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意你不能在买入股票前卖出股票。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    @Test
    public void test() {
        int[] prices = new int[]{2, 4, 1};
        System.out.println(maxProfit3(prices));
    }

    /**
     * 方法1：暴力破解法 双重for循环
     * 求差值 max(prices[j]−prices[i])！！！
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int maxValue = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int temp = prices[j] - prices[i];
                if (temp > maxValue) {
                    maxValue = temp;
                }
            }
        }
        return maxValue;
    }

    /**
     * 方法2：
     * 寻找最小的值和大值的差值：峰谷 -- 可以画图看到
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        //int min = prices[0]; 防止数组为空 不能这样写，避免检测数组为空
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            // 判断值是否小于min （最小的）
            if (prices[i] < min) {
                // 替换
                min = prices[i];
            } else if (prices[i] - min > max) { // 不小则计算差值， 与之前的差值所比较取最大值！！！
                max = prices[i] - min;
            }
        }
        return max;
    }

    /**
     * 方法2 的另一种写法
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }
}
