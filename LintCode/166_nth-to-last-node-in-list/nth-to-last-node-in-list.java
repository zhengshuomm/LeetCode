/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/nth-to-last-node-in-list
@Language: Java
@Datetime: 16-10-04 02:13
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
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if(head == null) return head;
        ListNode runner = head;
        for(int i = 1; i < n; i ++){
            runner = runner.next;
        }
        while(runner.next != null){
            runner = runner.next;
            head = head.next;
        }
        return head;
    }
}
