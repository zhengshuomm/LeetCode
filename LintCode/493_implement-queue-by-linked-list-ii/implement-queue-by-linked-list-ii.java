/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/implement-queue-by-linked-list-ii
@Language: Java
@Datetime: 16-10-14 01:16
*/

public class Dequeue {
    ListNode start;
    ListNode end;
    public Dequeue() {
        // do initialize if necessary
    }

    public void push_front(int item) {
        // Write your code here
        ListNode node = new ListNode(item);
        if(start == null){
            start = node;
            end = node;
        }else{
            node.next = start;
            start = node;
        }
    }

    public void push_back(int item) {
        // Write your code here
        ListNode node = new ListNode(item);
        if(start == null){
            start = node;
            end = node;
        }else{
            end.next = node;
            end = end.next;;
        }
    }

    public int pop_front() {
        // Write your code here
        int top = start.val;
        if(start == end){
            start = end = null;
        }else
            start = start.next;
        return top;
        
    }

    public int pop_back() {
        // Write your code here
        int top = end.val;
        if(start == end){
            start = end = null;
        }else{
            ListNode pre = start;
            while(pre.next != end){
                pre = pre.next;
            }
            
            pre.next = null;
            end = pre;
        }
        return top;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode (int val){
        this.val = val;
        this.next = null;
    }
}