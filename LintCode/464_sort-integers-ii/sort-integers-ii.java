/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/sort-integers-ii
@Language: Java
@Datetime: 16-10-23 23:36
*/

public class Solution {
    /**
     * @param A an integer array
     * @return void
     */
    public void sortIntegers2(int[] A) {
        // Write your code here
        quickSort(A, 0, A.length - 1);
    }
    
    public void quickSort(int[] A, int start, int end){
        if(start >= end)
            return;
        int pivot = end;
        int left = start - 1;
        int i = start; 
        while(i < end){
            if(A[i] < A[pivot]){
                swap(A, ++ left, i ++); 
            }else{
                i ++;
            }
        }
        int mid = left + 1;
        swap(A, ++left ,end);
        quickSort(A, start, mid - 1);
        quickSort(A, mid + 1, end);
    }
    
    public void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}