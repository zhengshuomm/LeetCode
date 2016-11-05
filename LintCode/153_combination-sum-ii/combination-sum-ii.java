/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/combination-sum-ii
@Language: Java
@Datetime: 16-11-01 00:52
*/

public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null) return result;
        boolean [] visited = new boolean [num.length];
        Arrays.sort(num);
        DFS(result, num, target, visited,0, new ArrayList<Integer>());
        return result;
    }
    
    public void DFS(List<List<Integer>> result, int[] num, int target,  boolean [] visited,int start , List<Integer> seq){
        
        if(target == 0){
            result.add(new ArrayList<Integer>(seq));
            return;
        }
        for(int i = start ; i < num.length ; i ++){
            if(num[i] <= target){
                if(i != 0 && num[i] == num[i - 1] && !visited[i - 1])
                    continue;
                else{
                    seq.add(num[i]);
                    visited[i] = true;
                    DFS(result, num, target - num[i], visited,i+ 1, seq);
                    seq.remove(seq.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}