package date202002;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 褚超亮
 * @date 2020/2/26 18:37
 */
public class arithmetic23 {

    /**
     * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j),
     * 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
     *
     * 示例 1:
     * 输入: [3, 1, 4, 1, 5], k = 2
     * 输出: 2
     * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
     * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
     *
     * 示例 2:
     * 输入:[1, 2, 3, 4, 5], k = 1
     * 输出: 4
     * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
     *
     * 示例 3:
     * 输入: [1, 3, 1, 5, 4], k = 0
     * 输出: 1
     * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
     *
     * 注意:
     * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
     * 数组的长度不超过10,000。
     * 所有输入的整数的范围在 [-1e7, 1e7]。
     */
    @Test
    public void test() {
        int[] nums = new int[]{3, 1, 4, 1, 5};
        System.out.println(findPairs1(nums, 2));
        System.out.println(findPairs3(nums, 2));
    }

    /**
     * 方法1：暴力破解法
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs1(int[] nums, int k) {
        int target = 0;
        HashMap<Integer, Integer> numsHash = new HashMap<>(16);
        // 排序是因为想利用HashMap的特性（键值不会重复，如果不排序会出现问题：如果键一样就会覆盖前面的值例如 3,1,5 k = 2 （3，5）会覆盖（3,1））
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    // 存储到HashMap中是为了防止数组中出现的重复例如{3,1,4,1,5} 存在两个1 导致结果出错。
                    numsHash.put(nums[i], nums[j]);
                }
            }
        }
        for (Integer integer : numsHash.keySet()) {
            target++;
        }
        return target;
    }

    /**
     * 方法2：逆向思维思考问题
     * 思想：题目中说 |i - j| = k 这就相当于一个数轴，i在这个数轴上的一个位置，找i左边k个距离（i-k）和i右边k个距离（i+k）的值！！
     * 把其中的最小值、或最大值存储到HashSet（去除重复问题）中就可以
     * 最后hashSet.size()就是结果！
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs2(int[] nums, int k) {
        // 利用java8的stream流，转换为Integer列表
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (k == 0) {
                // ???? 特殊情况，没有想到更好的方法判断数组中重复出现的值 TODO 待解决 第三种方法存在一种解决方案但是不符合本种方法。
            }
            if (numsList.contains(num - k)) {
                hashSet.add(num - k);
            }
            if (numsList.contains(num + k)) {
                hashSet.add(num);
            }
        }
        return hashSet.size();
    }

    /**
     * 方法3：和方法2 思想一样，不过比较巧妙的方法来存储值
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(16);
        int count = 0;
        // k<0 || nums == null || nums.length < 2 都不符合
        if (k < 0) {
            return count;
        }
        for (int i = 0; i < nums.length; i++) {
            /**
             * 如果键不存在或者值为null 这两步骤就相当于给元素去重，由于键是Integer类型（排序），去重和排序
             * 这个0是为了让map有一个值，随便设置可设置为x，如果其中有重复元素，它的值就一定大于x+1，这也就是为k=0这种特殊情况而准备的！！！
             */
            map.putIfAbsent(nums[i], 0);
            map.put(nums[i], map.get(nums[i]) + 1);
        }
        // 遍历键
        for (int i : map.keySet()) {
            // 特殊情况
            if (k == 0) {
                if (map.get(i) > 1) {
                    count++;
                }
                //    由于HashMap自动给键排序，所以只需判断i+k是否存在就可以了
            } else if (map.containsKey(i + k)) {
                count++;
            }
        }
        return count;
    }
}
