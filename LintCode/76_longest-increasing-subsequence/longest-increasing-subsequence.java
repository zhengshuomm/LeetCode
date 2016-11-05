/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/longest-increasing-subsequence
@Language: Java
@Datetime: 16-09-17 23:52
*/

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[nums.length];
        
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i ++){
            for(int j = 0 ; j < i ; j ++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        
        int max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(max < dp[i])
                max = dp[i];
        }
        
        return max;
    }
}

