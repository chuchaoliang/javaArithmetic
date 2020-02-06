package date202002;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 褚超亮
 * @date 2020/2/5 19:05
 */
public class arithmetic03 {

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1:
     * 给定 nums = [3,2,2,3], val = 3,
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 2:
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * 注意这五个元素可为任意顺序。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 2, 3};
        //System.out.println(removeElement1(nums, 3));
        System.out.println(removeElement2(nums, 3));
    }

    /**
     * 方法1：
     * 双指针法，i慢指针，j快指针
     * 当nums[j] != val 的时候将nums[j]赋值给nums[i] 并且 i++ 知道数组全部遍历为止
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * 方法2：
     * while循环，当nums[i] == val 时将nums[n-1]赋值给nums[i] 并且n-- 否则 i++
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return n;
    }
}
