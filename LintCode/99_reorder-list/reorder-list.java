/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/reorder-list
@Language: Java
@Datetime: 16-10-03 01:06
*/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null )
            return;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        slow.next = null;
        
        ListNode pre = null;
        while(second != null){
            ListNode tmp = second.next;
            second.next = pre;
            pre = second;
            second = tmp;
        }
        
        while(pre != null){
            slow = head.next;
            fast = pre.next;
            head.next = pre;
            pre.next = slow;
            head = slow;
            pre = fast;
        }
        return;
    }
}
