/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/largest-number
@Language: Java
@Datetime: 16-10-31 01:03
*/

public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        if(num == null || num.length == 0)
            return "";
        StringBuilder result = new StringBuilder();
        List<String> strlist = new ArrayList<String>();
        for(int i : num){
            strlist.add(Integer.toString(i));
        }
        Collections.sort(strlist, new StringComparator());
        if(strlist.get(0).equals("0"))
            return "0";
        for(String str : strlist){
            result.append(str);
        }
        return result.toString();
        
    }
    
    class StringComparator implements Comparator<String>{
        public int compare(String s1, String s2){
            return (s2 + s1).compareTo(s1 + s2);
        }
    }
}