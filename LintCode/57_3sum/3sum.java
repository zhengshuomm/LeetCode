/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/3sum
@Language: Java
@Datetime: 16-10-09 22:05
*/

public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(nums == null || nums.length < 3)
            return result;
        Arrays.sort(nums);
        
         for(int start = 0 ; start < nums.length - 2; start ++){
            if(start != 0 && nums[start] == nums[start - 1])
                continue;
            int i = start + 1;
            int j = nums.length - 1;
            while(i < j){
                int sum = nums[start] + nums[i] + nums[j];
                if(sum == 0){
                    ArrayList<Integer> seq = new ArrayList<Integer>();
                    seq.add(nums[start]);
                    seq.add(nums[i]);
                    seq.add(nums[j]);
                    result.add(seq);
                    i++;
                    j--;
                    while(i < j && nums[i] == nums[i - 1]) i++;
                    while(i < j && nums[j] == nums[j + 1]) j--;
                    
                    
                }else if(sum < 0) i ++;
                else j --;
                
            }
            
        }
        return result;
    }
}