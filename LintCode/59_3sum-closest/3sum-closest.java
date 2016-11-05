/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/3sum-closest
@Language: Java
@Datetime: 16-10-29 23:57
*/

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        if(numbers == null || numbers.length == 0)
            return target;
        int min = Integer.MAX_VALUE;
        Arrays.sort(numbers);
        for(int i = 0 ; i < numbers.length - 2; i ++ ){
            int mid = i + 1;
            int last = numbers.length - 1;
            while(mid < last){
                int diff = numbers[i] + numbers[mid] + numbers[last] - target;
                if(Math.abs(diff) < Math.abs(min))
                    min = diff;
                if(diff < 0){
                    mid ++;
                }else{
                    last --;
                }
            }
        }
        return min + target;
    }
}
