package date202002;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 褚超亮
 * @date 2020/2/11 18:34
 */
public class arithmetic09 {

    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例:
     * 输入: 3
     * 输出: [1,3,3,1]
     */
    @Test
    public void test() {
        System.out.println(getRow(5));
    }

    /**
     * 方法1：利用杨辉三角的公式 第(i+1)项是第i项的倍数=(n-i)/(i+1)
     *
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> triangle = new ArrayList<Integer>();
        // 第一位
        triangle.add(1);
        for (int i = 0; i < rowIndex; i++) {
            int add = triangle.get(triangle.size() - 1) * (rowIndex - i) / (i + 1);
            triangle.add(add);
        }
        return triangle;
    }
}
