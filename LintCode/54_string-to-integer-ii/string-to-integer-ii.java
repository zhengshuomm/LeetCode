/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/string-to-integer-ii
@Language: Java
@Datetime: 16-10-29 02:33
*/

public class Solution {
    /**
     * @param str: A string
     * @return An integer
     */
    public int atoi(String str) {
        // write your code here
        if(str == null)
            return 0;
        str = str.trim();
        if(str.length() == 0)
            return 0;
        int index = 0;
        int sign = 1;
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        }
        long num = 0;
        for(int i = index ; i < str.length() ; i++){
            if(str.charAt(i) > '9' || str.charAt(i) < '0')
                break;
            num = num * 10 + str.charAt(i) - '0';
            if(num > Integer.MAX_VALUE)
                break;
        }
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)num * sign;
    }
}