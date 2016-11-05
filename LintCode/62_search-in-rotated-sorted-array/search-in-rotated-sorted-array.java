/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array
@Language: Java
@Datetime: 16-09-08 02:26
*/

public class Solution {
    /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0) return -1;
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] == target) return mid;
            if(A[mid] > A[start]){
                if(target > A[mid]) start = mid;
                else if (target < A[start]) start = mid;
                else end = mid;
            }else{
                if(target <= A[mid]) end = mid;
                else if(target <= A[end]) start = mid;
                else end = mid;
            }
        }
        if(A[start] == target) return start;
        if(A[end] == target) return end;
        return -1;
    }
}
