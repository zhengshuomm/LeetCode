/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/triangle
@Language: Java
@Datetime: 16-09-18 01:45
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */

    public int minimumTotal(int[][] triangle) {
        if(triangle == null) return 0;
        if(triangle.length == 0) return 0;
        
        // write your code here
        int n = triangle.length;
        int [][] sum = new int [n][n];
        
        for(int i = 0 ; i < n ; i ++){
            sum[n - 1][i] = triangle[n - 1][i];
        }
        
        for(int i = n - 2; i >= 0 ; i --){
            for(int j = 0 ; j <= i ; j ++){
                sum[i][j] = triangle[i][j] + Math.min(sum[i + 1][j], sum[i + 1][j + 1]);
            }
        }
        
        
        return sum[0][0];
    }
    
    
    
    
    
    
    
    public int devide(int[][] triangle, int x, int y){
        devide(triangle, 0 , 0);
        
        if(x == triangle.length){
            return 0; 
        }
        
        int left = devide(triangle, x + 1 , y);
        int right = devide(triangle, x + 1 , y + 1);
        
        return Math.min(left, right) + triangle[x][y];
    }
    
    
    
/*    public void helper(int[][] triangle, int x, int y, int sum){
        int best = Integer.MAX_VALUE;
        helper(triangle, 0, 0, triangle[0][0]);
        return ;
        
        if(x == triangle.length - 1){
            if(sum < best)
                best = sum;
            return;
        }
        
        helper(triangle, x + 1, y, sum + triangle[x + 1][y]);
        helper(triangle, x + 1, y + 1, sum + triangle[x + 1][y + 1]);

    }*/
}
