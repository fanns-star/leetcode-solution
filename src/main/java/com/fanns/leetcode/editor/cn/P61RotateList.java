package com.fanns.leetcode.editor.cn;
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 109 
// 
// Related Topics 链表 双指针 
// 👍 517 👎 0

public class P61RotateList{
    public static void main(String[] args) {
        Solution solution = new P61RotateList().new Solution();
        // TO TEST
    }
        //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }

            //计算链表长度和尾节点
            int length = 0;
            ListNode temp = head;
            ListNode tail = null;
            while (temp != null) {
                length++;
                if (temp.next == null) {
                    tail = temp;
                }
                temp = temp.next;
            }

            //首位相连形成圆环
            tail.next = head;
            ListNode newTail = head;
            int x = length - (k % length);
            //找到新的尾结点
            for (int i = 1; i < x; i++) {
                newTail = newTail.next;
            }
            //找到新的头结点
            ListNode newHead = newTail.next;
            //断开头结点和尾结点的连接
            newTail.next = null;
            return newHead;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
//leetcode submit region end(Prohibit modification and deletion)

}