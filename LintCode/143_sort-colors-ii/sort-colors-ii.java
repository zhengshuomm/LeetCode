/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/sort-colors-ii
@Language: Java
@Datetime: 16-10-10 00:18
*/

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length == 0 || k < 2)
            return;
        int count = 0 ;
        int start = 0;
        int end = colors.length - 1;
        int min = 1;
        int max = k;
        while(count < k && min != max){
            int left = start;
            int right = end ;
            int runner = left;
            while(runner <= right){
                if(colors[runner] == min){
                    swap(left ++, runner ++, colors);
                }else if(colors[runner] == max){
                    swap( runner, right--, colors);
                }else if(colors[runner] < max && colors[runner] > min){
                    runner ++;
                }
            }
            
            count += 2;
            min ++;
            max --;
            start = left;
            end = right;
            //System.out.println(Arrays.toString(colors));
        }

    }
    
    
    void swap(int left, int right, int[] colors) {
        int tmp = colors[left];
        colors[left] = colors[right];
        colors[right] = tmp;
    }
}