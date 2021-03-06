package com.fanns.leetcode.editor.cn;
//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= k <= 50 
// 
// Related Topics 链表 
// 👍 551 👎 0

public class P203RemoveLinkedListElements{
    public static void main(String[] args) {
        Solution solution = new P203RemoveLinkedListElements().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode temp = head;
            ListNode pre = null;
            while (temp != null) {
                if (temp == head && temp.val == val) {
                    head = head.next;
                    pre = head;
                } else if (temp.val == val) {
                    pre.next = temp.next;
                } else {
                    pre = temp;
                }
                temp = temp.next;
            }
            return head;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}