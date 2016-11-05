/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/permutations-ii
@Language: Java
@Datetime: 16-09-07 22:44
*/

class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of unique permutations.
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        // Write your code here
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null) return result;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        DFS(result, nums, visited, new ArrayList<Integer>());
        return result;
    }
    
    public void DFS(ArrayList<List<Integer>> result, int[] nums, boolean [] visited, ArrayList<Integer> seq){
        if(seq.size() == nums.length){
            result.add(new ArrayList<Integer>(seq));
            return;
        }
        for(int i = 0 ; i < nums.length; i ++){
            if (visited[i])
                continue;
            else if(i > 0 && (nums[i] == nums[i - 1] && !visited[i - 1]))
                continue;
            visited[i] = true;
            seq.add(nums[i]);
            DFS(result, nums, visited, seq);
            seq.remove(seq.size() - 1);
            visited[i] = false;
        }
    }
}


