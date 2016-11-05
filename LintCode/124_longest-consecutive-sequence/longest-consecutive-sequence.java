/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/longest-consecutive-sequence
@Language: Java
@Datetime: 16-10-19 02:11
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if(num == null || num.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<Integer>();
    
        for(int n : num){
            set.add(n);
        }
        int longest = 0;
        for(int i = 0 ; i < num.length ; i ++){
            int down = num[i] - 1;
            while(set.contains(down)){
                down --;
            }
            int up = num[i] + 1;
            while(set.contains(up)){
                up ++;
            }
            longest = Math.max(longest, up - down - 1);
        }
        
        return longest;
    }
}