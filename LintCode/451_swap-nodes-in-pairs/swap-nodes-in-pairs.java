/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/swap-nodes-in-pairs
@Language: Java
@Datetime: 16-10-03 20:43
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
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
            // Write your code here
        //not sorted array
        if(head == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null && cur.next != null){
            
            pre = swap(pre, cur.next.next);
            cur = pre.next;

        }

        return dummy.next;
    }

    public ListNode swap(ListNode start, ListNode end){
        ListNode cur = start.next;
        ListNode last = cur.next;
        start.next = last;
        last.next = cur;
        cur.next = end;
        return cur;
    }
}