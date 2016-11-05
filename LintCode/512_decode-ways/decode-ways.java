/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/decode-ways
@Language: Java
@Datetime: 16-09-22 02:22
*/

public class Solution {
    /**
     * @param s a string,  encoded message
     * @return an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // Write your code here
        if(s == null || s.length() == 0)
            return 0;
        //# of decode ways until n
        int[] nums = new int[s.length() + 1];
        
        nums[0] = 1;
        nums[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                nums[i] = nums[i - 1];
            }
            
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                nums[i] += nums[i - 2];
            }
        }
        return nums[s.length()];        
    }
}