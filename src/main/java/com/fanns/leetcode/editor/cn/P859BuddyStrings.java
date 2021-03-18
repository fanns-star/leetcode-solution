package com.fanns.leetcode.editor.cn;
//给定两个由小写字母构成的字符串 A 和 B ，只要我们可以通过交换 A 中的两个字母得到与 B 相等的结果，就返回 true ；否则返回 false 。 
//
// 交换字母的定义是取两个下标 i 和 j （下标从 0 开始），只要 i!=j 就交换 A[i] 和 A[j] 处的字符。例如，在 "abcd" 中交换下标
// 0 和下标 2 的元素可以生成 "cbad" 。 
//
// 
//
// 示例 1： 
//
// 
//输入： A = "ab", B = "ba"
//输出： true
//解释： 你可以交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 相等。 
//
// 示例 2： 
//
// 
//输入： A = "ab", B = "ab"
//输出： false
//解释： 你只能交换 A[0] = 'a' 和 A[1] = 'b' 生成 "ba"，此时 A 和 B 不相等。
// 
//
// 示例 3: 
//
// 
//输入： A = "aa", B = "aa"
//输出： true
//解释： 你可以交换 A[0] = 'a' 和 A[1] = 'a' 生成 "aa"，此时 A 和 B 相等。 
//
// 示例 4： 
//
// 
//输入： A = "aaaaaaabc", B = "aaaaaaacb"
//输出： true
// 
//
// 示例 5： 
//
// 
//输入： A = "", B = "aa"
//输出： false
// 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 20000 
// 0 <= B.length <= 20000 
// A 和 B 仅由小写字母构成。 
// 
// Related Topics 字符串 
// 👍 138 👎 0

import java.util.HashMap;
import java.util.Map;

public class P859BuddyStrings{
    public static void main(String[] args) {
        Solution solution = new P859BuddyStrings().new Solution();
        System.out.println(solution.buddyStrings("abcd", "badc"));
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String a, String b) {
        if (a.length() != b.length() || a.length() < 2) {
            return false;
        }
        if (a.equals(b)) {
            Map<Character, Integer> countMap = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                countMap.put(a.charAt(i), countMap.getOrDefault(a.charAt(i), 0) + 1);
            }
            for (Integer value : countMap.values()) {
               if (value >= 2) {
                   return true;
               }
            }
        } else {
            for (int i = 0; i < a.length() - 1; i++) {
                if (a.charAt(i) == b.charAt(i)) {
                    continue;
                }
                for (int j = i + 1; j < a.length(); j++) {
                    if (a.charAt(i) == b.charAt(j) && a.charAt(j) == b.charAt(i)) {
                       return a.substring(j + 1).equals(b.substring(j + 1));
                    }
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}