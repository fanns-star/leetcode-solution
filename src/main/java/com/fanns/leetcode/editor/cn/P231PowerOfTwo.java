package com.fanns.leetcode.editor.cn;
//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 293 👎 0

public class P231PowerOfTwo{
    public static void main(String[] args) {
        Solution solution = new P231PowerOfTwo().new Solution();
        System.out.println(solution.isPowerOfTwo(32));
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) {
            return true;
        }
        if (n <= 0 || n % 2 != 0) {
            return false;
        }
        return isPowerOfTwo(n / 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}