/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/stack-sorting
@Language: Java
@Datetime: 16-10-19 01:18
*/

public class Solution {
    /**
     * @param stack an integer stack
     * @return void
     */
    public void stackSorting(Stack<Integer> stack) {
        // Write your code here
        if(stack == null || stack.size() < 2)
            return;
        Stack<Integer> secstack = new Stack<Integer>();
        while(!stack.isEmpty()){
            if(secstack.isEmpty() || secstack.peek() >= stack.peek()){
                secstack.push(stack.peek());
                stack.pop();
            }else{
                int value = stack.pop();
                while(!secstack.isEmpty() && secstack.peek() <= value){
                    stack.push(secstack.peek());
                    secstack.pop();
                }
                stack.push(value);
                while(!secstack.isEmpty()){
                    stack.push(secstack.peek());
                    secstack.pop();
                }
            }
        }
        while(!secstack.isEmpty()){
            stack.push(secstack.peek());
            secstack.pop();
        }
        return ;
    }
}