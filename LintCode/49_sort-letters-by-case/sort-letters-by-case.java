/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/sort-letters-by-case
@Language: Java
@Datetime: 16-10-10 01:14
*/

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if(chars == null || chars.length < 2)
            return; 
        int start = 0 ;
        int end = chars.length - 1;
        int runner = 0;
        while(runner <= end){
            if(chars[runner] - 'A' < 26){
                swap(chars, runner , end --);
                if(chars[runner] - 'a' >= 0 && chars[runner] - 'a' < 26)
                runner ++;
            }else{
                swap(chars, runner ++ , start ++);
            }
           // System.out.println(start);
        //    System.out.println(Arrays.toString(chars));
        }
        
        return;
    }
    
    public void swap(char [] nums, int i, int j){
        char tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        return;
    }
}
