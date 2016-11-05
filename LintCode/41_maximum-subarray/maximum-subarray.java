/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/maximum-subarray
@Language: Java
@Datetime: 16-10-06 04:01
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if(nums == null || nums.length == 0)
            return 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i ++){
            sum += nums[i];
            if(sum > max) max = sum;
            if(sum < 0 ) sum = 0;
        }
        return max;
    }
}