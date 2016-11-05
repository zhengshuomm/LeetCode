/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/jump-game-ii
@Language: Java
@Datetime: 16-09-17 22:40
*/

public class Solution {
    /**
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length == 0)
            return 0;
        
        int [] dp = new int [A.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        boolean [] canJump = new boolean [A.length];
        canJump[0] = true;
        dp[0] = 0;
        
        for(int i = 1; i < A.length ; i ++){
            for(int j = 0 ; j < i ; j ++){
                if(canJump[j] && A[j] >= i - j){
                    canJump[i] = true;
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        return dp[A.length - 1];
    }
}
