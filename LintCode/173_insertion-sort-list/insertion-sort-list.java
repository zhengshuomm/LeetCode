/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/insertion-sort-list
@Language: Java
@Datetime: 16-10-04 01:40
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
     * @param head: The first node of linked list.
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // write your code here
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode pre = dummy;
        ListNode next = head;
        while(head != null){
            while(pre.next != null && pre.next.val < head.val )
                pre = pre.next;
            next = head.next;
            head.next = pre.next;
            pre.next = head;
            head = next;
            pre = dummy;
        }
        return dummy.next;
    }
}