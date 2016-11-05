/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/remove-duplicates-from-sorted-array-ii
@Language: Java
@Datetime: 16-10-30 01:17
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
        int pos = 0;
        int count = 1;
        for(int i = 1 ; i < nums.length ; i ++){
            if(nums[i] == nums[pos]){
                count ++;
                if(count <= 2){
                    nums[++ pos ] = nums[i];
                }
            }
            else{
                count = 1;
                nums[++ pos ] = nums[i];
            }
        }
        return pos + 1;
    }
}