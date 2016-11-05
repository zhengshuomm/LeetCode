/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/rotate-list
@Language: Java
@Datetime: 16-10-05 23:59
*/

/**
 * Definition for singly-linked list.
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
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
                if(head == null || head.next == null || k == 0) 
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = head;
        ListNode runner = head;
        int count = 1;
        while(runner.next != null){
            runner = runner.next;
            count ++;
        }
        k = k % count;
        if(k == 0) return head;
        for(int i = 1 ; i < count - k ; i ++){
            pre = pre.next;
        }
        
        
        dummy.next = pre.next;
        pre.next = null;
        runner.next = head;
        return dummy.next;
    }
}