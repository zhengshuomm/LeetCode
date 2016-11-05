/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/string-permutation-ii
@Language: Java
@Datetime: 16-10-23 04:26
*/

public class Solution {
    /**
     * @param str a string
     * @return all permutations
     */
    public List<String> stringPermutation2(String str) {
        // Write your code here
        List<String> result = new ArrayList<String>();
        char [] instr = str.toCharArray();
        Arrays.sort(instr);
        StringBuilder cur = new StringBuilder();
        boolean [] visited = new boolean [str.length()];
        DFS(result, visited, instr, cur);
        return result;
    }
    
    public void DFS(List<String> result, boolean [] visited,char [] instr  , StringBuilder cur){
        if(cur.length() == instr.length){
            result.add(cur.toString());
            return;
        }
        
        for(int i = 0 ; i < instr.length ; i ++){
            if(i > 0 && instr[i] == instr[i - 1] && !visited[i - 1])
                continue;
            if(!visited[i]){
                cur.append(instr[i]);
                visited[i] = true;
                DFS(result, visited, instr, cur);
                cur = cur.deleteCharAt(cur.length() - 1);
                visited[i] = false;
            }
        }
    }
}