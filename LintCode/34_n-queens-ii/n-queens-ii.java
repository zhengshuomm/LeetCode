/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/n-queens-ii
@Language: Java
@Datetime: 16-10-21 20:22
*/

class Solution {
    /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
    public static int resultQueen;
    public int totalNQueens(int n) {
        //write your code here
        if(n <= 0 || n == 2 || n == 3)
            return 0;
        if(n == 1)
            return n;
        
        int [] columnVal = new int [n];
        DFS(n,  columnVal, 0);
        return resultQueen;
    }

    public void DFS(int n,  int [] columnVal, int row){
        if(row == n){
            resultQueen ++;
            return;
        }
        for(int i = 0 ; i < n; i ++){
            columnVal[row] = i;
            if(isValid(row, columnVal)){
                DFS(n, columnVal, row + 1);
            }
        }

    }

    public boolean isValid(int row, int [] columVal){
        for(int i = 0 ; i < row; i ++){
            if(columVal[i] == columVal[row] || (Math.abs(columVal[i] - columVal[row]) == Math.abs(i - row)))
                return false;
        }
        return true;
    }


        
};

