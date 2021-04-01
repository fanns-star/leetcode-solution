package com.fanns.leetcode.editor.cn;
//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 
// 👍 81 👎 0

public class P434NumberOfSegmentsInAString{
    public static void main(String[] args) {
        Solution solution = new P434NumberOfSegmentsInAString().new Solution();
        System.out.println(solution.countSegments("Hello, my name is John"));
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSegments(String s) {
        String trimmed = s.trim();
        if (trimmed.equals("")) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}