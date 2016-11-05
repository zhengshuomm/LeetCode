/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/first-bad-version
@Language: Java
@Datetime: 15-07-22 20:46
*/

/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge whether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if(n == 0)
            return -1;
        int start = 1;
        int end = n;
        int mid;
        int number = -1;
        while(start <= end){
            mid = start + (end - start)/2;
            if(!VersionControl.isBadVersion(mid)){
                start = mid + 1;
            }else{
                number = mid;
                end = mid - 1;
            }
        }
        return number;
    }
}

