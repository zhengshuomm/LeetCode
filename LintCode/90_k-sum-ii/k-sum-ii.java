/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/k-sum-ii
@Language: Java
@Datetime: 16-10-23 05:24
*/

public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return a list of lists of integer 
     */ 
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(A);
        DFS(result, A, k ,target, 0, new ArrayList<Integer>());
        return result;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>> result, int[] A, int k, int target,int start,  ArrayList<Integer> seq){
        if(k < 0)
            return;
        if(k == 0 && target == 0){
            result.add(new ArrayList<Integer>(seq));
            return;
        }
        
        for(int i = start ; i < A.length ;  i ++){
            if(k > 0 && target >= A[i]){
                seq.add(A[i]);
                DFS(result, A, k - 1, target - A[i], i + 1, seq );
                seq.remove(seq.size() - 1);
            }
        }
    }
}