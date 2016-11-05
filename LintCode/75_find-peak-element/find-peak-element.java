/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/find-peak-element
@Language: Java
@Datetime: 16-09-08 02:09
*/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A == null || A.length == 0) return -1;
        int start = 1, end = A.length - 2;
        while(start + 1 <  end) {
            int mid = (start + end) / 2;
            if(A[mid] < A[mid - 1]) {
                end = mid;
            } else if(A[mid] < A[mid + 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(A[start] < A[end]) {
            return end;
        } else { 
            return start;
        }
    }
}
