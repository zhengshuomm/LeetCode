/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/implement-queue-by-linked-list
@Language: Java
@Datetime: 16-10-14 00:20
*/

public class Queue {
    public ListNode last, first;


    
    public Queue() {
        // do initialize if necessary
        last = first = null;
    }

    public void enqueue(int item) {
        // Write your code here
        ListNode node = new ListNode(item);
        if(first == null){
            first = node;
            last = node;
        }else{
            last.next = node;
            last = last.next;
        }
    }

    public int dequeue() {
        // Write your code here
        int num = first.val;
        if(first == last){
            first = last = null;
        }else{
            first = first.next;
        }
        return num;
    }
}


    class ListNode{
        public ListNode next;
        public int val;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
    