/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/search-insert-position
@Language: Java
@Datetime: 16-09-07 22:58
*/

public class Solution {
    /** 
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0)
            return 0;
        int low = 0;
        int high = A.length - 1;
        while(low + 1 < high){
            int mid = low + (high - low) / 2;
            if(A[mid] == target) return mid;
            else if(A[mid] < target) low = mid;
            else high = mid;
        }
        if(target <= A[low]) return low;
        else if(target <= A[high]) return high;
        else return high + 1;
    }
}
