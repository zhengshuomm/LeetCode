/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/majority-number
@Language: Java
@Datetime: 16-10-30 23:46
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0)
            return -1;
        int count = 1;
        int pre = nums.get(0);
        for(int i = 1 ; i < nums.size(); i ++){
            if(pre == nums.get(i)){
                count ++;
            }else{
                count --;
                if(count == 0){
                    pre = nums.get(i);
                    count = 1;
                }
            }
        }
        return pre;
    }
}