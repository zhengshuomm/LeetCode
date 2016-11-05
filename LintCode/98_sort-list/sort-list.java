/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/sort-list
@Language: Java
@Datetime: 16-10-03 02:44
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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null)
            return head;
        ListNode middle = getMiddle(head);
        ListNode second = middle.next;
        middle.next = null;
        
        ListNode left  = sortList(head);
        ListNode right  = sortList(second);
        
        return merge(left, right);
    }
    
    
    public ListNode merge(ListNode first, ListNode second){
        if(first == null)
            return second;
        if(second == null)
            return first;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(first != null && second != null){
            if(first.val > second.val){
                cur.next = second;
                second = second.next;
            }else{
                cur.next = first;
                first = first.next;
            }
            cur = cur.next;
        }
        
        if(first == null)
            cur.next =  second;
        if(second == null)
            cur.next = first;
        return dummy.next;
        
    }
    
    public ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next ;
            fast = fast.next.next;
        }
        return slow;
    }
}
