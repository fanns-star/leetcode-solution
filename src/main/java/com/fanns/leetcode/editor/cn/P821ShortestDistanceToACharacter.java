package com.fanns.leetcode.editor.cn;
//给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。 
//
// 
//
// 示例： 
//
// 
//输入：S = "loveleetcode", C = 'e'
//输出：[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
// 
//
// 
//
// 提示： 
//
// 
// 字符串 S 的长度范围为 [1, 10000]。 
// C 是一个单字符，且保证是字符串 S 里的字符。 
// S 和 C 中的所有字母均为小写字母。 
// 
// 👍 173 👎 0

import java.util.ArrayList;
import java.util.List;

public class P821ShortestDistanceToACharacter{
    public static void main(String[] args) {
        Solution solution = new P821ShortestDistanceToACharacter().new Solution();
        int[] result = solution.shortestToChar("loveleetcodel", 'e');
        for (int i : result) {
            System.out.print(i + ",");
        }
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestToChar(String s, char c) {
        List<Integer> cIndex = new ArrayList<>();
        cIndex.add(Integer.MIN_VALUE);
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == c) {
                cIndex.add(i);
            }
        }
        cIndex.add(Integer.MAX_VALUE);

        int currentCIndex = 0;
        int[] results = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            long left = cIndex.get(currentCIndex);
            long right = cIndex.get(currentCIndex + 1);
            int distance = (int) Math.min(i - left, right - i);
            results[i] = distance;
            if (chars[i] == c) {
                currentCIndex++;
            }
        }
        return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}