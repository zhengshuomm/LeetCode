/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-inorder-and-postorder-traversal
@Language: Java
@Datetime: 16-09-13 03:36
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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        return DFS(inorder,0,inorder.length-1, postorder,0,postorder.length - 1);
    }
    
    
    public TreeNode DFS(int[] inorder,int instart, int inend, int[] postorder, int poststart, int postend){
        if(instart > inend) return null;
        TreeNode root = new TreeNode(postorder[postend]);
        int mid = 0;
        for(int i = instart; i <= inend; i ++){
            if(inorder[i] == postorder[postend] ){
                mid = i;
                break;
            }
        }
        int left = mid - instart - 1;
        int right = inend - mid ;
        root.left = DFS(inorder,instart,mid - 1, postorder,poststart, poststart + left);
        root.right = DFS(inorder,mid + 1,inend, postorder,postend - right, postend - 1);
        return root;
    }
}