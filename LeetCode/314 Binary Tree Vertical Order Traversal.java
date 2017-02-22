//Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).


    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        Queue<Position> queue = new LinkedList<Position>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
        queue.offer(new Position(root, 0));
        while(!queue.isEmpty()){
            Position pos = queue.poll();
            if(!map.containsKey(pos.column)){
                map.put(pos.column, new ArrayList<Integer>());
            }
            map.get(pos.column).add(pos.node.val);
            if(pos.node.left != null)  queue.offer(new Position(pos.node.left, pos.column - 1));
            if(pos.node.right != null)  queue.offer(new Position(pos.node.right, pos.column + 1));
        }
        int min = map.firstKey();
        int max = map.lastKey();
        for(int i = min ; i <= max; i ++){
            if(map.get(i) != null)
                res.add(map.get(i));
        }
        return res;
    }

    class Position {
        TreeNode node;
        int column;
        public Position(TreeNode node, int column){
            this.node = node;
            this.column = column;
        }
    }