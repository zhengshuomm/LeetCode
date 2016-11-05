/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/sort-colors
@Language: Java
@Datetime: 16-10-07 01:32
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return;
        int i = -1;
        int j = nums.length;
        int k = 0;
        while(k < j){
            if(nums[k] == 0){
                swap(nums, ++i, k);
                k ++;
            }else if(nums[k] == 2){
                swap(nums, k, --j);
            }else{
                k ++;
            }
        }
        return;
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}