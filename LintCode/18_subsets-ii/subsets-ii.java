/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/subsets-ii
@Language: Java
@Datetime: 16-09-07 22:02
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> S) {
        // write your code here
        Collections.sort(S);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        DFS(result, S, new ArrayList<Integer>(), 0);
        return result;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> S, ArrayList<Integer> seq, int start){
        result.add(new ArrayList<Integer>(seq));
        
        int pre = Integer.MAX_VALUE;
        for(int i = start ; i < S.size(); i ++){
            if(i != start && pre == S.get(i)){
                continue;
            }
            pre = S.get(i);
            seq.add(S.get(i));
            DFS(result, S, seq, i + 1);
            seq.remove(seq.size() - 1);
            
        }
    }
}
