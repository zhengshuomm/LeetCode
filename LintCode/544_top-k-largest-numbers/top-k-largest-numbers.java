/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers
@Language: Java
@Datetime: 16-10-11 02:28
*/

class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        // Write your code here
        int [] res = new int [k];
        if(nums == null || nums.length == 0)
            return res;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });
        
        for(int i = 0 ; i < nums.length ; i ++){
            queue.add(nums[i]);
        }
        for(int i = 0 ; i < k ; i ++){
            res[i] = queue.poll();
        }
        
        return res;
    }
};

