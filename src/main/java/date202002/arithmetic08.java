package date202002;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 褚超亮
 * @date 2020/2/10 19:45
 */
public class arithmetic08 {

    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * <p>
     * 示例:
     * 输入: 5
     * 输出:
     * [
     *      [1],
     *     [1,1],
     *    [1,2,1],
     *   [1,3,3,1],
     *  [1,4,6,4,1]
     * ]
     */
    @Test
    public void test() {
        List<List<Integer>> triangle = generate(5);
        for (List<Integer> integers : triangle) {
            System.out.println(integers);
        }
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        // 如果numRows为0 则直接返回
        if (numRows == 0) {
            return triangle;
        }
        // 添加第一行，第一行一定为1
        triangle.add(new ArrayList<Integer>());
        triangle.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            // 需要添加的一行列表
            List<Integer> row = new ArrayList<Integer>();
            // 此数据的上一行列表
            List<Integer> prevRow = triangle.get(rowNum - 1);
            // 第一个数据必为1
            row.add(1);
            // 将新的数据上面的两个数据相加就是该数据
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            // 最后一个数据必为1
            row.add(1);
            // 将此行添加到列表中
            triangle.add(row);
        }
        return triangle;
    }
}
