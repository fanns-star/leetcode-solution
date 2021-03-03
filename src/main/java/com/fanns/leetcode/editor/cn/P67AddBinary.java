package com.fanns.leetcode.editor.cn;
//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 568 👎 0

public class P67AddBinary{
    public static void main(String[] args) {
        Solution solution = new P67AddBinary().new Solution();
        System.out.println(solution.addBinary("1001", "1"));
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        int salt = 0;
        int l = a.length() > b.length() ? a.length() : b.length();
        char[] results = new char[l];
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--, l--) {
            int m = i >= 0 ? a.charAt(i) == '0' ? 0 : 1 : 0;
            int n = j >= 0 ? b.charAt(j) == '0' ? 0 : 1 : 0;
            int k = m + n + salt;
            if (k > 1) {
                results[l - 1] = k > 2 ? '1' : '0';
                salt = 1;
            } else {
                results[l - 1] = k == 0 ? '0' : '1';
                salt = 0;
            }
        }

        String s = String.valueOf(results);
        return salt > 0 ? "1" + s : s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}