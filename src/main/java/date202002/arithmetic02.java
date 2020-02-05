package date202002;

import org.junit.Test;

/**
 * @author 褚超亮
 * @date 2020/2/4 18:44
 */
public class arithmetic02 {

    /**
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 示例 1:
     * 给定数组 nums = [1,1,2],
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * 你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 2:
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * 你不需要考虑数组中超出新长度后面的元素。
     */
    @Test
    public void test() {
        int[] nums = new int[]{1, 1, 1, 1, 1, 1, 2};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 题解：
     *  因为数组是一个排序数组，可以声明两个类似于指针的i和j，其中i是慢指针，j是快指针。只要nums[i] == nums [j]就增加j以跳过重复项。
     *  当遇到nums[j] != nums[i]时，把nums[j]的值复制到nums[i+1]。然后递增i，重复，直到j到达数组的末尾为止。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
