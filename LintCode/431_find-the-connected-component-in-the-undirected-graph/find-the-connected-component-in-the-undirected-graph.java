/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/find-the-connected-component-in-the-undirected-graph
@Language: Java
@Datetime: 16-10-23 03:06
*/

/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nodes == null || nodes.size() == 0) return result;
        HashSet<UndirectedGraphNode> visited = new HashSet<UndirectedGraphNode>();
        for(UndirectedGraphNode node : nodes){
            if(!visited.contains(node)){
                DFS(result, visited, node);
            }
        }
        return result;
    }
    
    public void DFS(List<List<Integer>> result, HashSet<UndirectedGraphNode> visited, UndirectedGraphNode node){
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        visited.add(node);
        List<Integer> seq = new ArrayList<Integer>();
        seq.add(node.label);
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(!visited.contains(neighbor)){
                    seq.add(neighbor.label);
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
        Collections.sort(seq);
        result.add(seq);
    }
}