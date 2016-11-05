/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/first-missing-positive
@Language: Java
@Datetime: 16-10-29 23:14
*/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here    
        int i = 0;
        while(i < A.length){
            if(A[i] != i + 1 && A[i] > 0 && A[i] < A.length && A[A[i] - 1] != A[i])
            {
                swap(A, i, A[i] - 1);
            }else{
                i ++;
            }
        }
        for(int j = 0 ; j < A.length ; j ++ ){
            if(A[j] != j + 1) return j + 1;
        }
        return A.length + 1;
    }
    
    public void swap(int[] A, int i ,int j){
        A[i] = A[i] ^ A[j];
        A[j] = A[i] ^ A[j];
        A[i] = A[i] ^ A[j];
    }
}