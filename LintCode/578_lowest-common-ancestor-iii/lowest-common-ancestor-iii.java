/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-iii
@Language: Java
@Datetime: 16-09-18 21:56
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
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */

     
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if(root == null) return root;
        if(A == null || B == null)
            return root;
        if(!findNode(root, A) || !findNode(root, B)){
            return null;
        }
        return helper(root, A, B);
    }    
    
    public boolean findNode(TreeNode root, TreeNode A){
        if(root == null) return false;
        if(root == A) return true;
        boolean left = findNode(root.left, A);
        boolean right = findNode(root.right, A);
        if(left) return true;
        if(right) return true;
        return false;
    }
        
    public TreeNode helper(TreeNode root, TreeNode A, TreeNode B){    
        if(root == null || root == A || root == B){
             return root;
         }
        TreeNode left = helper(root.left, A, B);
        TreeNode right = helper(root.right, A, B);
        
        if(left != null && right != null){
             return root;
         }
         
         if(left != null){
             return left;
         }
         if(right != null){
             return right;
         }
         return null;
    }
}