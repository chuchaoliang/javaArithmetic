package date202002;

import org.junit.Test;

/**
 * @author 褚超亮
 * @date 2020/2/13 19:18
 */
public class arithmetic11 {

    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * <p>
     * 示例 1:
     * 输入: [7,1,5,3,6,4]
     * 输出: 7
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
     * <p>
     * 示例 2:
     * 输入: [1,2,3,4,5]
     * 输出: 4
     * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
     * <p>
     * 示例 3:
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    @Test
    public void test() {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        int[] prices1 = new int[]{1, 7, 2, 3, 6, 7, 6, 7};
        System.out.println(maxProfit1(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit2(prices1));
        System.out.println(maxProfit2(prices1));
    }

    /**
     * 方法1 峰谷法 可以画折线图 [7,1,5,3,6,4]
     * 找寻峰谷和此峰谷之后最高的峰，依次寻找即可
     *
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            // 寻找峰谷
            while (i < prices.length - 1 && prices[i] > prices[i + 1]) {
                i++;
            }
            valley = prices[i];
            // 寻找峰谷之后的最高峰
            while (i < prices.length - 1 && prices[i] < prices[i + 1]) {
                i++;
            }
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }

    /**
     * 方法2 方法1的优化（贪心算法） 这道题 根据“贪心” 来说有三种可能，正数 负数 和 0 利润最大化明显 选择正数，
     * 可以用贪心算法，大部分就可以用动态规划算法来解（目前还没研究动态规划）
     * 只要是上升就可以算是利润 ，简而言之就是图中所有的上升线段！！！
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 选择正数 则后一个数肯定大于前一个数
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

}
