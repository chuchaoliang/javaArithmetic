package date202002;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 褚超亮
 * @date 2020/2/27 18:17
 */
public class arithmetic24 {

    /**
     * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
     *
     * 示例 1:
     * 输入: [1,4,3,2]
     * 输出: 4
     * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
     *
     * 提示:
     * n 是正整数,范围在 [1, 10000].
     * 数组中的元素范围在 [-10000, 10000].
     */
    @Test
    public void test() {
        int[] nums = new int[]{1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
    }

    /**
     * 方法1：排序 代码没什么技术含量，关键在于证明
     *
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int account = 0;
        for (int i = 0; i < nums.length; i += 2) {
            account += nums[i];
        }
        return account;
    }


}
