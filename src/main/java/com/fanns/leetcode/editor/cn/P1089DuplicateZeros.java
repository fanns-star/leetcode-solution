package com.fanns.leetcode.editor.cn;
//给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。 
//
// 注意：请不要在超过该数组长度的位置写入元素。 
//
// 要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。 
//
// 
//
// 示例 1： 
//
// 输入：[1,0,2,3,0,4,5,0]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
// 
//
// 示例 2： 
//
// 输入：[1,2,3]
//输出：null
//解释：调用函数后，输入的数组将被修改为：[1,2,3]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10000 
// 0 <= arr[i] <= 9 
// 
// Related Topics 数组 
// 👍 74 👎 0

import java.util.Stack;

public class P1089DuplicateZeros{
    public static void main(String[] args) {
        Solution solution = new P1089DuplicateZeros().new Solution();
        int[] array = new int[]{1,0,0,2,3,0,4};
        solution.duplicateZeros(array);
        for (int i : array) {
            System.out.print(i + ",");
        }
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//      方案1
//    public void duplicateZeros(int[] arr) {
//        Stack<Integer> stack = new Stack<>();
//        for (int j = arr.length - 1; j >= 0; j--) {
//            stack.push(arr[j]);
//        }
//
//        int i = 0;
//        while (i < arr.length) {
//            int temp = stack.pop();
//            arr[i] = temp;
//            i++;
//            if (temp == 0 && i < arr.length) {
//                arr[i] = 0;
//                i++;
//            }
//        }
//    }
    public void duplicateZeros(int[] arr) {
        int[] tempArr = arr.clone();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = tempArr[j];
            if (tempArr[j++] == 0 && i < tempArr.length - 1) {
                arr[++i] = 0;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}