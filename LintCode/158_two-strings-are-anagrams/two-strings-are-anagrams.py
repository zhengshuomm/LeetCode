# coding:utf-8
'''
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/two-strings-are-anagrams
@Language: Python
@Datetime: 16-11-05 19:24
'''

class Solution:
    """
    @param s: The first string
    @param b: The second string
    @return true or false
    """
    def anagram(self, s, t):
        # write your code here
        ss = [i for i in s]
        tt = [j for j in t]
        ss.sort()
        tt.sort()
        return "".join(ss) == "".join(tt)