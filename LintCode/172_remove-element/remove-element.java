/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/remove-element
@Language: Java
@Datetime: 16-10-29 02:52
*/

public class Solution {
    /** 
     *@param A: A list of integers
     *@param elem: An integer
     *@return: The new length after remove
     */
    public int removeElement(int[] A, int elem) {
        // write your code here
        if(A == null || A.length == 0)
            return 0;
        int pre = -1;
        for(int i = 0 ; i < A.length ; i ++){
            if(A[i] != elem){
                ++ pre;
                int tmp = A[i];
                A[i] = A[pre];
                A[pre] = tmp;
            }
        }
        return pre + 1;
    }
}
