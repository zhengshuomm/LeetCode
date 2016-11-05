/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/combinations
@Language: Java
@Datetime: 16-10-31 17:02
*/

public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>>  result = new ArrayList<List<Integer>> ();
		DFS(result, n, k, 1, new ArrayList<Integer>());
		return result;
    }
    
    public void DFS(List<List<Integer>>  result, int n, int k, int start, List<Integer> seq){
        if(seq.size() == k){
            result.add(new ArrayList<Integer>(seq));
            return;
        }
        
        for(int i = start ; i <= n ; i ++){
            seq.add(i);
            DFS(result, n, k , i + 1, seq);
            seq.remove(seq.size() - 1);
        }
    }
}