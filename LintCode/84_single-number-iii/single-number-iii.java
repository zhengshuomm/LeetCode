/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/single-number-iii
@Language: Java
@Datetime: 16-11-01 01:44
*/

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        List<Integer> result = new ArrayList<Integer>(Arrays.asList(0, 0));
        int n = 0 ;
        for (int x: A){
            n = n ^ x;
        }
        
        n = n & (~(n - 1));
        for (int x: A){
            if ((x & n) != 0){
                result.set(0, result.get(0) ^ x);
            }else{
                result.set(1, result.get(1) ^ x);
            }
        }
        return result;
    }
}
