/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/merge-sorted-array
@Language: Java
@Datetime: 16-10-06 03:47
*/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int total = m + n - 1;
        while(m > 0 && n > 0){
            if(A[m - 1] > B[n - 1]){
                A[total --] = A[(m --) - 1];
            }else{
                A[total --] = B[(n --) - 1];
            }
        }
        if(n == 0)
            return;
        System.arraycopy(B, 0 , A, 0, total + 1);
        return;
    }
}