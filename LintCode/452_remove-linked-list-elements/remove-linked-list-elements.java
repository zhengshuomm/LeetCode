/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/remove-linked-list-elements
@Language: Java
@Datetime: 16-10-03 16:17
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @param val an integer
     * @return a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // Write your code here
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.val == val){
                while(cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;
            }
            pre = pre.next;
            if(cur != null)
                cur = cur.next;
            else break;
        }
        
        return dummy.next;
    }
}