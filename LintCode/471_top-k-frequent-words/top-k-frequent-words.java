/*
@Copyright:LintCode
@Author:   siyang
@Problem:  http://www.lintcode.com/problem/top-k-frequent-words
@Language: Java
@Datetime: 16-10-17 03:46
*/

public class Solution {
    /**
     * @param words an array of string
     * @param k an integer
     * @return an array of string
     */
    public String[] topKFrequentWords(String[] words, int k) {
        // Write your code here
        if(words == null || k == 0)
            return new String[k];
        String[] result = new String[k];
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            }else{
                map.put(word, 1);
            }
        }
        
        PriorityQueue<Pair> heap = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                if(a.count != b.count){
                    return b.count - a.count;
                }else{
                    return a.key.compareTo(b.key);
                }
            }
        });
        
        for(String word : map.keySet()){
            Pair cur = new Pair(word, map.get(word));
            heap.offer(cur);
        }
        
        int index = 0;
        while(!heap.isEmpty() && index < k){
            result[index ++] = heap.poll().key;
        }
        return result;
    }
}

class Pair{
    String key;
    int count;
    public Pair(String key, int count){
        this.key = key;
        this.count = count;
    }
}