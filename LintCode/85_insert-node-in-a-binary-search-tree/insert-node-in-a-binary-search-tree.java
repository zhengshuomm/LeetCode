/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/insert-node-in-a-binary-search-tree
@Language: Java
@Datetime: 16-09-13 03:08
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
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        TreeNode head = root;
        TreeNode prev = null;
        while (root != null){
            prev = root;
            if (root.val > node.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        if (prev == null) return node; // root 起始为空
        if (prev.val > node.val){
            prev.left = node;
        }else{
            prev.right = node;
        }
        return head;
    }
}
