/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/n-queens
@Language: Java
@Datetime: 16-10-23 04:29
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        int[] cols = new int[n];
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        place(result, 0, cols, n);
         return result;
    }
    
    public void place(ArrayList<ArrayList<String>> result, int row, int[] cols, int n){
        if (row == n ){
            StringBuffer[] sbs = new StringBuffer[n];
            for (int i =  0 ; i < n ; i ++){
                sbs[i] = new StringBuffer();
                for (int  j = 0  ; j < n ; j ++){
                    sbs[i].append(".");
                }
            }
            ArrayList<String> list = new ArrayList<String>();
            for (int i = 0 ; i < n ; i ++){
                sbs[i].setCharAt(cols[i], 'Q');
                list.add(sbs[i].toString());
            }
            result.add(list);
            return;
            
        }
        for (int i = 0 ; i < n ; i ++){
            if (isValid(cols, row, i)){
                cols[row] = i;
                place(result, row + 1, cols, n);
            }
        }
    }
    
    public boolean isValid(int[] cols, int row1, int col1){
        for (int row2 = 0 ; row2 < row1 ; row2 ++){
            if (cols[row2] == col1){
                return false;
            }
            int diff1 = row1 - row2;
            int diff2 = Math.abs(col1 - cols[row2]);
            if (diff1 == diff2) return false;
        }
        return true;
    }
};
