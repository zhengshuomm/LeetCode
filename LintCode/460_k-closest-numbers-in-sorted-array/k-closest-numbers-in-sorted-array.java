/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/k-closest-numbers-in-sorted-array
@Language: Java
@Datetime: 16-09-18 15:08
*/

public class Solution {
    /**
     * @param A an integer array
     * @param target an integer
     * @param k a non-negative integer
     * @return an integer array
     */
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // Write your code here
        int[] result = new int [k]; 
        if(A == null || A.length == 0)
            return A;
        if (k > A.length) {
            return A;
        }
        int start = 0;
        int end = A.length - 1;
        int left = -1;
        int right = -1;
        int mid = -1;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(A[mid] == target){
                start = mid;
                end = mid + 1;
            }else if(A[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }

        //System.out.println(start);
        for(int i = 0 ; i < result.length ; i ++){
            if(start < 0) result[i] = A[end ++];
            else if(end > A.length - 1) result[i] = A[start --];
            else if(Math.abs(A[start] - target) <= Math.abs(A[end] - target)){
                result[i] = A[start --];
            }else{
                result[i] = A[end ++];
            }
        }
        return result;
    }
}