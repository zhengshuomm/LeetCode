/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/identical-binary-tree
@Language: Java
@Datetime: 16-09-12 01:20
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
     * @return true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // Write your code here
        if(a == null && b == null)
            return true;
        if(a == null || b == null || a.val != b.val)
            return false;
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
    

    
}