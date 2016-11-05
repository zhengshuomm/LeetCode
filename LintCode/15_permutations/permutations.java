/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/permutations
@Language: Java
@Datetime: 16-09-07 22:12
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null) return result;

        DFS(result, nums, new ArrayList<Integer>());
        return result;
    }
    
    public void DFS(List<List<Integer>> result, int[] nums, List<Integer> seq){
        if(seq.size() == nums.length){
            result.add(new ArrayList<Integer>(seq));
            return;
        }
        for(int i = 0; i < nums.length; i ++){
            if(seq.contains(nums[i]))
                continue;
            seq.add(nums[i]);
            DFS(result,nums,seq);
            seq.remove(seq.size() - 1);
        }
    }
}
