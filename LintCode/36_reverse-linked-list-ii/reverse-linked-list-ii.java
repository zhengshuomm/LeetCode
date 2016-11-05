/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/reverse-linked-list-ii
@Language: Java
@Datetime: 16-10-02 22:12
*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
         ListNode dummy = new ListNode(0);
         dummy.next = head;
         ListNode pre = dummy;
         ListNode end = dummy;
         for(int i = 1; i < m; i ++){
             pre = pre.next;
         }
         
         for(int i = 0 ; i <= n ; i ++){
             end = end.next;
         }
         
         ListNode cur = pre.next;
         ListNode last = cur.next;
         while(last != end){
             cur.next = last.next;
             last.next = pre.next;
             pre.next = last;
             last = cur.next;
         }
         
         return dummy.next;
    }
}
