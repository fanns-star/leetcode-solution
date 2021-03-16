package com.fanns.leetcode.editor.cn;
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。 
//
// 
//
// 提示： 
//
// 
// num1 和num2 的长度都小于 5100 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式 
// 
// Related Topics 字符串 
// 👍 330 👎 0

public class P415AddStrings{
    public static void main(String[] args) {
        Solution solution = new P415AddStrings().new Solution();
        System.out.println(solution.addStrings("999", "11"));
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addStrings(String num1, String num2) {
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        int i = chars1.length - 1;
        int j = chars2.length - 1;
        StringBuilder sb = new StringBuilder();
        int salt = 0;
        while (i >= 0 || j >= 0) {
            int a = i >= 0 ? Character.getNumericValue(chars1[i]) : 0;
            int b = j >= 0 ? Character.getNumericValue(chars2[j]) : 0;
            int c = a + b + salt;
            salt = c >= 10 ? 1 : 0;
            sb.insert(0, (c >= 10 ? c - 10 : c));
            i--;
            j--;
        }
        return salt > 0 ? sb.insert(0, salt).toString() : sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}