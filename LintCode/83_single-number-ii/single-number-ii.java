/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/single-number-ii
@Language: Java
@Datetime: 16-11-01 01:14
*/

public class Solution {
	/**
	 * @param A : An integer array
	 * @return : An integer 
	 */
    public int singleNumberII(int[] A) {
        int[] counts = new int[32];
        for (int i = 0 ; i < A.length ; i ++){
            for (int j = 0;  j < 32 ; j ++){
                counts[j] += (A[i] >> j ) & 1;
            }
        }
        int result = 0;
        for (int i = 0 ; i < 32; i ++){
           result = ((counts[i] % 3) << i ) | result;
        }
        return result;
    }
}
