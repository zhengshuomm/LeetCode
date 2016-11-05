/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/binary-tree-path-sum
@Language: Java
@Datetime: 16-09-11 20:22
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
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // Write your code here
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        DFS(root, target, result, new ArrayList<Integer>());
        return result;
    }
    
    public void DFS(TreeNode root, int target, ArrayList<List<Integer>> result, ArrayList<Integer> seq){
        if(root == null)
            return;
        if(target == root.val && root.left == null && root.right == null){
            seq.add(root.val);
            //if(!result.contains(seq))
                result.add(new ArrayList<Integer>(seq));
            seq.remove(seq.size() - 1);
            return;
        }
        seq.add(root.val);
        DFS(root.left, target - root.val, result, seq);
        DFS(root.right, target - root.val, result, seq);
        seq.remove(seq.size() - 1);
        
    }
}