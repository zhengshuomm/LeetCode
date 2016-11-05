/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/topological-sorting
@Language: Java
@Datetime: 16-10-21 15:32
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here        
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        if(graph.isEmpty() || graph.size() == 0) return result;
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(map.containsKey(neighbor)){
                    map.put(neighbor,map.get(neighbor) + 1);
                }else{
                    map.put(neighbor, 1);
                }
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        for(DirectedGraphNode node : graph){
            if(!map.containsKey(node)){
                queue.offer(node);
                result.add(node);
            }
        }

        while(!queue.isEmpty()){
            DirectedGraphNode node = queue.poll();
            for(DirectedGraphNode neighbor : node.neighbors){
                map.put(neighbor, map.get(neighbor) - 1);
                if(map.get(neighbor) == 0){
                    queue.offer(neighbor);
                    result.add(neighbor);
                }
            }
        }
        return result;
    }
}