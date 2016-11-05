/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/construct-binary-tree-from-preorder-and-inorder-traversal
@Language: Java
@Datetime: 16-09-13 03:33
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
         return DFS(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode DFS(int[] preorder,int pstart, int pend, int[] inorder, int instart, int inend){
        if(pstart > pend) return null;
        TreeNode root = new TreeNode(preorder[pstart]);
        int mid = 0;
        for(int i = instart ; i <= inend; i ++){
            if(inorder[i] == preorder[pstart]){
                mid = i ;
                break;
            }
        }
        int left = mid - instart - 1;
        int right = inend - mid;
        root.left = DFS(preorder,pstart+1,pstart+1+left,inorder,instart, mid - 1);
        root.right = DFS(preorder, pend - right + 1,pend,inorder,mid + 1, inend);
        return root;
    }
}