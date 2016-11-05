/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/partition-list
@Language: Java
@Datetime: 16-10-01 22:28
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
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        ListNode lowStart = null;
        ListNode lowEnd = lowStart;
        ListNode highStart = null;
        ListNode highEnd = highStart;
        
        ListNode cur = head;
        ListNode next = cur;
        while(cur != null){
            next = cur.next;
            if(cur.val < x){
                if(lowStart == null){
                    lowStart = cur;
                    lowEnd = cur;
                }else{
                    lowEnd.next = cur;
                    lowEnd = lowEnd.next;
                }
                lowEnd.next = null;
            }else{
                if(highStart == null){
                    highStart = cur;
                    highEnd = cur;
                }else{
                    highEnd.next = cur;
                    highEnd = highEnd.next;
                }
                highEnd.next = null;
            }
            cur = next;
        }
        if(highStart == null)
            return lowStart;
        if(lowStart == null)
            return highStart;        
        lowEnd.next = highStart;
        return lowStart;
        
    }
}
