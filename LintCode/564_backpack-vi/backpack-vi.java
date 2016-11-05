/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/backpack-vi
@Language: Java
@Datetime: 16-09-25 22:43
*/

public class Solution {
    /**
     * @param nums an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    public int backPackVI(int[] nums, int target) {
        // Write your code here
        if(target == 0 || nums == null)
            return 0;
        //像硬币问题，但是无序
        int [] dp = new int [target + 1];
        dp[0] = 1;
        for(int j = 1 ; j <= target; j ++){
            for(int i = 0 ; i < nums.length ; i++){
                if(j >= nums[i] ){
                    dp[j] += dp[j - nums[i]];
                }    
            }
            
        }
        return dp[target];
    }
}