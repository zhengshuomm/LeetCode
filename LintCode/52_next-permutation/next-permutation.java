/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/next-permutation
@Language: Java
@Datetime: 16-10-31 02:43
*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return null;
        for(int i = nums.length - 2; i >= 0 ; i --){
            if(nums[i] < nums[i + 1]){
                for (int j = nums.length - 1 ; j > i ; j --){
                   if (nums[j] > nums[i]){
                       swap(nums, i, j);
                       Arrays.sort(nums, i + 1 , nums.length);
                       return nums;
                   }
                }
            }
        }
        
        Arrays.sort(nums);
        return nums;
        
    }
    
    public void swap(int[] nums, int i , int j){
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}