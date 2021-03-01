package com.fanns.leetcode.editor.cn;
//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 480 👎 0

public class P83RemoveDuplicatesFromSortedList{
    public static void main(String[] args) {
        Solution solution = new P83RemoveDuplicatesFromSortedList().new Solution();
        ListNode head = new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(3))));
        solution.deleteDuplicates(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode temp = head.next;
        while (temp != null) {
            if (temp.val == pre.val) {
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

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}