/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/jump-game
@Language: Java
@Datetime: 16-09-17 21:34
*/

public class Solution {
    /**
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if(A == null || A.length <= 1)
            return true;
        
        //true: I can jump to i
        boolean [] canJump = new boolean[A.length];
        
        canJump[0] = true;
        
        for(int i = 1; i < A.length; i ++){
            for(int j = 0 ; j < i ; j ++){
                if(canJump[j] && A[j] >= (i - j) )
                    canJump[i] = true;
            }
        }
        
        return canJump[A.length - 1];
    }
}
