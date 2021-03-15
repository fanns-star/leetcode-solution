package com.fanns.leetcode.editor.cn;
//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 713 👎 0

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        int[][] array = new int[][]{{1,2,3,4}, {5,6,7,8},{9,10,11,12}};
        for (Integer i : solution.spiralOrder(array)) {
            System.out.println(i);
        }
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            Set<String> set = new HashSet<>();

            public List<Integer> spiralOrder(int[][] matrix) {
                if (matrix.length == 0) {
                    return new ArrayList<>();
                }
                return spiralOrder(matrix, 0);
            }

            private List<Integer> spiralOrder(int[][] matrix, int x) {
                List<Integer> result = new ArrayList<>();
                int i = x, j = x;
                while (j < matrix[0].length - x) {
                    int t = matrix[i][j];
                    String key = i + "-" + j;
                    if (!set.contains(key)) {
                        result.add(t);
                        set.add(key);
                    }
                    j++;
                }
                j--;
                i++;
                while (i < matrix.length - x && j == matrix[0].length - x - 1 && i > x) {
                    int t = matrix[i][j];
                    String key = i + "-" + j;
                    if (!set.contains(key)) {
                        result.add(t);
                        set.add(key);
                    }
                    i++;
                }
                i--;
                j--;
                while (j >= x && i == matrix.length - x - 1 && i > x) {
                    int t = matrix[i][j];
                    String key = i + "-" + j;
                    if (!set.contains(key)) {
                        result.add(t);
                        set.add(key);
                    }
                    j--;
                }
                i--;
                j++;
                while (i > x && j == x) {
                    int t = matrix[i][j];
                    String key = i + "-" + j;
                    if (!set.contains(key)) {
                        result.add(t);
                        set.add(key);
                    }
                    i--;
                }
                if ((matrix.length - x * 2) > 2 && (matrix[0].length - x * 2) > 2) {
                    result.addAll(spiralOrder(matrix, ++x));
                }
                return result;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)

}