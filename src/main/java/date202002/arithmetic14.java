package date202002;

import org.junit.Test;

/**
 * @author 褚超亮
 * @date 2020/2/17 19:53
 */
public class arithmetic14 {

    /**
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     * <p>
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * 说明:
     * <p>
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     */

    /**
     * 方法1：暴力破解
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            int num = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                int temp = nums[j];
                nums[j] = num;
                num = temp;
            }
        }
    }

    /**
     * 方法2：使用反转 => 旋转数组k次，意思就是：k%n个尾部元素被移动到头部，剩下的元素会依次向右移动
     * 思路：
     * 1.先将所有的元素反转
     * 2.反转前k个元素
     * 3.再反转后面-k个元素 就可以得到结果
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reversal(nums, 0, nums.length);
        reversal(nums, 0, k - 1);
        reversal(nums, k, nums.length - 1);
    }

    public void reversal(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start--;
            end++;
        }
    }


    /**
     * 方法3：使用额外数组
     * 用一个额外的数组来将每个元素放到正确的位置上，
     * 也就是原本数组里下标为 i 把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。
     * 然后把新的数组拷贝到原数组中。
     *
     * @param nums
     * @param k
     */
    public void rotate3(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * 方法4：环状替换法！！！！
     * 类似于让位子，有一个环形的座位，每个人跑到同一方向下距离自己k个位置的位置上，
     * 那么那个位置上的人同样需要跑到距离自己k个位置的位置上，直到所有的人都坐到了自己的后来的位置上。
     * 所有数都移动k个位置，不就是结果吗！！！
     *
     * @param nums
     * @param k
     */
    public void rotate4(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }
}
