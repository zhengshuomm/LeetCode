/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/partition-array
@Language: Java
@Datetime: 16-10-07 00:57
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums == null || nums.length == 0)
	        return 0;
	    int i = -1;
	    for(int j = 0 ; j < nums.length; j ++){
	        if(nums[j] < k){
	            int tmp = nums[j];
	            nums[j] = nums[++i];
	            nums[i] = tmp;
	        }
	    }
	    return ++i;
    }
}