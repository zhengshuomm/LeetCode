/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/min-stack
@Language: Java
@Datetime: 16-10-10 03:51
*/

public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min;
    
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if(min.isEmpty())
            min.push(number);
        else if(min.peek() >= number){
            min.push(number);
        }
    }

    public int pop() {
        // write your code here
        int tmp = stack.pop();
        if(min.peek() == tmp)
            min.pop();
        return tmp ;
    }

    public int min() {
        // write your code here
        return min.peek();
    }
}
