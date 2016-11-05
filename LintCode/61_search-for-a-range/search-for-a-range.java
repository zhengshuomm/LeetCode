/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/search-for-a-range
@Language: Java
@Datetime: 16-09-09 03:01
*/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int [] result = new int [2];
        if(A == null || A.length == 0){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int start = 0;
        int end = A.length - 1;
        int low = -1;
        int high = -1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] < target){
                start = mid;
            }else if(A[mid] > target){
                end = mid;
            }else{
                end = mid;
            }
        }
        
        if(A[start]  == target) low = start;
        else if(A[end]  == target) low = end;

        
        start = 0;
        end = A.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid]  < target){
                start = mid;
            }else if(A[mid]  > target){
                end = mid;
            }else{
                start = mid;
            }
        }        
        
        if(A[end] == target) high = end;
        else if(A[start]  == target) high = start;        
        
        result[0] = low;
        result[1] = high;
        return result;
    }
}
