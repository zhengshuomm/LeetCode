/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/total-occurrence-of-target
@Language: Java
@Datetime: 16-09-09 20:41
*/

public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        if (A == null || A.length == 0) return 0;
		int low = -1;
		int high = -1;
		int start = 0;
		int end = A.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(A[mid] > target){
				end = mid;
			}else if (A[mid] < target)
				start = mid;
			else
				end = mid;
		}
		if(A[start] == target) low = start;
		else if(A[end] == target) low = end;
		if(low == -1)	return 0;
        start = low;
        end = A.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(A[mid] > target){
				end = mid;
			}else if (A[mid] < target)
				start = mid;
			else
				start = mid;
		}
		if(A[end] == target) high = end;
		else if(A[start] == target) high = start;
		
		if(low == -1)	return 0;
		return (high - low + 1);
        
    }
}