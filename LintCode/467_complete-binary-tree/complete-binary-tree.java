/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/complete-binary-tree
@Language: Java
@Datetime: 16-09-15 02:28
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
class Result{
    public int depth;
    public boolean isComplete, isFull;
    public Result(int depth, boolean isComplete, boolean isFull){
        this.depth = depth;
        this.isComplete = isComplete;
        this.isFull = isFull;
    }
} 
 
 
public class Solution {
    /**
     * @param root, the root of binary tree.
     * @return true if it is a complete binary tree, or false.
     */
     
     
    public boolean isComplete(TreeNode root) {
        // Write your code here
        Result result = helper(root);
        return result.isComplete;
    }
    
    public Result helper(TreeNode root){
        if(root == null){
            return new Result(0, true, true);
        }
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        //if full -- must complete
        //if left complete right full
        //if left full right can be complete
        if( !left.isComplete){
            return new Result(-1, false, false);
        }
        
        if(left.depth == right.depth){
            if(!left.isFull || !right.isComplete){
                return new Result(-1, false, false);
            }
            return new Result(left.depth + 1, true, right.isFull);
        }
        
        if(left.depth == right.depth + 1){
            if( !right.isFull){
                return new Result(-1, false, false);
            }
            return new Result(left.depth + 1, true, false);
        } 
 
        
        return new Result(-1, false, false);
    }
}