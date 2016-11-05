/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/expression-expand
@Language: Java
@Datetime: 16-10-24 00:28
*/

public class Solution {
    /**
     * @param s  an expression includes numbers, letters and brackets
     * @return a string
     */
    public String expressionExpand(String s) {
        // Write your code here
        if(s == null || s.length() == 0)
            return s;
        StringBuilder result = new StringBuilder();
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Character> pareStack = new Stack<Character>();
        int num = 0;
        for(int i = 0 ; i < s.length(); i ++){
            if(s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9){
                num = num * 10 + (s.charAt(i) - '0');
            }else if(s.charAt(i) == '['){
                pareStack.push('[');
                numStack.push(num);
                num = 0;
            }else if (s.charAt(i) == ']'){
                StringBuilder cur = new StringBuilder();
                while(!pareStack.isEmpty() && pareStack.peek() != '['){
                    cur.append(pareStack.pop());
                }
                pareStack.pop();
                int count = numStack.pop();
                StringBuilder nextin = new StringBuilder();
                for(int j = 0 ; j < count; j ++)
                    nextin.append(cur);
                for(int k = nextin.length() - 1 ; k >= 0 ; k -- )
                    pareStack.push(nextin.charAt(k));
 
            }else{
                pareStack.push(s.charAt(i));
            }
        }
        while(!pareStack.isEmpty()){
            result.insert(0, pareStack.pop());
        }
        return result.toString();
    }
}