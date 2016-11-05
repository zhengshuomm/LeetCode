# coding:utf-8
'''
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/compare-strings
@Language: Python
@Datetime: 16-11-05 19:37
'''

class Solution:
    """
    @param A : A string includes Upper Case letters
    @param B : A string includes Upper Case letters
    @return :  if string A contains all of the characters in B return True else return False
    """
    def compareStrings(self, A, B):
        # write your code here
        if len(B) == 0:
            return True
        if len(A) == 0:
            return False
        count = [0 for i in range(26)]
        for i in A:
            count[ord(i) - 65] += 1
        for j in B:
            if count[ord(j) - 65] == 0:
                return False
            else: 
                count[ord(j) - 65] -= 1
        return True
            