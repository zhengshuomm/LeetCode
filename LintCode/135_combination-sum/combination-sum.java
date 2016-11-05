/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/combination-sum
@Language: Java
@Datetime: 16-10-21 16:26
*/

public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        DFS(result, candidates, target, new ArrayList<Integer>(),0);
        return result;
    }
    
    public void DFS(List<List<Integer>> result, int[] candidates, int target, List<Integer> seq, int start){
        if(target == 0){
            result.add(new ArrayList<Integer>(seq));
            return;
        }
        
        for(int i = start ; i < candidates.length ; i++){
            if(candidates[i] >  target)
                break;
            if(i > 0 && candidates[i] == candidates[i - 1] )
                continue;
            seq.add(candidates[i]);
            DFS(result,candidates,target - candidates[i],seq, i);
            seq.remove(seq.size() -1);
        }
        
        
        
    }
}