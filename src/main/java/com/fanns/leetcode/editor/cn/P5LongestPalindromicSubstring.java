package com.fanns.leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3267 👎 0

import java.util.HashSet;
import java.util.Set;

public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        System.out.println(solution.longestPalindrome(
                "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        // TO TEST
    }
        //自己写的两个方法性能太差，参考官方解答 https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public String longestPalindrome(String s) {
                int n = s.length();
                boolean[][] dp = new boolean[n][n];
                String ans = "";
                for (int l = 0; l < n; ++l) {
                    for (int i = 0; i + l < n; ++i) {
                        int j = i + l;
                        if (l == 0) {
                            dp[i][j] = true;
                        } else if (l == 1) {
                            dp[i][j] = (s.charAt(i) == s.charAt(j));
                        } else {
                            dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                        }
                        if (dp[i][j] && l + 1 > ans.length()) {
                            ans = s.substring(i, i + l + 1);
                        }
                    }
                }
                return ans;
            }

        }

//leetcode submit region end(Prohibit modification and deletion)
    //递归的这种方式性能太差
    class Solution1 {
        private Set<String> notPalindrome = new HashSet<>();
        public String longestPalindrome(String s) {
            if (isPalindrome(s)) {
                return s;
            }

            String s1 = longestPalindrome(s.substring(0, s.length() - 1));
            String s2 = longestPalindrome(s.substring(1));
            return s1.length() > s2.length() ? s1 : s2;
        }

        public boolean isPalindrome(String s) {
            if (notPalindrome.contains(s)) {
                System.out.println(s);
                return false;
            }
            char[] chars = s.toCharArray();
            if (chars.length <= 1) {
                return true;
            }
            int middle = chars.length % 2 == 0 ? chars.length / 2 : chars.length / 2 + 1;
            for (int i = 0; i <= middle; i++) {
                if (chars[i] != chars[chars.length - i - 1]) {
                    notPalindrome.add(s);
                    return false;
                }
            }
            return true;
        }

    }

    //性能一样差
    class Solution2 {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            String result = "";
            for (int i = 0; i < chars.length; i++) {
                for (int j = chars.length; j > i; j--) {
                    String s1 = s.substring(i, j);
                    if (isPalindrome(s1)) {
                        result = s1.length() > result.length() ? s1 : result;
                    }
                }
            }
            return result;
        }

        public boolean isPalindrome(String s) {
            char[] chars = s.toCharArray();
            if (chars.length <= 1) {
                return true;
            }
            int middle = chars.length % 2 == 0 ? chars.length / 2 : chars.length / 2 + 1;
            for (int i = 0; i <= middle; i++) {
                if (chars[i] != chars[chars.length - i - 1]) {
                    return false;
                }
            }
            return true;
        }

    }

}