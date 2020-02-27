package date202002;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 褚超亮
 * @date 2020/2/19 19:50
 */
public class arithmetic16 {

    /**
     * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [1,2,3,1], k = 3
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: nums = [1,0,1,1], k = 1
     * 输出: true
     * 示例 3:
     * <p>
     * 输入: nums = [1,2,3,1,2,3], k = 2
     * 输出: false
     */
    @Test
    public void test() {
        int[] nums1 = new int[]{1, 2, 3, 1};
        int[] nums2 = new int[]{1, 0, 1, 1};
        int[] nums3 = new int[]{1, 2, 3, 1, 2, 3};
        System.out.println(containsNearbyDuplicate2(nums1, 3));
        System.out.println(containsNearbyDuplicate2(nums2, 1));
        System.out.println(containsNearbyDuplicate2(nums3, 2));
    }

    /**
     * 方法1：暴力破解法 双重for循环
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && (j - i) <= k) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法2：散列表 利用哈希
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> numsHash = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // 判断set中是否存在
            if (numsHash.contains(nums[i])) {
                return true;
            }
            // 不存在则添加
            numsHash.add(nums[i]);
            // hashSet中的值大于 k 则删除最早添加的那个
            if (numsHash.size() > k) {
                numsHash.remove(nums[i - k]);
            }
        }
        return false;
    }
}
