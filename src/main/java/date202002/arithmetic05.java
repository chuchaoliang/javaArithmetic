package date202002;

import org.junit.Test;

/**
 * @author 褚超亮
 * @date 2020/2/7 20:48
 */
public class arithmetic05 {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    @Test
    public void test() {
        int[] nums = new int[]{-1, 1, -3, 4, -1, 2, 1, -5, 4};
        //int[] nums = new int[]{-2, 1};
        System.out.println(maxSubArray1(nums));
        System.out.println(maxSubArray2(nums));
        System.out.println(maxSubArray3(nums));
    }

    /**
     * 方法1：暴力解法
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {
        int res = nums[0];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (res < temp) {
                    res = temp;
                }
            }
            temp = 0;
        }
        return res;
    }

    /**
     * 方法2 贪心算法
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];
        for (int i = 0; i < n; ++i) {
            // Math.max() 返回其中最大的值
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /**
     * 方法3 动态规划
     * @param nums
     * @return
     */
    public int maxSubArray3(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
