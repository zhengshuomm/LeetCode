/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/top-k-largest-numbers-ii
@Language: Java
@Datetime: 16-10-13 02:25
*/

public class Solution {
    PriorityQueue<Integer> minheap;
    int k;

    public Solution(int k) {
        // initialize your data structure here.
        this.k = k;
        this.minheap = new PriorityQueue<Integer>(k);
    }

    public void add(int num) {
        // Write your code here
        if(minheap.isEmpty() || minheap.size() < k){
            minheap.offer(num);
        }else{
            if(num > minheap.peek()){
                minheap.poll();
                minheap.offer(num);
            }
        }
            
    }

    public List<Integer> topk() {
        // Write your code here
        Iterator it = minheap.iterator();
        List<Integer> result = new ArrayList<Integer>();
        while (it.hasNext()) {
            result.add((Integer) it.next());
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }
};