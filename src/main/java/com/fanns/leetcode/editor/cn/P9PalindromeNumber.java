package com.fanns.leetcode.editor.cn;
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1396 👎 0

public class P9PalindromeNumber{
    public static void main(String[] args) {
        Solution solution = new P9PalindromeNumber().new Solution();
        System.out.println(solution.isPalindrome(111));
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String s = String.valueOf(x % 10);
        int temp = x / 10;
        while (temp > 0) {
            s = s + temp % 10;
            temp = temp / 10;
        }

        return s.equals(String.valueOf(x));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    class Solution1 {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }

            String s = String.valueOf(x);
            String[] strings = s.split("");
            for (int i = 0; i <= (strings.length - 1) / 2; i++) {
                if (!strings[i].equals(strings[strings.length - 1 -i])) {
                    return false;
                }
            }
            return true;
        }
    }
}