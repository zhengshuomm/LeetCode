/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/reverse-nodes-in-k-group
@Language: Java
@Datetime: 16-10-06 00:52
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
     * @param k an integer
     * @return a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here
        if(head == null || head.next == null || k < 2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode runner = head;
        while(runner != null){
            for(int i = 0 ; i < k ; i ++){
                if(runner != null)
                    runner = runner.next;
                else return dummy.next;
            }
            pre = reverse(pre, runner);
            runner = pre.next;
        }
        return dummy.next;
    }
    
    public ListNode reverse(ListNode pre, ListNode end){
        ListNode cur = pre.next;
        ListNode last = cur.next;
        while(last != end){
            cur.next = last.next;
            last.next = pre.next;
            pre.next = last;
            last = cur.next;
        }
        return cur;
    }
}