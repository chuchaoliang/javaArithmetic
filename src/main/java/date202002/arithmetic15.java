package date202002;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 褚超亮
 * @date 2020/2/18 18:55
 */
public class arithmetic15 {

    /**
     * 给定一个整数数组，判断是否存在重复元素。
     * <p>
     * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3,1]
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: [1,2,3,4]
     * 输出: false
     * 示例 3:
     * <p>
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     */
    @Test
    public void test() {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicate1(nums));
        System.out.println(containsDuplicate2(nums));
        System.out.println(containsDuplicate3(nums));
    }

    /**
     * 方法1：暴力破解法
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 方法2：排序
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 方法3：哈希表
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> numsHash = new HashSet<>(nums.length);
        for (int num : nums) {
            if (numsHash.contains(num)) {
                return true;
            }
            numsHash.add(num);
        }
        return false;
    }
}
