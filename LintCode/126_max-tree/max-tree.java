/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/max-tree
@Language: Java
@Datetime: 16-10-23 22:15
*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if(A == null || A.length == 0)
            return null;
            
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(new TreeNode(A[0]));
        for(int i = 1 ; i < A.length ; i ++){
            if(A[i] < stack.peek().val){
                stack.push(new TreeNode(A[i]));
            }else{
                TreeNode min = stack.pop();
                while(!stack.isEmpty() && stack.peek().val < A[i]){
                    TreeNode secmin = stack.pop();
                    secmin.right = min;
                    min = secmin;
                }
                TreeNode cur = new TreeNode(A[i]);
                cur.left = min;
                stack.push(cur);
            }
        }
        TreeNode root = stack.pop();
        while(!stack.isEmpty()){
            TreeNode next = stack.pop();
            next.right = root;
            root = next;
        }
        
        return root;
    }
}