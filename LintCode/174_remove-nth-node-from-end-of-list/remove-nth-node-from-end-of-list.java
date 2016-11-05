/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/remove-nth-node-from-end-of-list
@Language: Java
@Datetime: 16-10-01 21:22
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
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode runner = head;
        ListNode pre = dummy;
        for(int i = 0 ; i < n ; i ++){
            runner = runner.next;
        }
        
        while(runner != null){
            runner = runner.next;
            pre = pre.next;
        }
        
        pre.next = pre.next.next;
        return dummy.next;
    }
}
