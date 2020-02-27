package date202002;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 褚超亮
 * @date 2020/2/21 18:41
 */
public class arithmetic18 {

    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * <p>
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     */
    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        //int[] nums = new int[]{1, 0, 3, 12, 0};
        System.out.println(Arrays.toString(moveZeroes1(nums)));
    }

    /**
     * 方法1：双指针（1）
     * 快指针j 遍历数组，若非0，填充到慢指针i处，遍历结束后末尾补零
     *
     * @param nums
     */
    public int[] moveZeroes1(int[] nums) {
        int i = 0;
        // 只要不等于0，就直接赋值
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                nums[i++] = nums[j];
            }
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
        return nums;
    }


    /**
     * 方法2：双指针（2）
     * 快指针j 遍历数组，若非0，和慢指针i处交换元素即可
     *
     * @param nums
     */
    public void moveZeroes2(int[] nums) {
        for (int j = 0, i = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
