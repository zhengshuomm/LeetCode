/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/palindrome-linked-list
@Language: Java
@Datetime: 16-10-04 19:54
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
     * @return a boolean
     */
    public boolean isPalindrome(ListNode head) {
        // Write your code here
        if(head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        if(slow == fast){
            return slow.val == slow.next.val;
        }
        fast = slow.next;
        slow.next = null;
        fast = reverse(fast);
        while(fast != null){
            if(head == null) return false;
            if(head.val != fast.val) return false;
            head = head.next;
            fast = fast.next;
        }
        if(head == null || head.next == null) return true;
        return false;
    }
    
    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode pre = null;
        ListNode cur = head;
        while(head != null){
            ListNode tmp = head.next;
            head.next = pre;
            pre = head;
            head = tmp;
        }
        return pre;
    }
}