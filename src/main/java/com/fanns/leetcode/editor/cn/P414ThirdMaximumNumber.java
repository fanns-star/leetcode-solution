package com.fanns.leetcode.editor.cn;
//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
// Related Topics 数组 
// 👍 208 👎 0

public class P414ThirdMaximumNumber{
    public static void main(String[] args) {
        Solution solution = new P414ThirdMaximumNumber().new Solution();
        System.out.println(solution.thirdMax(new int[]{1,2,3}));
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            if (nums.length <= 1) {
                return nums[0];
            }
            //统计到第几大的数了
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                //用冒泡排序
                for (int j = 0; j < nums.length - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
                if (i == 0 || nums[nums.length - 1 - i] != nums[nums.length - i]) {
                    count++;
                }
                if (count >= 3) {
                    return nums[nums.length - 1 - i];
                }
            }
            if (nums[0] != nums[1]) {
                count++;
            }
            return count == 3 ? nums[0] : nums[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}