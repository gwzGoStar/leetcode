package leetcode_025_reverseNodeKgroups;

//  题目： K个一组反转链表；
//  描述： 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
//
//         k 是一个正整数，它的值小于或等于链表的长度。
//         如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
//示例：
//       给你这个链表：1->2->3->4->5
//       当 k = 2 时，应当返回: 2->1->4->3->5
//       当 k = 3 时，应当返回: 3->2->1->4->5
//说明：
//       你的算法只能使用常数的额外空间。
//        你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
//

public class Solution1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode pre = res;

        ListNode end = res;
        while(end.next != null){
            for(int i =0;i<k && end != null;i++) end = end.next;
            if(end == null) break;

            ListNode temp = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            start.next = temp;

            pre = start;
            end = pre;
        }
        return res.next;
    }
    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return cur;
    }
}
