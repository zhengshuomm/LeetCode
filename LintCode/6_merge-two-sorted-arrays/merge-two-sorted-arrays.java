/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/merge-two-sorted-arrays
@Language: Java
@Datetime: 16-10-09 01:07
*/

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int m = A.length;
        int n = B.length;
        int total = m + n - 1;
        int [] res = new int [total + 1];
        while(m > 0 && n > 0){
            if(A[m - 1] > B[n - 1]){
                res[total --] = A[(m --) - 1];
            }else{
                res[total --] = B[(n --) - 1];
            }
        }
        if(n == 0)
            System.arraycopy(A, 0 , res, 0, total + 1);
        else 
            System.arraycopy(B, 0 , res, 0, total + 1);
            
        return res;
    }
}