/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/palindrome-partitioning
@Language: Java
@Datetime: 16-10-21 15:04
*/

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<List<String>>();
        if(s.length() == 0) return result;
        DFS(s, result, 0, new ArrayList<String>());
        return result;
    }
    
    public void DFS(String s, List<List<String>> result, int start, ArrayList<String> seq){
        if(start == s.length()){
            result.add(new ArrayList<String>(seq));
            return;
        }
        
        for(int i = start ; i < s.length(); i ++){
            if(i == start || isPali(s, start, i )){
                seq.add(s.substring(start, i + 1));
                DFS(s, result, i + 1, seq);
                seq.remove(seq.size() - 1);
            }
        }
    }
    
    
    public boolean isPali (String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end))
                 return false;
            start ++;
            end --;
        }
        return true;
    }
}