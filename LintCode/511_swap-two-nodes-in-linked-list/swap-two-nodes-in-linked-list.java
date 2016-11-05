/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/swap-two-nodes-in-linked-list
@Language: Java
@Datetime: 16-10-04 03:34
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
     * @oaram v1 an integer
     * @param v2 an integer
     * @return a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        // Write your code here
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode runner = dummy;
        while(runner.next != null){
            if(runner.next.val == v1){
                l1 = runner;
            }else if(runner.next.val == v2){
                l2 = runner;
            }
            if(l1 != null && l2 != null)
                break;
            runner = runner.next;
        }
        if(l1 == null || l2 == null)
            return dummy.next;
        if(l1.next == l2 || l2.next == l1){
            if(l1.next == l2){
                ListNode next = l2.next;
                l2.next = next.next;
                next.next = l2;
                l1.next = next;
            }else{
                ListNode next = l1.next;
                l1.next = next.next;
                next.next = l1;
                l2.next = next;
            }
            return dummy.next;
        }    
        
        ListNode first = l1.next;
        ListNode firstNext = first.next;
        ListNode second = l2.next;
        first.next = second.next;
        second.next = firstNext;
        l1.next = second;
        l2.next = first;
        
        
        return dummy.next;
    }
}