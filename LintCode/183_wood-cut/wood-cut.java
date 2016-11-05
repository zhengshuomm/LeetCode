/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/wood-cut
@Language: Java
@Datetime: 16-09-08 01:03
*/

public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0) return 0;
        int max = 0;
        for(int i = 0 ; i < L.length ; i++){
            max = Math.max(L[i],max);
        }
        int start = 1, end = max;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            int cur = count(L, mid);
            if(cur >= k){
                start = mid;
            }else end = mid;
        }
        
        if(count(L, end) >= k) return end;
        if(count(L, start) >= k) return start;
        return 0;
        
    }
    
    
    private int count(int[] L, int len){
        int result = 0;
        for(int i = 0 ; i < L.length ; i ++){
            result += L[i] / len;
        }
        return result;
    }
}