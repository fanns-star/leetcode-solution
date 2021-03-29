package com.fanns.leetcode.editor.cn;
//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 319 👎 0

import java.util.HashMap;
import java.util.Map;

public class P290WordPattern{
    public static void main(String[] args) {
        Solution solution = new P290WordPattern().new Solution();
        System.out.println(solution.wordPattern("ab", "cat dog"));
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length) {
            return false;
        }

        Map<Character, String> characterStringMap = new HashMap<>();
        Map<String, Character> stringCharacterMap = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            char c = pattern.charAt(i);
            String s1 = strings[i];

            String s2 = characterStringMap.getOrDefault(c, s1);
            char c1 = stringCharacterMap.getOrDefault(s1, c);
            if (!s1.equals(s2) || c1 != c) {
                return false;
            }
            characterStringMap.put(c, s1);
            stringCharacterMap.put(s1, c);
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}