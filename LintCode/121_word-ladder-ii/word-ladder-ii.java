/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/word-ladder-ii
@Language: Java
@Datetime: 16-10-23 01:20
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        dict.add(start);
        dict.add(end);
        
        List<List<String>> result = new ArrayList<List<String>> ();
        if (start == null || end == null || start.length() == 0 || end.length() == 0 || start == end) return result;
        BFS(distance, start, end, dict);
        if(distance.size() > 1)
            DFS(start, end, result, distance, dict, new ArrayList<String>());
        return result;
    }
    
    public void DFS(String start, String end, List<List<String>> result, HashMap<String, Integer> distance, Set<String> dict ,  ArrayList<String> seq){
        if(start.equals(end)){
            seq.add(start);
            result.add(new ArrayList<String>(seq));
            seq.remove(seq.size() - 1);
            return;
        }
        
        int curDis = distance.get(start);
        List<String> expend = changeOne(start, dict);
        for(String next : expend){
            if(distance.containsKey(next) && distance.get(next) == curDis - 1){
                seq.add(start);
                DFS(next, end, result, distance, dict, seq);
                seq.remove(seq.size() - 1);
            }
        }
        
    }
    
    
    public void BFS(HashMap<String, Integer> distance, String start, String end, Set<String> dict){
        Queue<String> queue = new LinkedList<String>();
        queue.offer(end);
        distance.put(end, 0);
       
        
        while(!queue.isEmpty()){
            String cur = queue.poll();
            List<String> expend = changeOne(cur, dict);
            for(String next : expend){
                
                if(!distance.containsKey(next)){
                    distance.put(next, distance.get(cur) + 1);
                    queue.offer(next);
                }
            }
        }
        return ;
    }
    
    public List<String> changeOne(String cur ,  Set<String> dict){
        List<String> expansion = new ArrayList<String>();

        for (int i = 0; i < cur.length(); i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch != cur.charAt(i)) {
                    String expanded = cur.substring(0, i) + ch
                            + cur.substring(i + 1);
                    if (dict.contains(expanded)) {
                        expansion.add(expanded);
                    }
                }
            }
        }
        return expansion;
    }
    
    
    
    

}