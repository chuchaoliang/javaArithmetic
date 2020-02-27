package date202002;

import org.junit.Test;

/**
 * @author 褚超亮
 * @date 2020/2/24 18:39
 */
public class arithmetic21 {

    /**
     * 给定一个二进制数组， 计算其中最大连续1的个数。
     * <p>
     * 示例 1:
     * 输入: [1,1,0,1,1,1]
     * 输出: 3
     * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
     * <p>
     * 注意：
     * 输入的数组只包含 0 和1。
     * 输入数组的长度是正整数，且不超过 10,000。
     */
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    /**
     * 简单明了。。划水一天。。。。。。。
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxcount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                maxcount = Math.max(maxcount, count);
                count = 0;
            }
        }
        return Math.max(maxcount, count);
    }
}
