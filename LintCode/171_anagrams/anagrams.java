/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/anagrams
@Language: Java
@Datetime: 16-11-02 20:11
*/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z
    
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) {
                key *= prime[c - 'a'];
            }
            List<String> t;
            if (map.containsKey(key)) {
                t = res.get(map.get(key));
            } else {
                t = new ArrayList<>();
                res.add(t);
                map.put(key, res.size() - 1);
            }
            t.add(s);
        }
        List<String> result = new ArrayList<String>();
        for(List<String> cur : res){
            if(cur.size() > 1){
                result.addAll(cur);
            }
        }
        return result;
    }
}