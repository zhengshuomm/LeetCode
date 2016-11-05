/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/intersection-of-two-arrays
@Language: Java
@Datetime: 16-10-06 02:23
*/

public class Solution {
    /**
     * @param nums1 an integer array
     * @param nums2 an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // Write your code here
        if(nums1 == null || nums1.length == 0) return nums1;
        if(nums2 == null || nums2.length == 0) return nums2;
        HashSet<Integer> set1 = new HashSet<Integer>();
        for(int num1 : nums1){
            set1.add(num1);
        }
        
        HashSet<Integer> set2 = new HashSet<Integer>();
        for(int num2 : nums2){
            if(set1.contains(num2)){
                set2.add(num2);
            }
        }        
        int [] result = new int [set2.size()];
        int index = 0;
        for(Integer cur : set2){
            result[index ++] = cur;
        }
        return result;
    }
}