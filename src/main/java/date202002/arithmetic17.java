package date202002;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 褚超亮
 * @date 2020/2/20 18:16
 */
public class arithmetic17 {

    /**
     * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [3,0,1]
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [9,6,4,2,3,5,7,0,1]
     * 输出: 8
     * 说明:
     * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
     */
    @Test
    public void test() {
        //int[] nums = new int[]{3, 0, 1};
        int[] nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        //int[] nums = new int[]{0};
        System.out.println(missingNumber1(nums));
        System.out.println(missingNumber2(nums));
        System.out.println(missingNumber3(nums));
        System.out.println(missingNumber4(nums));
    }

    /**
     * 方法1：排序
     *
     * @param nums
     * @return
     */
    public int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] != 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果此数字是最后一个（i == nums.length - 1 必须在前面否则会出现异常）|| 或者nums[i] + 1 != nums[i + 1]
            if (i == nums.length - 1 || nums[i] + 1 != nums[i + 1]) {
                return nums[i] + 1;
            }
        }
        return -1;
    }

    /**
     * 方法2：哈希
     *
     * @param nums
     * @return
     */
    public int missingNumber2(int[] nums) {
        Set<Integer> numsHash = new HashSet<>();
        for (int num : nums) {
            numsHash.add(num);
        }
        // i< nums.length + 1 ：如果 是最后一个数 + 1。。。
        for (int i = 0; i < nums.length + 1; i++) {
            if (!numsHash.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 方法3：异或 ^ 相同为0 相反为1
     *
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int target = nums.length;
        for (int i = 0; i < nums.length; i++) {
            target ^= i ^ nums[i];
        }
        return target;
    }

    /**
     * 方法4：数学方法
     * 求出[0...n]的和，减去数组中所有数的和，就得到了缺失的数字。
     * @param nums
     * @return
     */
    public int missingNumber4(int[] nums) {
        int allSum = nums.length * (nums.length + 1) / 2;
        int numsSum = 0;
        for (int i = 0; i < nums.length; i++) {
            numsSum += nums[i];
        }
        return allSum - numsSum;
    }
}
