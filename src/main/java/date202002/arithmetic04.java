package date202002;

import org.junit.Test;

/**
 * @author 褚超亮
 * @date 2020/2/6 18:38
 */
public class arithmetic04 {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * <p>
     * 示例 2:
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * <p>
     * 示例 3:
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * <p>
     * 示例 4:
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */
    @Test
    public void test() {
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(searchInsert1(nums, 2));
        System.out.println(searchInsert2(nums, 2));
    }

    /**
     * 方法1 暴力解法 遍历一遍数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == target) {
                return j;
            } else if (nums[j] < target) {
                i++;
            }
        }
        return i;
    }

    /**
     * 方法2 二分查找法（1）
     * 先设定左侧下标left 和 右侧下标right ，在计算中间下标mid
     * 每次根据nums[mid] 和target 之间的 大小进行判断，相等则直接返回下标，
     * nums[mid] < target 则left右移， nums[mid] > target 则right左移
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            // >>> 无符号右移1位相当于 /2 但是比/2效率高
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 方法3 二分查找法（2）
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert3(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}
