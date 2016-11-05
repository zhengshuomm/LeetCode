```
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/delete-digits
@Language: Markdown
@Datetime: 16-10-31 01:23
```

用stack, 然后找第一个递减的值。
跟next permutation很像。 从这个数的左边开始，找第一个递减的位置所在。
这道题，删掉一个数，相当于用这个数后面的数代替这个数。所以后面这个数一定要比当前小才行。所以找的是第一个递减的位置，把大的那个数删了。