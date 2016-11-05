/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-list-ii
@Language: Java
@Datetime: 16-10-02 20:57
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
     * @return: ListNode head of the linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode (0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode runner = head;
        while(cur != null && cur.next != null){
            if(cur.val == cur.next.val){
                runner = cur.next;
                while(runner != null && cur.val == runner.val){
                    runner = runner.next;
                }
                pre.next = runner;
                cur = runner;
            }else{
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
            }
        }
        
        return dummy.next;
    }
}
