/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/binary-representation
@Language: Java
@Datetime: 16-10-30 23:35
*/

public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        // write your code here
        if(n.indexOf(".") == -1){
            return parseInteger(n);
        }
        String [] par = n.split("\\.");
        String flt = parseFloat(par[1]);
        if(flt == "ERROR"){
            return "ERROR";
        }else if(flt.equals("") || flt.equals("0")){
            return parseInteger(par[0]);
        }
        return parseInteger(par[0]) + "." + flt;
    }
    
    public String parseFloat(String str){
        double d = Double.parseDouble("0." + str);
        String binary = "";
        HashSet<Double> set = new HashSet<Double>();
        while(d > 0){
            if (binary.length() > 32 || set.contains(d)) {
                return "ERROR";
            }
            if(set.contains(d))  return "ERROR";

            set.add(d);
            d = d * 2;

            if(d >= 1){
                binary += "1";
                d = d - 1;
            }else{
                binary += "0";
            }
        }
        return binary;
    }
    
    
    
    public String parseInteger(String str){
        if(str.equals("") || str.equals("0") )
            return "0";
        String binary = "";
        int n = Integer.parseInt(str);
        while(n > 0){
            binary = Integer.toString(n % 2) + binary;
            n = n / 2;
        }
        if(binary.length() > 32)
            return "ERROR";
        return binary;
    }
}