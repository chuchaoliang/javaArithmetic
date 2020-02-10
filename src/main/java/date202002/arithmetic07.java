package date202002;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author 褚超亮
 * @date 2020/2/9 19:21
 */
public class arithmetic07 {

    /**
     * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
     * <p>
     * 说明:
     * <p>
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     * <p>
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * <p>
     * 输出: [1,2,2,3,5,6]
     */
    @Test
    public void test() {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = new int[nums1.length];
        System.arraycopy(nums1, 0, nums2, 0, nums1.length);
        System.out.println(Arrays.toString(nums2));
    }

    /**
     * 方法1：合并数组，并利用Arrays.sort()排序
     * 合并数组效率：System.arraycopy > clone > Arrays.copyOf > for循环
     * System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
     * 参数：
     * src - 源数组。
     * srcPos - 源数组中的起始位置。
     * dest - 目标数组。
     * destPos - 目标数据中的起始位置。
     * length - 要复制的数组元素的数量
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, n, m);
        Arrays.sort(nums1);
    }

    /**
     * 方法2：双指针法/ 从前往后
     * p1 指向nums1开头 p2 指向nums2开头,每一步将最小值放入到输出数组中
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1Copy[p1] < nums2[p2]) ? nums1Copy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
    }


    /**
     * 方法3：双指针法/ 从后往前 方法2的逆向思维（十分巧妙）降低了空间复杂度！！！
     * p1 指向nums1已有元素的末尾，p2指向nums2的末尾，p指向nums1的最后
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    /**
     * 方法3的再次简化 oh！oh（√）
     */
    public void merge4(int[] nums1, int m, int[] nums2, int n) {
        // 相当于 i = m + n - 1 n-- m--;
        int i = m-- + --n;
        while (n >= 0) {
            nums1[i--] = m > 0 && nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
    }
}
