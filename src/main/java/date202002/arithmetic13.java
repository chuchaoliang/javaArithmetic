package date202002;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author 褚超亮
 * @date 2020/2/16 18:56
 */
public class arithmetic13 {

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * <p>
     * 示例 1:
     * 输入: [3,2,3]
     * 输出: 3
     * <p>
     * 示例 2:
     * 输入: [2,2,1,1,1,2,2]
     * 输出: 2
     */
    @Test
    public void test() {
        System.out.println(majorityElement1(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement2(new int[]{2, 2, 1, 1, 1, 2, 2}));
        System.out.println(majorityElement3(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    /**
     * 方法1：利用HashMap
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        HashMap<Integer, Integer> numsHashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (numsHashMap.get(nums[i]) != null) {
                numsHashMap.put(nums[i], numsHashMap.get(nums[i]) + 1);
            } else {
                numsHashMap.put(nums[i], 1);
            }
        }
        for (Integer integer : numsHashMap.keySet()) {
            if (numsHashMap.get(integer) > nums.length / 2) {
                return integer;
            }
        }
        return -1;
    }

    /**
     * 方法2：暴力法 两次循环遍历
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        for (int num : nums) {
            int count = 0;
            for (int i : nums) {
                if (num == i) {
                    count++;
                }
            }
            if (count > nums.length / 2) {
                return num;
            }
        }
        return -1;
    }

    /**
     * 方法3：Boyer-Moore 投票算法 十分巧妙！
     * 众数记为+1，其它数记为-1 他们相加是一定大于0的！！！
     *
     * @param nums
     * @return
     */
    public int majorityElement3(int[] nums) {
        int count = 0;
        Integer target = null;
        for (int num : nums) {
            if (count == 0) {
                target = num;
            }
            count += (num == target) ? 1 : -1;
        }
        return target;
    }
}
