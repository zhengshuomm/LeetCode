/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/merge-k-sorted-arrays
@Language: Java
@Datetime: 16-10-11 02:55
*/

public class Solution {
    /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
     
     
    public List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> res = new ArrayList<Integer>();
        if(arrays == null || arrays.length == 0 || arrays[0].length == 0)
            return res;
        int m = arrays.length;
        int n = arrays[0].length;

        PriorityQueue<ArrIndex> queue = new PriorityQueue<ArrIndex>(m, new Comparator<ArrIndex>(){
            public int compare(ArrIndex a, ArrIndex b){
                return a.num - b.num;
            }
        });
        

        for(int i = 0 ; i < m ; i ++){
            queue.add(new ArrIndex(arrays[i][0], i, 0));
        }
        while(!queue.isEmpty()){
            ArrIndex cur = queue.poll();
            int curx = cur.x;
            int cury = cur.y;
            res.add(arrays[curx][cury]);
            
            if(cury + 1 < arrays[curx].length){
                queue.add(new ArrIndex(arrays[curx][cury + 1], curx, cury + 1));
            }
        }
        
        return res;
    }
}

class ArrIndex {
    public int num;
    public int x;
    public int y;
    public ArrIndex(int num, int x, int y){
        this.num = num;
        this.x = x;
        this.y = y;
    }
}
