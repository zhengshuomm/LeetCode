/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array
@Language: Java
@Datetime: 16-09-08 01:37
*/

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] < nums[start] && nums[mid - 1] > nums[mid])
                return nums[mid];
            else if(nums[mid] < nums[start]) end = mid;
            else if(nums[mid] > nums[end]) start = mid;
            else end = mid;
        }
        if(nums[start] < nums[end]) return nums[start];
        else return nums[end];
    }
}