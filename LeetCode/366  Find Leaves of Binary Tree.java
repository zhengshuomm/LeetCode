/*

Given a binary tree, find all leaves and then remove those leaves. Then repeat the previous steps until the tree is empty.

Example:
Given binary tree 
          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].

Explanation:
1. Remove the leaves [4, 5, 3] from the tree

          1
         / 
        2          
2. Remove the leaf [2] from the tree

          1          
3. Remove the leaf [1] from the tree

          []         
Returns [4, 5, 3], [2], [1].


*/


public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	helper(result, root);
    	return result;
    }

    public int helper(List<List<Integer>> result, TreeNode root){
    	if(root == null)
    		return -1;
    	int left = helper(result, root.left);
    	int right = helper(result, root.right);
    	int cur = Math.max(left, right) + 1;
    	if(result.size() <= cur){
    		result.add(new ArrayList<Integer>());
    	}
    	list.get(cur).add(root.val);
    	return cur;
    }
}