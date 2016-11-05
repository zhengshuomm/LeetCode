/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/six-degrees
@Language: Java
@Datetime: 16-10-21 18:57
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { 
 *         label = x;
 *         neighbors = new ArrayList<UndirectedGraphNode>(); 
 *     }
 * };
 */
public class Solution {
    /**
     * @param graph a list of Undirected graph node
     * @param s, t two Undirected graph nodes
     * @return an integer
     */
    public int sixDegrees(List<UndirectedGraphNode> graph,
                          UndirectedGraphNode s,
                          UndirectedGraphNode t) {
        // Write your code here
         if(graph == null)
            return -1;
        if(s == t)
            return 0;
        Map<UndirectedGraphNode, Integer> map = new HashMap<UndirectedGraphNode, Integer>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(s);
        map.put(s,0);
        while(!queue.isEmpty()){
            UndirectedGraphNode node = queue.poll();
            int step = map.get(node);
            for(UndirectedGraphNode neighbor: node.neighbors){
                if(map.containsKey(neighbor))
                    continue;
                if(neighbor == t){
                    return step + 1;
                }
                map.put(neighbor, step + 1);
                queue.offer(neighbor);
            }
        }
        return -1;
    }
}