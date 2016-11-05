/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/single-number
@Language: Java
@Datetime: 16-10-30 23:38
*/

public class Solution {
	/**
	 *@param A : an integer array
	 *return : a integer 
	 */
	public int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int n = A[0];
		for(int i = 1 ; i < A.length ; i ++){
		    n ^= A[i];
		}
        return n;
	}
}
