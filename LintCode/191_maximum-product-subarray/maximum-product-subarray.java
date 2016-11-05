/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/maximum-product-subarray
@Language: Java
@Datetime: 16-10-09 18:53
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return 0;
        int result = nums[0];
        int [] max = new int [nums.length];
        int [] min = new int [nums.length];
        max[0] = min[0] = nums[0];
        for(int i = 1; i < nums.length; i ++){
            if (nums[i] > 0) {
                max[i] = Math.max(nums[i], max[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], min[i - 1] * nums[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(nums[i], min[i - 1] * nums[i]);
                min[i] = Math.min(nums[i], max[i - 1] * nums[i]);
            }
            
            result = Math.max(result, max[i]);
        }
        return result;
    }
}