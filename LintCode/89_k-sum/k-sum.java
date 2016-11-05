/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/k-sum
@Language: Java
@Datetime: 16-09-26 03:39
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        if(A == null)   return 0;
        //前i个数，取j个，达到k有多少种方法

        int [][][] f = new int [A.length + 1][k + 1][target + 1];
        
        for (int i = 0; i < A.length + 1; i++) {
            f[i][0][0] = 1;
        }
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    //f[i][j][t] = 0;
                    f[i][j][t] = f[i - 1][j][t];
                    if (t >= A[i - 1]) {
                        f[i][j][t] += f[i - 1][j - 1][t - A[i - 1]];
                    }
                } // for t
            } // for j
        }         
        return f[A.length][k][target];
    }
}
