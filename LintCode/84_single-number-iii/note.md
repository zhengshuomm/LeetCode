```
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/single-number-iii
@Language: Markdown
@Datetime: 16-11-01 01:44
```

1.通过遍历整个数组并求整个数组所有数字之间的 XOR，根据 XOR 的特性可以得到最终的结果为 AXORB = A XOR B；
2.通过某种特定的方式，我们可以通过 AXORB 得到在数字 A 和数字 B 的二进制下某一位不相同的位；因为A 和 B 是不相同的，所以他们的二进制数字有且至少有一位是不相同的。我们将这一位设置为 1，并将所有的其他位设置为 0，我们假设我们得到的这个数字为 bitFlag；
3.那么现在，我们很容易知道，数字 A 和 数字 B 中必然有一个数字与上 bitFlag 为 0；因为bitFlag 标志了数字 A 和数字 B 中的某一位不同，那么在数字 A 和 B 中的这一位必然是一个为 0，另一个为 1；而我们在 bitFlag 中将其他位都设置为 0，那么该位为 0 的数字与上 bitFlag 就等于 0，而该位为 1 的数字与上 bitFlag 就等于 bitFlag
4.现在问题就简单了，我们只需要在循环一次数组，将与上 bitFlag 为 0 的数字进行 XOR 运算，与上 bitFlag 不为 0 的数组进行独立的 XOR 运算。那么最后我们得到的这两个数字就是 A 和 B。