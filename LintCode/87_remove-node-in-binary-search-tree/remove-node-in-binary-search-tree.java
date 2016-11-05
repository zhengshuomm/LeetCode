/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/remove-node-in-binary-search-tree
@Language: Java
@Datetime: 16-09-18 15:07
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
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here

			TreeNode god = new TreeNode(Integer.MAX_VALUE);
			god.left = root;
            TreeNode parent = god;
			while(root!= null && root.val != value){
				parent = root;
				if(root.val < value){
					root = root.right;
				}else
					root = root.left;
			}
        	if(root == null || root.val != value) return god.left;

			//left is null, parent.child is right
			if(root.left == null){
			    if(parent.val > root.val)
				    parent.left = root.right;
			    else parent.right = root.right;
				return god.left;
			}
			//left is not null, find precursor
			//left has no right child, left is precursor
			TreeNode left = root.left;
			TreeNode p = root;
			if(left.right == null){
			    if(parent.val > root.val){
			            parent.left = left;
			        }else{
			            parent.right = left;
			    }
			    if(root.right != null){
			        left.right = root.right;
			    }
			    return god.left;
			}
			
			//left has right child

			while(left.right != null){
				p = left;
				left = left.right;
			}
			//left is the precursor
			//precursor has no child(left child, precursor cannot have right child, precursor is right child of its parent)
			if(left.left == null){
			    root.val = left.val;
			    p.right = null;
			}else{
			    TreeNode precursorleft = left.left;
			    //precursorleft has no left child, left of node will be its new left
			    if(precursorleft.left == null){
			        p.right = null;
			        if(parent.val > root.val){
			            parent.left = precursorleft;
			            left.left = null;
			            precursorleft.left = root.left;
			        }else{
			            parent.right = precursorleft;
			            left.left = null;
			            precursorleft.left = root.left;
			        }
			    }
			    else{
			        TreeNode newleft = precursorleft;
			        while(newleft.left != null){
			                newleft = newleft.left;
			        }
			        p.right = null;
			        if(parent.val > root.val){
			            parent.left = precursorleft;
			            left.left = null;
			            newleft.left = root.left;
			        }else{
			            parent.right = precursorleft;
			            left.left = null;
			            newleft.left = root.left;
			        }
			    }       
			    
			}
			
			return god.left;
    }
}