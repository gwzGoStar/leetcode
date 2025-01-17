package leetcode_142_circleList2;

//  题目:  环形链表;
//        给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//
//        为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
//        如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
//
// 说明：不允许修改给定的链表。
//
// 进阶： 你是否可以使用 O(1) 空间解决此题？

public class Solution1 {
    public ListNode detectCycle(ListNode head) {
          if(head == null ) return null;
          ListNode fast = head;
          ListNode slow = head;
//         下面循环条件不能用 while(fast != null && fast.next != null) 此条件用来内层判断跳出循环并返回null;
          while(true){
              if(fast == null || fast.next == null) return null;
              fast = fast.next.next;
              slow = slow.next;
              if(slow == fast) break;
          }
          fast = head;
          while(fast != slow){
              fast = fast.next;
              slow = slow.next;
          }
          return fast;
    }
}
