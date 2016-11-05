/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/tweaked-identical-binary-tree
@Language: Java
@Datetime: 16-09-12 03:07
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
     * @param a, b, the root of binary trees.
     * @return true if they are tweaked identical, or false.
     */
    public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        return helper(a, b);
    }
    
    public boolean helper(TreeNode a, TreeNode b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        if(a.val != b.val)
            return false;
        if(helper(a.left, b.left) && helper(a.right, b.right))
            return true;
        if(helper(a.left, b.right) && helper(a.left, b.right))
            return true;
        return false;
    }
}