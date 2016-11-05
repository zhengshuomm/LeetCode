/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/rehashing
@Language: Java
@Datetime: 16-10-11 04:07
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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        if(hashTable == null || hashTable.length == 0)
            return hashTable;
        int capacity = hashTable.length;
        int newcap = capacity * 2;
        ListNode[] res = new ListNode[newcap];
        for(int i = 0; i < capacity ; i ++){
            while(hashTable[i] != null){
                int newIndex = (hashTable[i].val % newcap + newcap) % newcap;
                ListNode cur = new ListNode(hashTable[i].val);

                if(res[newIndex] == null){
                    res[newIndex] = cur;
                }else{
                    ListNode dummy = res[newIndex];
                    while (dummy.next != null) {
                        dummy = dummy.next;
                    }
                    dummy.next = cur;
                }
                hashTable[i] = hashTable[i].next;
            }
            
        }
        return res;
    }
};
