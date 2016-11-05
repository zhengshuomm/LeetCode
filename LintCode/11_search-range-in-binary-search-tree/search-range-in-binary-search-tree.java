/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/search-range-in-binary-search-tree
@Language: Java
@Datetime: 16-09-15 03:16
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
     * @param k1 and k2: range k1 to k2.
     * @return: Return all keys that k1<=key<=k2 in ascending order.
     */
    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
         return searchRangeRecur(root,k1,k2);
     }
 
     public ArrayList<Integer> searchRangeRecur(TreeNode cur, int k1, int k2){
         ArrayList<Integer> result = new ArrayList<Integer>();
         
         if(cur == null){
             return result;
         }
         if(k1 > k2){
             return result;
         }
         
         ArrayList<Integer> left = searchRangeRecur(cur.left, k1, Math.min(k2, cur.val - 1));
         ArrayList<Integer> right = searchRangeRecur(cur.right, Math.max(k1, cur.val + 1), k2);
         
         result.addAll(left);
         if(cur.val >= k1 && cur.val <= k2)
            result.add(cur.val);
         result.addAll(right);
         return result;
     }
}
