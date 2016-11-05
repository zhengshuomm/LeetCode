/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/implement-stack-by-two-queues
@Language: Java
@Datetime: 16-10-13 03:28
*/

class Stack {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    
    
 // Push a new item into the stack
 public void push(int x) {
 // Write your code here
     q1.add(x);
 }

 // Pop the top of the stack
 public void pop() {
 // Write your code here
    while(q1.size() > 1){
        q2.offer(q1.poll());
    }
    q1.poll();
    swap();
 }

 // Return the top of the stack
 public int top() {
 // Write your code here
     while(q1.size() > 1){
        q2.offer(q1.poll());
    }
    int top = q1.peek();
    q2.offer(q1.poll());
    swap();
    return top;
 }

 // Check the stack is empty or not.
 public boolean isEmpty() {
 // Write your code here
    return (q1.isEmpty());
 } 
 
 public void swap(){
    Queue<Integer> tmp = q1;
    q1 = q2;
    q2 = tmp;
}

}