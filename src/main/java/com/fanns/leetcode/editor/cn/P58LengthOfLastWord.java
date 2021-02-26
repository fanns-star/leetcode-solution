package com.fanns.leetcode.editor.cn;
//给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。 
//
// 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "Hello World"
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：s = " "
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅有英文字母和空格 ' ' 组成 
// 
// Related Topics 字符串 
// 👍 280 👎 0

public class P58LengthOfLastWord{
    public static void main(String[] args) {
        Solution solution = new P58LengthOfLastWord().new Solution();
        System.out.println(solution.lengthOfLastWord("a a  "));
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int lengthOfLastWord(String s) {
                char[] chars = s.toCharArray();
                int length = 0;
                for (int i = chars.length - 1; i >= 0; i--) {
                    if (chars[i] != ' ') {
                        length++;
                    } else if (chars[i] == ' ' && length == 0) {
                        continue;
                    } else {
                        return length;
                    }
                }
                return length;
            }
        }
//leetcode submit region end(Prohibit modification and deletion)
class Solution1 {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int tempLength = 0;
        int length = 0;
        for (char c : chars) {
            if (c == ' ') {
                length = tempLength > 0 ? tempLength : length;
                tempLength = 0;
            } else {
                tempLength++;
                length = tempLength;
            }
        }
        return length;
    }
}
}