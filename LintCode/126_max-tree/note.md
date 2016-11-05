```
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/max-tree
@Language: Markdown
@Datetime: 16-10-23 22:15
```

    public TreeNode maxTree(int[] A) {
        // write your code here
        
        if(A == null || A.length == 0)
            return null;
        return construct(A, 0 , A.length - 1);
    }
    
    public TreeNode construct (int[] A, int start, int end){
        if(start > end)
            return null;
        int max = findMaxIndex(A, start, end);
        TreeNode root = new TreeNode(A[max]);
            root.left = construct(A, start, max - 1);
            root.right = construct(A, max + 1, end);
        return root;
    }
    
    public int findMaxIndex(int[] A, int start, int end){
        if(start == end) return start;
        int max = start;
        for(int i = start ; i <= end ; i ++){
            if(A[i] > A[max]){
                max = i;
            }
        }
        return max;
    }