/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/two-sum-closest
@Language: Java
@Datetime: 16-10-07 00:40
*/

public class Solution {
    /**
     * @param nums an integer array
     * @param target an integer
     * @return the difference between the sum and the target
     */
    public int twoSumCloset(int[] nums, int target) {
        // Write your code here
        if(nums == null || nums.length < 2) return -1;
        Arrays.sort(nums);
        int i = 0 ; int j = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(i < j){
            if(nums[i] + nums[j] == target){
                return 0;
            }
            
            if(Math.abs(nums[i] + nums[j] - target) < min)
                min = Math.abs(nums[i] + nums[j] - target) ;
            
            if(nums[i] + nums[j] < target){
                i ++;
            }else{
                j --;
            }
        }
        return min;
    }
}