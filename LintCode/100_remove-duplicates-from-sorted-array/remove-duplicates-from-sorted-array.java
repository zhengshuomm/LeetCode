/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array
@Language: Java
@Datetime: 16-10-29 04:22
*/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0)
            return 0;
        int pre = 0;
        for(int i = 1; i < nums.length ; i ++){
            if(nums[i] == nums[pre])
                continue;
            else{
                nums[++ pre] = nums[i];
            }
        }
        return pre + 1;
    }
}