/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/product-of-array-exclude-itself
@Language: Java
@Datetime: 16-10-29 18:52
*/

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> result = new ArrayList<Long>();
        if(A == null || A.size() == 0)
            return result;
        long [] left = new long [A.size()];
        long [] right = new long [A.size()];
        left[0] = 1;
        for(int i = 1 ; i < left.length ; i ++){
            left[i] = left[i - 1] * A.get(i - 1);
        }
        right[right.length - 1] = 1 ; 
        for(int i = right.length - 2 ; i >= 0 ; i --){
            right[i] = right[i + 1] * A.get(i + 1);
        }
        
        for(int i = 0 ; i < A.size() ; i ++){
            result.add(left[i] * right[i]);
        }
        return result;
    }
}
