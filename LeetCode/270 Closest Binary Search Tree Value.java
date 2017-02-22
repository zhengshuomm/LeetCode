//Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
//Note: Given target value is a floating point. You are guaranteed to have only one unique value in the BST that is closest to the target.

    public int closestValue(TreeNode root, double target) {
        // ????????
        TreeNode child = target < root.val ? root.left : root.right;
        if (child == null) return root.val;
        int childclosest = closestValue(child, target);
        return Math.abs(root.val - target) < Math.abs(childclosest - target) ? root.val : childclosest;
    }

    //II
//	Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.

    //         Note: Given target value is a floating point. You may assume k is always valid, that is: k = total nodes. You are guaranteed to have only one unique set of k values in the BST that are closest to the target. Follow up: Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?

    // Hint:

    // Consider implement these two helper functions: getPredecessor(N), which returns the next smaller node to N. getSuccessor(N), which returns the next larger node to N.

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Queue<Integer> klist = new LinkedList<Integer>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        // inorder
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            // a queue with size k
            // ????k?????
            if (klist.size() < k) {
                klist.offer(curr.val);
            } else {
                // 
                int first = klist.peek();
                if (Math.abs(first - target) > Math.abs(curr.val - target)) {
                    klist.poll();
                    klist.offer(curr.val);
                } else {
                    // ???????????,????????
                    break;
                }
            }
            // ???????
            if (curr.right != null) {
                curr = curr.right;
                while (curr != null) {
                    stk.push(curr);
                    curr = curr.left;
                }
            }
        }
        // ?????List,??LinkedList?????????
        return (List<Integer>) klist;
    }
