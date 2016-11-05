/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/clone-graph
@Language: Java
@Datetime: 16-10-23 01:19
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
                if(node == null)    return node;
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        map.put(node, root);
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(map.containsKey(neighbor)){
                    map.get(cur).neighbors.add(map.get(neighbor));
                }else{
                    UndirectedGraphNode nCopy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, nCopy);
                    map.get(cur).neighbors.add(nCopy);
                    queue.add(neighbor);
                }
            }
        }
        return root;
    }
}