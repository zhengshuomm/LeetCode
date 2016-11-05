/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/largest-rectangle-in-histogram
@Language: Java
@Datetime: 16-10-13 00:34
*/

public class Solution {
 /**
 * @param height: A list of integer
 * @return: The area of largest rectangle in the histogram
 */
 public int largestRectangleArea(int[] heights) {
 // write your code here
        if(heights == null || heights.length == 0);
        int area = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0 ; i < heights.length ; i ++){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
                stack.push(i);
            }else{
                int start = stack.pop();
                int width = stack.isEmpty() ? i : i -1-stack.peek();
                area = Math.max(area, heights[start] * width);
                i --;
            }
        }
            while(!stack.isEmpty()){
                int start = stack.pop();
                int width = stack.isEmpty() ? heights.length : heights.length - stack.peek() - 1;                
                area = Math.max(area, heights[start] * width);
            }
        return area;
    }
}
