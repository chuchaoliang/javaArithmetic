package date202002;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 褚超亮
 * @date 2020/2/3 21:22
 * 1-5
 */
public class arithmetic01 {

    /**
     * 给定一个整数数组 nums 和一个目标值target，在数组中找出和为目标值的那两个整数，并返回他们的数组下表。
     * 示例： 给定 nums = [2,7,11,15],target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回[0,1]
     */

    @Test
    public void test() {
        int[] num = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum2(num, 9)));
    }

    // 方法一
    public int[] twoSum1(int[] nums, int target) {
        // 暴力解方法 双重for循环判断
        int[] num = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    num[0] = i;
                    num[1] = j;
                }
            }
        }
        return num;
    }

    //方法二
    public int[] twoSum2(int[] nums, int target) {
        // 一遍哈希表解决
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            // 哈希表中是否有此键存在
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("没有解决方案");
    }
}
