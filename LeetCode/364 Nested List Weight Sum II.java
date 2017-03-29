/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
*
*Each element is either an integer, or a list -- whose elements may also be integers or other lists.*
*
*Example 1:
*Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
*
*Example 2:
*Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17) 
 */

 public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        // Write your code here
      Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
      int prev = 0;
      int total = 0;
      for(NestedInteger ni : nestedList){
        queue.offer(ni);
      }
      while(!queue.isEmpty()){
        int size = queue.size();
        int levelSum = 0;
        for(int i = 0 ; i < size; i ++){
          NestedInteger cur = queue.poll();
          if(cur.isInteger()) levelSum += cur.getInteger();
          List<NestedInteger> next = cur.getList();
          if(next != null){
            for(NestedInteger n : next){
              queue.offer(next);
            }
          }
          
        }
        prev += levelSum;
        total += pre;

      }
      return total;
    }
}
