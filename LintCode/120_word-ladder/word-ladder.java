/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/word-ladder
@Language: Java
@Datetime: 16-10-23 01:40
*/

public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
       if(start.equals(end)) return 1;
        HashMap<String, Integer> distance = new HashMap<String, Integer>();
        dict.add(end);
        dict.add(start);

        return BFS(distance, start, end, dict);
    }
    
    
    public int BFS(HashMap<String, Integer> distance, String start, String end, Set<String> dict){
        Queue<String> queue = new LinkedList<String>();
        queue.offer(end);
        distance.put(end, 1);

        while(!queue.isEmpty()){
            String cur = queue.poll();
            List<String> expend = changeOne(cur, dict);
            for(String next : expend){
                if(next.equals(start))
                    return distance.get(cur) + 1;
                if(!distance.containsKey(next)){
                    distance.put(next, distance.get(cur) + 1);
                    queue.offer(next);
                }
            }
        }
        return 0;
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