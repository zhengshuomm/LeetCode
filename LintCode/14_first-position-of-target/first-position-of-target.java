/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/first-position-of-target
@Language: Java
@Datetime: 16-09-08 00:16
*/

class Solution {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        long left = 0;
        long right = nums.length - 1;
        while (left + 1 < right){
            int mid = (int)(left +(right - left) / 2);
            if(nums[mid] == target){
                right = mid;
            }else if(nums[mid] < target){
                left = mid;
            }else right = mid;
        }
        if(nums[(int)left] == target)
            return (int)left;
        if(nums[(int)right] == target)
            return (int)right;
        
        
        return -1;
    }
}
