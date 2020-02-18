package date202002;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 褚超亮
 * @date 2020/2/14 18:51
 */
public class arithmetic12 {

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     * <p>
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     * <p>
     * 说明:
     * <p>
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     * 示例:
     * <p>
     * 输入: numbers = [2, 7, 11, 15], target = 9
     * 输出: [1,2]
     * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */
    @Test
    public void test() {
        int[] numbers = new int[]{2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum1(numbers, 22)));
        System.out.println(Arrays.toString(twoSum2(numbers, 22)));
    }

    /**
     * 方法1：暴力破解法，显而易见。。
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                } else if (numbers[i] + numbers[j] > target) {
                    break;
                }
            }
        }
        return new int[]{};
    }

    /**
     * 方法2：双指针法
     * 因为是升序排列，所以初始指针 第一个指向开头（low）  第二个指向结尾（height），
     * 计算两数之和：
     * 若相等则得到唯一结果，
     * 若大于则第二个指针左移 重复计算
     * 若小于则第一个指针右移 重复计算 直到low 不小于 height
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        int low = 0;
        int height = numbers.length - 1;
        while (low < height) {
            if (numbers[low] + numbers[height] == target) {
                return new int[]{low + 1, height + 1};
            } else if (numbers[low] + numbers[height] > target) {
                height--;
            } else {
                low++;
            }
        }
        return new int[]{};
    }
}
