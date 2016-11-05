/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/search-in-rotated-sorted-array-ii
@Language: Java
@Datetime: 16-09-10 20:25
*/

public class Solution {
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0)
            return false;
        int start = 0;
        int end = A.length  - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(A[mid] == target)
                return true;
            else if(A[start] == A[end] && A[start] == A[start]){
                start ++;
                end --;
            }else{
                if(A[start] <= A[mid]){
                    if(target <= A[mid] && target > A[start]){
                        end = mid;
                    }else{
                        start = mid;
                    }
                }else{
                    if(target >= A[mid] && target < A[end]){
                        start = mid;
                    }else{
                        end = mid;
                    }
                }
            }
        }
        if(A[start] == target) return true;
        if(A[end] == target) return true;
        return false;
        
        
        
        
        
        //return searchHelper(A, target, 0, A.length - 1);
    }
    
    public boolean searchHelper(int[] A, int target, int left, int right){
        if (left > right) return false;
        int mid = (left + right) / 2;
        if (A[mid] == target) return true;
        if (A[left] < A[mid]){
            if (A[left] <= target && target < A[mid]) return searchHelper(A, target, left, mid - 1);
            return searchHelper(A, target, mid + 1, right);
        }else if (A[left] > A[mid]){
            if (A[mid] < target && target <= A[right]) return searchHelper(A, target, mid + 1, right);
            return searchHelper(A, target, left, mid - 1);
        }else{
            if (A[mid] == A[right]){
                return searchHelper(A, target, left, mid - 1) || searchHelper(A, target, mid + 1, right);
            }else {
                return searchHelper(A, target, mid + 1, right);
            }
        }
    }
}

