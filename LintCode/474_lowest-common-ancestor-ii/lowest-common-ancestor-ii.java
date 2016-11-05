/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/lowest-common-ancestor-ii
@Language: Java
@Datetime: 16-09-26 04:04
*/

/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */
public class Solution {
    /**
     * @param root: The root of the tree
     * @param A, B: Two node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
                                                 ParentTreeNode A,
                                                 ParentTreeNode B) {
        // Write your code here  
        ArrayList<ParentTreeNode> Apath = path(A);
        ArrayList<ParentTreeNode> Bpath = path(B);
        
        int numA = Apath.size() - 1;
        int numB = Bpath.size() - 1;
    
        ParentTreeNode result = null;
        while(numA >= 0 && numB >= 0){
            if(Apath.get(numA) != Bpath.get(numB))
                break;
            result = Apath.get(numA);
            numA --;
            numB --;
        }
        return result;
    }
    
    public ArrayList<ParentTreeNode> path(ParentTreeNode cur){
        ArrayList<ParentTreeNode> result = new ArrayList<ParentTreeNode>();
        while(cur != null){
            result.add(cur);
            cur = cur.parent;
        }
        return result;
    }
}
