/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-lists
@Language: Java
@Datetime: 16-10-03 03:16
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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            } else if (right == null) {
                return -1;
            }
            return left.val - right.val;
        }
    };
    
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        if(lists.size() == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator) ;
        
        for(ListNode list : lists){
            if(list != null)
                queue.add(list);
        }
        ListNode cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            pre.next = cur;
            pre = pre.next;
            if(cur.next != null){
                queue.add(cur.next);
            }
        }
        return dummy.next;
    }
}
