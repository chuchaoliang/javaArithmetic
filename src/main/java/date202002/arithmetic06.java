package date202002;

import org.junit.Test;

import java.awt.*;
import java.awt.font.NumericShaper;
import java.util.Arrays;

/**
 * @author 褚超亮
 * @date 2020/2/8 18:43
 */
public class arithmetic06 {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * <p>
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     */
    @Test
    public void test() {
        int[] digits1 = new int[]{1, 2, 3};
        int[] digits2 = new int[]{9, 9, 9};
        int[] digits3 = new int[]{0};
        System.out.println(Arrays.toString(plusOne2(digits1)));
    }

    /**
     * 方法1
     * 1、末位无进位，则末位直接加1即可 10 => 11
     * 2、末位有进位，在中间出进位停止，当前位后为0，前一位加1，直到不为0 199 => 200
     * 3、末位有进位，并且一直进位到第一位导致多出一位，单独处理。。999 => 1000
     *
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits) {
        int count = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
                count++;
            } else {
                digits[i] = digits[i] + 1;
                break;
            }
        }
        // 全部为 9 的情况 {9} {9,9} {9,9,9}
        int[] fdigits = new int[digits.length + 1];
        if (count == digits.length) {
            for (int i = 0; i < fdigits.length; i++) {
                if (i == 0) {
                    fdigits[i] = 1;
                } else {
                    fdigits[i] = 0;
                }
            }
            return fdigits;
        }
        return digits;
    }

    /**
     * 方法1 优化
     *
     * @param digits
     * @return
     */
    public int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}
