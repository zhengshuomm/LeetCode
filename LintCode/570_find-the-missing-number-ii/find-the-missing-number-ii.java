/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/find-the-missing-number-ii
@Language: Java
@Datetime: 16-09-18 22:40
*/

public class Solution {
    /**
     * @param n an integer
     * @param str a string with number from 1-n
     *            in random order and miss one number
     * @return an integer
     */
    public int findMissing2(int n, String str) {
        // Write your code here
        if(str == null)
            return -1;
        int [] count = new int [10];
        for(int i = 1 ; i <= n ; i ++){
            if(i < 10){
                count[i] ++;
            }else{
                count[i / 10] ++;
                count[i % 10] ++;
            }
        }
        
        for(int j = 0  ; j < str.length() ; j ++)
        {
        	count[str.charAt(j) - '0'] --;
        }	
        int first = 0;
        int second = 0;
        int two = 0;
        for(int i = 0 ; i < 10 ; i ++){
        	if(count[i] == 1){
        		if(first == 0)
        			first = i;
        		else second = i;
        	}
        	if(count[i] == 2)
        		two = i;
        }
        if(two != 0){
        	return two * 10 + two;
        }
        
        if(second == 0){
        	return first;
        }else if(second > 3){
        	return first * 10 + second;
        }else if(second == 3){
        	if(first == 0){
        		return first + second * 10;
        	}else return  first * 10 + second;
        }else{
        	if(second * 10 + first > n){
        		return first * 10 + second;
        	}else{
        		return second * 10 + first;        		
        	}
        }        		

    }
}