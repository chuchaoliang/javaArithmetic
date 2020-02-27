package date202002;

import org.junit.Test;

import java.util.TreeSet;

/**
 * @author 褚超亮
 * @date 2020/2/22 18:33
 */
public class arithmetic19 {

    /**
     * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
     * <p>
     * 示例 1:
     * 输入: [3, 2, 1]
     * 输出: 1
     * 解释: 第三大的数是 1.
     * <p>
     * 示例 2:
     * 输入: [1, 2]
     * 输出: 2
     * 解释: 第三大的数不存在, 所以返回最大的数 2 .
     * <p>
     * 示例 3:
     * 输入: [2, 2, 3, 1]
     * 输出: 1
     * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
     * 存在两个值为2的数，它们都排第二。
     */
    @Test
    public void test() {
        int[] nums = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax1(nums));
        System.out.println(thirdMax2(nums));
    }

    /**
     * 方法1：利用TreeSet可以确保集合元素处于排序状态
     * 思想：便利数组中元素，向set中添加元素（保证set中最大元素个数为3），如果超过3个移除第一个元素，
     * 若最后set中数据个数 <3 取最大（set.last），反之取最小的(set.first)
     * <p>
     * TreeSet常用方法：
     * set.first():取集合里面第一个元素;  set.last():取集合里面最后一个元素; set.headSet(n):输出小于n的集合;
     * set.tailSet(n):输出大于n的集合;   set.subSet(n,m):输出大于n，小于m的集合，惯例包左不包右;
     *
     * @param nums
     * @return
     */
    public int thirdMax1(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() < 3 ? set.last() : set.first();
    }

    /**
     * 方法2：
     * （1）利用3个变量来存放第一大、第二大、第三大的元素值，分别设置为one、two、three；
     * （2）遍历数组，若该元素比one大则往后移动元素，比two大则往后移动，比three大则赋值给three；(移动元素类似于移动数组：全部右移一位)
     * （3）最后得到第三大的元素，若不存在则返回第一大的元素；
     *
     * @param nums
     * @return
     */
    public int thirdMax2(int[] nums) {
        int one = nums[0];
        // 设置为int能够表示的最小值
        int two = Integer.MIN_VALUE;
        int three = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == one || nums[i] == two || nums[i] == three) {
                continue;
            }
            if (nums[i] > one) {
                three = two;
                two = one;
                one = nums[i];
            } else if (nums[i] > two) {
                three = two;
                two = nums[i];
            } else if (nums[i] > three) {
                three = nums[i];
            }
        }
        // 如果three 不等于 Inter.MIN_VALUE 说明存在第三大，否则不存在（必要条件是数组中不存在Integer.MIN_VALUE，存在小缺陷，推荐第一种方法）
        return three != Integer.MIN_VALUE ? three : one;
    }
}