/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal
@Language: Java
@Datetime: 16-09-13 03:42
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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        boolean dir = true;
        while(!stack.isEmpty()){
            Stack<TreeNode> next = new Stack<TreeNode>();
            int size = stack.size();
            ArrayList<Integer> level = new ArrayList<Integer>();
            for(int i = 0 ; i < size ; i ++){
                TreeNode cur = stack.pop();
                level.add(cur.val);
                if(dir){
                    if(cur.left != null) next.push(cur.left);
                    if(cur.right != null) next.push(cur.right);   
                }else{
                    if(cur.right != null) next.push(cur.right);
                    if(cur.left != null) next.push(cur.left);                      
                }
            }
            dir = !dir;
            result.add(level); 
            stack = next;
        }
        return result;   
    }
}