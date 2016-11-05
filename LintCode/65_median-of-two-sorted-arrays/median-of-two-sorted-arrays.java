/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/median-of-two-sorted-arrays
@Language: Java
@Datetime: 16-10-07 03:17
*/

class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        int lenA = A.length;
        int lenB = B.length;
        int total = lenA + lenB;
        if(total % 2 == 1)
            return help(A, 0 , B, 0 , total / 2 + 1);
        else{
            return (help(A, 0 , B, 0 , total / 2) + help(A, 0 , B, 0 , total / 2 + 1))/ 2;
        }
    }
    
    public double help(int[] A, int startA, int[] B, int startB, int len){
        if(startA >= A.length)
            return B[startB + len - 1];
        if(startB >= B.length)
            return A[startA + len - 1];
        if(len == 1)
            return Math.min(A[startA], B[startB]);
        int A_key = startA + len / 2 - 1 < A.length
		            ? A[startA + len / 2 - 1]
		            : Integer.MAX_VALUE;
		int B_key = startB + len / 2 - 1 < B.length
		            ? B[startB + len / 2 - 1]
		            : Integer.MAX_VALUE; 
		
		if (A_key < B_key) {
			return help(A, startA + len / 2, B, startB, len - len / 2);
		} else {
			return help(A, startA, B, startB + len / 2, len - len / 2);
		} 

    }
}
