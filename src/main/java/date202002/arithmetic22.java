package date202002;

import org.junit.Test;

import java.util.ArrayList;

/**
 * @author 褚超亮
 * @date 2020/2/25 18:29
 */
public class arithmetic22 {

    /**
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * F(0) = 0,   F(1) = 1
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     * 给定 N，计算 F(N)。
     *
     * 示例 1：
     * 输入：2
     * 输出：1
     * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
     *
     * 示例 2：
     * 输入：3
     * 输出：2
     * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
     *
     * 示例 3：
     * 输入：4
     * 输出：3
     * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
     * @CCL:这道题目有很多种解法，只写出了3种
     */
    @Test
    public void test() {
        System.out.println(fib1(30));
        System.out.println(fib2(30));
        System.out.println(fib3(30));
    }

    /**
     * 方法1：递归求解
     * 简单明了。但是效率非常低。。
     *
     * @param N
     * @return
     */
    public int fib1(int N) {
        if (N <= 1) {
            return N;
        } else {
            return fib1(N - 1) + fib1(N - 2);
        }
    }

    /**
     * 方法2：自底向上计算(1)
     * 思想：
     * 自底向上计算出值，并保存起来，避免重复计算；
     *
     * @param N
     * @return
     */
    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        // 列表保存（也可用数组来保存数据）
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        // 每次计算出前面两个值相加，最后得到的就是结果
        for (int i = 0; i < N; i++) {
            list.add(list.get(i) + list.get(i + 1));
        }
        return list.get(N);
    }

    /**
     * 方法3：自底向上计算(2)
     * 思想：
     * 利用两个中间变量保存计算的结果，第二种方法类似（同为保存起来计算的值只是方法略不同）
     *
     * @param N
     * @return
     */
    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }
        int current = 0;
        int prev1 = 1;
        int prev2 = 1;
        for (int i = 3; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}
