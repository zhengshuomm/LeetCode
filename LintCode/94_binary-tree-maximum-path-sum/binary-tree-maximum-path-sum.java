/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/binary-tree-maximum-path-sum
@Language: Java
@Datetime: 16-09-11 19:00
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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    private class ResultType {
        // root2any: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
        // any2any: 从树中任意到任意点的最大路径，这条路径至少包含一个点
        int root2any, any2any; 
        ResultType(int root2any, int any2any) {
            this.root2any = root2any;
            this.any2any = any2any;
        }
    }

    public int maxPathSum(TreeNode root) {
        // write your code here
        ResultType result = helper(root);
        return result.any2any;
    }
    
    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0, Integer.MIN_VALUE);
        }
        
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        int root2any = Math.max(left.root2any, right.root2any) + root.val;
        root2any = Math.max(root2any, 0);
        
        int any2any = Math.max(left.any2any, right.any2any);
        any2any = Math.max(any2any, left.root2any + right.root2any + root.val);
        
        return new ResultType(root2any, any2any);
        
    }
}