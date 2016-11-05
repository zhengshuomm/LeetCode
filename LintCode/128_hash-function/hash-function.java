/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/hash-function
@Language: Java
@Datetime: 16-10-10 04:00
*/

class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
        if(key == null || key.length == 0)
            return -1;
        long result = 0;
        for(int i = 0; i < key.length ; i ++){
            result = (result * 33 +  (int)key[i])% HASH_SIZE ;
        }
        
        return (int) (result);
    }
};