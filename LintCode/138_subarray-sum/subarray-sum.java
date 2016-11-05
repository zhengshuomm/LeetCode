/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/subarray-sum
@Language: Java
@Datetime: 16-10-06 03:02
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) return null;
        ArrayList<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0 ; i < nums.length ; i ++){
            sum += nums[i];
            if (sum == 0){
                result.add(0);
                result.add(i);
                break;
            }
            if (map.containsKey(sum)){
                result.add(map.get(sum) + 1);
                result.add(i);
                break;
            }else{
                map.put(sum, i);
            }
        }
        return result;
    }
}