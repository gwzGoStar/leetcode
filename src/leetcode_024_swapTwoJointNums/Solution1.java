package leetcode_024_swapTwoJointNums;

//  题目： 两两交换链表元素；
//  描述： 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
//         你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//  示例：
//         输入：head = [1,2,3,4]
//         输出：[2,1,4,3]

//  思路一： 递归；

public class Solution1 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }
}
