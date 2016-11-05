/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/maximum-subarray-ii
@Language: Java
@Datetime: 16-10-10 04:38
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0)
            return 0;
        int size = nums.size();
        int [] left = new int [size];
        int [] right = new int [size];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = 0;
        for(int i = 0 ; i < size ; i ++){
            sum += nums.get(i);
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            left[i] = max;
        }
        
        sum = 0;
        max = Integer.MIN_VALUE;
        min = 0;
        for(int i = size - 1 ; i >= 0 ; i --){
            sum += nums.get(i);
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
            right[i] = max;
        }
        max = Integer.MIN_VALUE;
        for(int i = 0; i < size - 1; i++){
            max = Math.max(max, left[i] + right[i + 1]);
        }
        return max;
    }
}

