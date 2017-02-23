/**
 * Created by swang on 2/23/2017.
 *
 * YAHOO
 *
 * # Notation of tree: 'a : { b : { c }, d }'
 # Means ‘a’ is the root and it has two children ‘b’ and ‘d’, ’b’ has a child ‘c’,
 #     ‘c’ and ‘d’ are leaf nodes.
 # - how to represent the tree as list of records
 #     read the given tree from list of records
 # - giving back the object hierarchy from list of records. From 1point 3acres bbs
 #    list the given tree, as example returning: ‘b : { c }’, or any other way which show the hierarchy  . Waral ???????????,
 # - implement deletion of subtree:
 #     deleting b result: ‘a : { d }
 */
public class BSTprint {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode a1 = new TreeNode(3);
        TreeNode a2 = new TreeNode(7);
        TreeNode b1 = new TreeNode(4);
        TreeNode b2 = new TreeNode(6);
        TreeNode b3 = new TreeNode(1);
        root.left = a1;
        root.right = a2;
        a1.right = b1;
        a2.left = b2;
        a1.left = b3;
        System.out.println(print(root));
    }

    public static  String print(TreeNode root){
        StringBuilder res = new StringBuilder();
        DFS(root, res);
        return res.toString();
    }

    public static void DFS(TreeNode root, StringBuilder res){
        if(root == null)
            return;
        res.append(root.val);
        if(root.left == null && root.right == null){
            return;
        }

        res.append(":{");

        if(root.left != null && root.right != null){
            DFS(root.left, res);
            res.append(',');
            DFS(root.right, res);
        }else{
            DFS(root.left, res);
            DFS(root.right, res);
        }
        res.append('}');

    }



}


class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}