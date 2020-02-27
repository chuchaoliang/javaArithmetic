package date202002;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 褚超亮
 * @date 2020/2/23 18:46
 */
public class arithmetic20 {

    /**
     * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     * <p>
     * 示例:
     * 输入:
     * [4,3,2,7,8,2,3,1]
     * 输出:
     * [5,6]
     */
    @Test
    public void test() {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers2(nums).toString());
    }

    /**
     * 方法1：将数组保存到hashSet中，然后遍历
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        // 也可以使用hashMap来保存。。
        HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        LinkedList<Integer> targetList = new LinkedList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!numsSet.contains(i)) {
                targetList.add(i);
            }
        }
        return targetList;
    }

    /**
     * 方法2：替换法
     * 将nums[|nums[i]| - 1] 下标元素 x -1即可，最后遍历数组，如果不为负数则i + 1没出现过
     * 思想：
     * 4,3,2,7,8,2,3,1  数组1
     * 1,2,3,4,5,6,7,8  数组2
     * 上面是原数组，下面是序列数组；
     * 遇到上面的数字，就将数组2中同样数字给替换为：替换字符（随便设置，这里可以设为*），意思就是该数字已经出现过了；
     * 这样不断对照查找哪些元素出现过；则没被替换的就是没出现过的；
     * 这基本是最基本的逻辑；
     * <p>
     * 4,3,2,7,8,2,3,1
     * <p>
     * 依次类推替换
     * 1,2,3,*,5,6,7,8
     * 1,2,*,*,5,6,7,8
     * 1,*,*,*,5,6,7,8
     * 1,*,*,*,5,6,*,8
     * 1,*,*,*,5,6,*,*
     * 1,*,*,*,5,6,*,*  位置2已经替换过,不用再替换；
     * 1,*,*,*,5,6,*,*  位置3已经替换过,不用再替换；
     * *,*,*,*,5,6,*,*  此时5，6没被替换，说明5，6在数组1中没出现过；
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        // ArrayList数据结构为线性表、LinkedList数据结构是链表;
        // LinkedList是一个双向链表, 当数据量很大或者操作很频繁的情况下，添加和删除元素时具有比ArrayList更好的性能。
        LinkedList<Integer> numsList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                numsList.add(i + 1);
            }
        }
        return numsList;
    }

}
