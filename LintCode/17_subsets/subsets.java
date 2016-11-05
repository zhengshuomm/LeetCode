/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/subsets
@Language: Java
@Datetime: 16-09-07 02:01
*/

class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        DFS(result, nums,0,new ArrayList<Integer>());
        return result;
    }
    
    public void DFS(ArrayList<ArrayList<Integer>> result,int[] nums , int start, ArrayList<Integer> seq){
        result.add(new ArrayList<Integer>(seq));
        
        for(int i = start ; i < nums.length ; i++){
            seq.add(nums[i]);
            DFS(result,nums,i+1,seq);
            seq.remove(seq.size()-1);
        }
    }
}